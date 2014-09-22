package videoannotation.controller;

/**
 *
 * @author Ankit Gupta
 */
public class ExperimentController {
    
    private final ExperimentController INSTANCE = new ExperimentController();
    
    private ExperimentController(){
    }

    public ExperimentController getInstance() {
        return INSTANCE;
    }    
}
