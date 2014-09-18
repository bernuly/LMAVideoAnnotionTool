package videoannotation.questionnaire;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ankit Gupta
 */
public class QuestionnaireModel implements IQuestionnaireModel{
    
    private final Set<Question> questions = new HashSet<>();
    private final Map<Transitiion, Question> transitionMap = new HashMap<>();
    private Question firstQuestion;

    @Override
    public void addQuestion(Question q) {
        questions.add(q);
    }

    @Override
    public void addTransition(Question q1, Answer a, Question q2) {
        transitionMap.put(new Transitiion(q1, a), q2);
    }

    @Override
    public Question getNextQuestion(Question q, Answer a) {
        return transitionMap.get(new Transitiion(q, a));
    }

    public Set<Question> getQuestions() {
        return questions;
    }
    
    public void setFirstQuestion(Question q){
        firstQuestion = q;
    }

    public Question getFirstQuestion() {
        return firstQuestion;
    }
}
