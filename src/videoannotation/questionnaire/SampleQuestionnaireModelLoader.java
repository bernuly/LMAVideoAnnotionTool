package videoannotation.questionnaire;

/**
 *
 * @author Ankit Gupta
 */
public class SampleQuestionnaireModelLoader {

    public static QuestionnaireModel loadModel() {
        QuestionnaireModel model = new QuestionnaireModel();

        Question firstQuestion = newQuestion("Do you see a change?");
        model.setFirstQuestion(firstQuestion);

        Answer yes = newAnswer("Yes");
        Answer no = newAnswer("No");

        model.addTransition(firstQuestion, no, null);

        Question changeQuestion = newQuestion("What kind of change?");
        model.addTransition(firstQuestion, yes, changeQuestion);

        Answer phrasingAnswer = newAnswer("Phrasing");
        Question phrasingQuestion = newQuestion("What kind of phrasing change?");
        model.addTransition(changeQuestion, phrasingAnswer, phrasingQuestion);

        Answer effortAnswer = newAnswer("Effort");
        Question effortQuestion = newQuestion("What kind of effort change?");
        model.addTransition(changeQuestion, effortAnswer, effortQuestion);

        Answer spaceAnswer = newAnswer("Space");
        Question spaceQuestion = newQuestion("What kind of space change?");
        model.addTransition(changeQuestion, spaceAnswer, spaceQuestion);

        Answer shapeAnswer = newAnswer("Shape");
        Question shapeQuestion = newQuestion("What kind of shape change?");
        model.addTransition(changeQuestion, shapeAnswer, shapeQuestion);

        model.addTransition(phrasingQuestion, newAnswer("Impulsive"), null);
        model.addTransition(phrasingQuestion, newAnswer("Impactive"), null);
        model.addTransition(phrasingQuestion, newAnswer("Swing"), null);

        model.addTransition(effortQuestion, newAnswer("Light"), null);
        model.addTransition(effortQuestion, newAnswer("Strong"), null);
        model.addTransition(effortQuestion, newAnswer("Direct"), null);
        model.addTransition(effortQuestion, newAnswer("Indirect"), null);
        model.addTransition(effortQuestion, newAnswer("Bound"), null);
        model.addTransition(effortQuestion, newAnswer("Free"), null);
        model.addTransition(effortQuestion, newAnswer("Quick"), null);
        model.addTransition(effortQuestion, newAnswer("Sustained"), null);

        Question reachSpaceQuestion = newQuestion("What kind of reach space?");
        Question zoneQuestion = newQuestion("What kind of zone?");
        Answer reachSpaceAnswer = newAnswer("Reach space");
        Answer zoneAnswer = newAnswer("Zone");
        model.addTransition(spaceQuestion, reachSpaceAnswer, reachSpaceQuestion);
        model.addTransition(spaceQuestion, zoneAnswer, zoneQuestion);

        model.addTransition(reachSpaceQuestion, newAnswer("Near"), null);
        model.addTransition(reachSpaceQuestion, newAnswer("Mid"), null);
        model.addTransition(reachSpaceQuestion, newAnswer("Far"), null);

        model.addTransition(zoneQuestion, newAnswer("Up"), null);
        model.addTransition(zoneQuestion, newAnswer("Down"), null);
        model.addTransition(zoneQuestion, newAnswer("Forward"), null);
        model.addTransition(zoneQuestion, newAnswer("Backward"), null);
        model.addTransition(zoneQuestion, newAnswer("Side-Open"), null);
        model.addTransition(zoneQuestion, newAnswer("Side-Across"), null);

        model.addTransition(shapeQuestion, newAnswer("Rising"), null);
        model.addTransition(shapeQuestion, newAnswer("Sinking"), null);
        model.addTransition(shapeQuestion, newAnswer("Advancing"), null);
        model.addTransition(shapeQuestion, newAnswer("Retreating"), null);
        model.addTransition(shapeQuestion, newAnswer("Spreading"), null);
        model.addTransition(shapeQuestion, newAnswer("Enclosing"), null);

        return model;
    }

    private static Answer newAnswer(String text) {
        return new Answer(IdGenerator.nextId(), text);
    }

    private static Question newQuestion(String text) {
        return new Question(IdGenerator.nextId(), text);
    }

    private static class IdGenerator {

        private static long id = 0;

        private IdGenerator() {

        }

        public static String currentId() {
            return "" + id;
        }

        public static String nextId() {
            return "" + ++id;
        }
    }

}
