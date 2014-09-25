package videoannotation.questionnaire;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Ankit Gupta
 */
public class QuestionnaireModel implements IQuestionnaireModel {

    private final Map<String, Question> questions = new HashMap<>();
    private final Map<Transition, Question> transitionMap = new HashMap<>();
    private final Map<Question, Set<Answer>> question2AnswerMap = new HashMap<>();
    private Question firstQuestion;

    public static final Question NULL_QUESTION = new Question("NULL", "NULL");

    @Override
    public void addQuestion(Question q) {
        if (q == null) {
            q = NULL_QUESTION;
        }

        questions.put(q.getId(), q);
    }

    @Override
    public void addTransition(Question q1, Answer a, Question q2) {
        if (q1 == null) {
            q1 = NULL_QUESTION;
        }

        if (q2 == null) {
            q2 = NULL_QUESTION;
        }

        //this will add the questions if not present already
        questions.put(q1.getId(), q1);
        questions.put(q2.getId(), q2);

        //update question2answer map
        Set<Answer> answers = question2AnswerMap.get(q1);
        if (answers == null) {
            answers = new HashSet<>();
            answers.add(a);
            question2AnswerMap.put(q1, answers);
        } else {
            answers.add(a);
        }

        transitionMap.put(new Transition(q1, a), q2);
    }

    @Override
    public Question getNextQuestion(Question q, Answer a) {
        return transitionMap.get(new Transition(q, a));
    }

    public Set<Question> getQuestions() {
        return new HashSet<>(questions.values());
    }

    public void setFirstQuestion(Question q) {
        firstQuestion = q;
    }

    @Override
    public Question getFirstQuestion() {
        return firstQuestion;
    }

    public Set<Answer> getAnswers(Question q) {
        return question2AnswerMap.get(q);
    }

    public Question getQuestionById(String id) {
        if (id == null) {
            return null;
        }
        return questions.get(id);
    }

}
