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
    private final Map<Question, Set<Answer>> question2AnswerMap = new HashMap<>();
    private Question firstQuestion;

    @Override
    public void addQuestion(Question q) {
        questions.add(q);
    }

    @Override
    public void addTransition(Question q1, Answer a, Question q2) {
        //this will add the questions if not present already
        questions.add(q1);
        questions.add(q2);
        
        //update question2answer map
        Set<Answer> answers = question2AnswerMap.get(q1);
        if(answers == null){
            answers = new HashSet<>();
            answers.add(a);
            question2AnswerMap.put(q1, answers);
        }else{
            answers.add(a);
        }
        
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

    @Override
    public Question getFirstQuestion() {
        return firstQuestion;
    }
    
    public Set<Answer> getAnswers(Question q){
        return question2AnswerMap.get(q);
    }
}
