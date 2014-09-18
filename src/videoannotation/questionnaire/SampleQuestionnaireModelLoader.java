package videoannotation.questionnaire;

/**
 *
 * @author Ankit Gupta
 */
public class SampleQuestionnaireModelLoader {
    
    public static QuestionnaireModel loadModel(){
        QuestionnaireModel model = new QuestionnaireModel();
        
        Question q1 = newQuestion();
        Answer a = newAnswer();
        Question q2 = newQuestion();
        
        model.addTransition(q1, a, q2);
        model.setFirstQuestion(q1);
        
        return model;
    }

    private static Answer newAnswer() {
        return new Answer(IdGenerator.nextId(), "Answer:" + IdGenerator.currentId());
    }

    private static Question newQuestion() {
        return new Question(IdGenerator.nextId(), "Question:" + IdGenerator.currentId());
    }
    
    private static class IdGenerator{
        private static long id = 0;
        
        private IdGenerator(){
            
        }
        
        public static long currentId(){
            return id;
        }
        
        public static long nextId(){
            return ++id;
        }
    }
    
}
