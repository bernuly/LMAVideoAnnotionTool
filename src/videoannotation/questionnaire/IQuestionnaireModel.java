package videoannotation.questionnaire;

/**
 *
 * @author Ankit Gupta
 */
public interface IQuestionnaireModel {

    public void addQuestion(Question q);

    public void addTransition(Question q1, Answer a, Question q2);

    public Question getNextQuestion(Question q, Answer a);

}
