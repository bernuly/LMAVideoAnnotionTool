package videoannotation.controller;

/**
 *
 * @author Ankit Gupta
 */
public class ExperimentController implements Controller {
    
    private final ExperimentController INSTANCE = new ExperimentController();
    
    private ExperimentController(){
        
    }

    public ExperimentController getInstance() {
        return INSTANCE;
    }    

    @Override
    public void modeChanged(VideoAnnotationWindowController.Mode oldMode, VideoAnnotationWindowController.Mode newMode) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
