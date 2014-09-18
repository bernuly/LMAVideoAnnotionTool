package videoannotation.questionnaire;

import java.util.Set;
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
public class QuestionnaireModelTest {
    
    public QuestionnaireModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addQuestion method, of class QuestionnaireModel.
     */
    @Test
    public void testAddQuestion() {
        System.out.println("addQuestion");
        Question q = null;
        QuestionnaireModel instance = new QuestionnaireModel();
        instance.addQuestion(q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTransition method, of class QuestionnaireModel.
     */
    @Test
    public void testAddTransition() {
        System.out.println("addTransition");
        Question q1 = null;
        Answer a = null;
        Question q2 = null;
        QuestionnaireModel instance = new QuestionnaireModel();
        instance.addTransition(q1, a, q2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNextQuestion method, of class QuestionnaireModel.
     */
    @Test
    public void testGetNextQuestion() {
        System.out.println("getNextQuestion");
        Question q = null;
        Answer a = null;
        QuestionnaireModel instance = new QuestionnaireModel();
        Question expResult = null;
        Question result = instance.getNextQuestion(q, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getQuestions method, of class QuestionnaireModel.
     */
    @Test
    public void testGetQuestions() {
        System.out.println("getQuestions");
        QuestionnaireModel instance = new QuestionnaireModel();
        Set<Question> expResult = null;
        Set<Question> result = instance.getQuestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstQuestion method, of class QuestionnaireModel.
     */
    @Test
    public void testSetFirstQuestion() {
        System.out.println("setFirstQuestion");
        Question q = null;
        QuestionnaireModel instance = new QuestionnaireModel();
        instance.setFirstQuestion(q);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstQuestion method, of class QuestionnaireModel.
     */
    @Test
    public void testGetFirstQuestion() {
        System.out.println("getFirstQuestion");
        QuestionnaireModel instance = new QuestionnaireModel();
        Question expResult = null;
        Question result = instance.getFirstQuestion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
