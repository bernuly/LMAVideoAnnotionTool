package videoannotation.questionnaire;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankit Gupta
 */
public class Submission {

    private final long participantId;
    private final List<Choice> choices;

    public Submission(long participantId) {
        this.participantId = participantId;
        this.choices = new ArrayList<>();
    }

    public void addChoice(String questionId, String answerId) {
        choices.add(new Choice(questionId, answerId));
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void save() {
        PrintWriter pw = null;
        try {
            File sampleSubmissionFile = new File("submission.txt");
            pw = new PrintWriter(sampleSubmissionFile);
            pw.println("Question,Answer");
            for (Choice c : choices) {
                pw.println(c.questionId + "," + c.answerId);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Submission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pw.close();
        }
    }

    public class Choice {

        private final String questionId;
        private final String answerId;

        private Choice(String questionId, String answerId) {
            this.questionId = questionId;
            this.answerId = answerId;
        }

        public String getQuestionId() {
            return questionId;
        }

        public String getAnswerId() {
            return answerId;
        }        
    }
}
