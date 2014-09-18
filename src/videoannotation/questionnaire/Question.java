package videoannotation.questionnaire;

/**
 *
 * @author Ankit Gupta
 */
public class Question {
    private final String questionText;
    private final long id;
    
    public Question(long id, String questionText){
        this.questionText = questionText;
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Question other = (Question) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public long getId() {
        return id;
    }
}
