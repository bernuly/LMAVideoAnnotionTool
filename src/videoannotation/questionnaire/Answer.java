package videoannotation.questionnaire;

import java.util.Objects;

/**
 *
 * @author Ankit Gupta
 */
public class Answer {
    private final String answerText;
    
    public Answer(String answerText){
        this.answerText = answerText;
    }

    public String getAnswerText() {
        return answerText;
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.answerText);
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
        if (!Objects.equals(this.answerText, other.answerText)) {
            return false;
        }
        return true;
    }
}
