package videoannotation.questionnaire;

import java.util.Objects;

/**
 *
 * @author Ankit Gupta
 */
public class Transitiion {
    
    private final Question question;
    private final Answer answer;
    
    public Transitiion(Question q, Answer a){
        this.question = q;
        this.answer = a;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.question);
        hash = 83 * hash + Objects.hashCode(this.answer);
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
        final Transitiion other = (Transitiion) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        if (!Objects.equals(this.answer, other.answer)) {
            return false;
        }
        return true;
    }
    
    
    
}
