package videoannotation.questionnaire;

import java.util.Objects;

/**
 *
 * @author Ankit Gupta
 */
public class Question {

    private final String questionText;
    private final String id;

    public Question(String id, String questionText) {
        this.questionText = questionText;
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.questionText);
        hash = 59 * hash + Objects.hashCode(this.id);
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
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return id;
    }
}
