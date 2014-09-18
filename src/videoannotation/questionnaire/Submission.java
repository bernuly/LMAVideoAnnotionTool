package videoannotation.questionnaire;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankit Gupta
 */
public class Submission {
    
    private final long participantId;
    private final List<Choice> choices;
    
    public Submission(long participantId){
        this.participantId = participantId;
        this.choices = new ArrayList<>();
    }
    
    public void addChoice(long questionId, long answerId){
        choices.add(new Choice(questionId, answerId));
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public long getParticipantId() {
        return participantId;
    }

    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Choice{
        private final long questionId;
        private final long answerId;

        private Choice(long questionId, long answerId) {
            this.questionId = questionId;
            this.answerId = answerId;
        }

        public long getQuestionId() {
            return questionId;
        }

        public long getAnswerId() {
            return answerId;
        }
    }
}
