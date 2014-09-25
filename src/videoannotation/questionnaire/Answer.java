package videoannotation.questionnaire;

import java.util.Objects;

/**
 *
 * @author Ankit Gupta
 */
public class Answer {

    private final String answerText;
    private final String id;

    public Answer(String id, String answerText) {
        this.id = id;
        this.answerText = answerText;
    }

    public String getAnswerText() {
        return answerText;
    }

    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.answerText);
        hash = 97 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
