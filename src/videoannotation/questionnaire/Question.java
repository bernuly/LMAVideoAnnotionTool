package videoannotation.questionnaire;

import java.util.Objects;

/**
 *
 * @author Ankit Gupta
 */
public class Question {
    private final String questionText;
    
    public Question(String questionText){
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.questionText);
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
        if (!Objects.equals(this.questionText, other.questionText)) {
            return false;
        }
        return true;
    }    
}
