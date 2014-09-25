package videoannotation.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import videoannotation.fxml.FXMLResourceLoader;
import videoannotation.questionnaire.Answer;
import videoannotation.questionnaire.DBQuestionnaireModelLoader;
import videoannotation.questionnaire.IQuestionnaireModel;
import videoannotation.questionnaire.Question;
import videoannotation.questionnaire.QuestionnaireModel;
import videoannotation.questionnaire.SampleQuestionnaireModelLoader;
import videoannotation.questionnaire.Submission;

/**
 *
 * @author Ankit Gupta
 */
public class VideoAnnotationWindowController implements Initializable, Controller {

    //private final IQuestionnaireModel questionnaireModel = SampleQuestionnaireModelLoader.loadModel();
    private final IQuestionnaireModel questionnaireModel = DBQuestionnaireModelLoader.loadQuestionnaireModel();
    private Question currentQuestion = null;
    private Answer selectedAnswer;
    private List<RadioButton> answerButtons = new ArrayList<RadioButton>();
    private Submission submission;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private MenuBar menuBar;

    @FXML
    private HBox playerArea;

    @FXML
    private HBox questionArea;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem preferencesMenuItem;

    @FXML
    private Label questionLabel;

    @FXML
    private VBox answersBox;

    @FXML
    private Button finishBtn;

    @FXML
    private Button nextBtn;

    @FXML
    private Label errorLabel;

    @FXML
    private RadioMenuItem debugMenuItem;

    @FXML
    private RadioMenuItem experimentMenuItem;

    @Override
    public void modeChanged(Mode oldMode, Mode newMode) {
        System.err.println("Mode Changed");
    }

    enum Mode {

        DEBUG, EXPERIMENT
    }

    private Mode mode = Mode.DEBUG;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MainController.getInstance().registerController(this);
        submission = new Submission(0);
        finishBtn.setVisible(false);
        debugMenuItem.setSelected(true);
        menuBar.prefWidthProperty().bind(anchorPane.widthProperty());
        try {
            Parent player1 = FXMLLoader.load(FXMLResourceLoader.class.getResource("Player.fxml"));
            playerArea.getChildren().add(player1);

            Parent player2 = FXMLLoader.load(FXMLResourceLoader.class.getResource("Player.fxml"));
            playerArea.getChildren().add(player2);
        } catch (IOException ex) {
            Logger.getLogger(VideoAnnotationWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

        closeMenuItem.setOnAction((ActionEvent e) -> {
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();
        });

        preferencesMenuItem.setOnAction((ActionEvent event) -> {
            try {
                Parent parent = FXMLLoader.load(FXMLResourceLoader.class.getResource("PreferencesDialog.fxml"));
                Scene scene = new Scene(parent);
                Stage stage = new Stage();
                stage.initModality(Modality.WINDOW_MODAL);
                stage.initOwner(anchorPane.getScene().getWindow());
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(VideoAnnotationWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Question firstQuestion = questionnaireModel.getFirstQuestion();
        currentQuestion = firstQuestion;
        questionLabel.setText(firstQuestion.getQuestionText());

        Set<Answer> answers = questionnaireModel.getAnswers(firstQuestion);

        displayAnswers(answers);

        nextBtn.setOnAction((ActionEvent e) -> {

            if (selectedAnswer == null) {
                errorLabel.setText("Please select an answer to continue");
                return;
            }

            //save the choice
            submission.addChoice(currentQuestion.getId(), selectedAnswer.getId());

            //remove previous radio buttons
            answerButtons.stream().forEach((RadioButton r) -> {
                answersBox.getChildren().remove(r);
            });

            //get the next question
            currentQuestion = questionnaireModel.getNextQuestion(currentQuestion, selectedAnswer);
            selectedAnswer = null;

            if (currentQuestion == QuestionnaireModel.NULL_QUESTION) {
                nextBtn.setVisible(false);
                questionLabel.setText("End of Questionnaire!");
                finishBtn.setVisible(true);
            } else {
                questionLabel.setText(currentQuestion.getQuestionText());
                final Set<Answer> nextAnswers = questionnaireModel.getAnswers(currentQuestion);
                displayAnswers(nextAnswers);
            }
        });

        finishBtn.setOnAction((ActionEvent e) -> {
            submission.save();
        });

        ToggleGroup modeToggleGrp = new ToggleGroup();
        debugMenuItem.setToggleGroup(modeToggleGrp);
        debugMenuItem.setUserData(Mode.DEBUG);
        experimentMenuItem.setToggleGroup(modeToggleGrp);
        experimentMenuItem.setUserData(Mode.EXPERIMENT);
        modeToggleGrp.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) -> {
            if (newValue != null) {
                restart((Mode) newValue.getUserData());
                MainController.getInstance().fireModeChange(oldValue == null ? null : (Mode) oldValue.getUserData(), (Mode) newValue.getUserData());
            }
        });

        anchorPane.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.ALT && mode == Mode.EXPERIMENT) {
                menuBar.setVisible(true);
            }
        });

        anchorPane.addEventFilter(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (event.getCode() == KeyCode.ALT && mode == Mode.EXPERIMENT) {
                menuBar.setVisible(false);
            }
        });
    }

    private void displayAnswers(Set<Answer> answers) {

        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {

            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                selectedAnswer = (Answer) newValue.getUserData();
            }
        });

        answers.stream().forEach((Answer a) -> {
            RadioButton answerButton = new RadioButton(a.getAnswerText());
            answerButton.setToggleGroup(toggleGroup);
            answerButton.setUserData(a);
            answerButtons.add(answerButton);
            answersBox.getChildren().add(answerButton);
        });
    }

    private void restart(Mode mode) {
        switch (mode) {
            case DEBUG:
                this.mode = Mode.DEBUG;
                menuBar.setVisible(true);

                break;
            case EXPERIMENT:
                this.mode = Mode.EXPERIMENT;
                menuBar.setVisible(false);
                break;
        }
    }
}
