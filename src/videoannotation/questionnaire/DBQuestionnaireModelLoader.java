package videoannotation.questionnaire;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ankit Gupta
 */
public class DBQuestionnaireModelLoader {

    public static IQuestionnaireModel loadQuestionnaireModel() {

        QuestionnaireModel model = new QuestionnaireModel();

        String transitionTableQuery = "SELECT q1id,\n"
                + "       q1txt,\n"
                + "       aid,\n"
                + "       atxt,\n"
                + "       A2Q.Question_ID AS q2id\n"
                + "  FROM A2Q, \n"
                + "       ( \n"
                + "    SELECT Questions.Question_ID AS q1id,\n"
                + "           Questions.Question_text AS q1txt,\n"
                + "           Answers.Answer_ID AS aid,\n"
                + "           Answers.Answer_text AS atxt\n"
                + "      FROM Questions, \n"
                + "           Q2A, \n"
                + "           Answers\n"
                + "     WHERE Questions.Question_ID = Q2A.Question_ID \n"
                + "           AND\n"
                + "           Q2A.Answer_ID = Answers.Answer_ID \n"
                + ") \n"
                + "\n"
                + " WHERE A2Q.Answer_ID = aid\n"
                + "UNION\n"
                + "SELECT q1id,\n"
                + "       q1txt,\n"
                + "       aid,\n"
                + "       atxt,\n"
                + "       NULL AS q2id\n"
                + "  FROM A2Q, \n"
                + "       ( \n"
                + "    SELECT Questions.Question_ID AS q1id,\n"
                + "           Questions.Question_text AS q1txt,\n"
                + "           Answers.Answer_ID AS aid,\n"
                + "           Answers.Answer_text AS atxt\n"
                + "      FROM Questions, \n"
                + "           Q2A, \n"
                + "           Answers\n"
                + "     WHERE Questions.Question_ID = Q2A.Question_ID \n"
                + "           AND\n"
                + "           Q2A.Answer_ID = Answers.Answer_ID \n"
                + ") \n"
                + "\n"
                + " WHERE NOT EXISTS ( \n"
                + "           SELECT 1\n"
                + "             FROM A2Q\n"
                + "            WHERE aid = A2Q.Answer_ID \n"
                + "       );";
        System.out.println(transitionTableQuery);

        Connection connection = null;

        boolean firstQuestion = true;

        String connStr = "jdbc:sqlite::resource:resources/LMAtree.db";

        try {
            Class.forName("org.sqlite.JDBC");

            System.out.println("Connecting to " + connStr);

            connection = DriverManager.getConnection(connStr);

            Statement stmt = connection.createStatement();

            ResultSet questions = stmt.executeQuery("Select * from Questions");
            //add all the questions before hand
            while (questions.next()) {
                final Question question = new Question(questions.getString(1), questions.getString(2));
                model.addQuestion(question);
                if(firstQuestion){
                    model.setFirstQuestion(question);
                    firstQuestion = false;
                }
            }

            ResultSet transitions = stmt.executeQuery(transitionTableQuery);

            while (transitions.next()) {
                String q1id = transitions.getString("q1id");
                String aid = transitions.getString("aid");
                String atxt = transitions.getString("atxt");
                String q2id = transitions.getString("q2id");
                model.addTransition(model.getQuestionById(q1id), new Answer(aid, atxt), model.getQuestionById(q2id));
            }

        } catch (ClassNotFoundException ex) {
            System.err.println("Error occured: SQLITE driver not found");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return model;

    }

}
