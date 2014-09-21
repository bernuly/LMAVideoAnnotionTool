package videoannotation.questionnaire;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ankit Gupta
 */
public class TransitiionTest {
    

    /**
     * Test of equals method, of class Transition.
     */
    @Test
    public void testEquals() {
        Question q = new Question(1, "Question");
        Answer a = new Answer(2, "Answer");
        Transition t1 = new Transition(q, a);
        Transition t2 = new Transition(q, a);
        assertEquals(t1, t2);
    }
    
        /**
     * Test of equals method, of class Transition.
     */
    @Test
    public void testHashCode() {
        Question q = new Question(1, "Question");
        Answer a = new Answer(2, "Answer");
        Transition t1 = new Transition(q, a);
        Transition t2 = new Transition(q, a);
        assertEquals(t1.hashCode(), t2.hashCode());
    }

    
}
