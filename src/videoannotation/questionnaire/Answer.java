package videoannotation.questionnaire;

/**
 *
 * @author Ankit Gupta
 */
public class Answer {
    private final String answerText;
    private final long id;
    
    public Answer(long id, String answerText){
        this.id = id;
        this.answerText = answerText;
    }

    public String getAnswerText() {
        return answerText;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Answer other = (Answer) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }   

    public long getId() {
        return id;
    }
}
