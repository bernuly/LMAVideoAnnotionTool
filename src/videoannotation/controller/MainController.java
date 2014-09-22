package videoannotation.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ankit Gupta
 */
public class MainController {
    
    private static final MainController instance = new MainController();
    
    private MainController(){
    }
    
    private final List<Controller> controllers = new ArrayList<>();

    public static MainController getInstance() {
        return instance;
    }
    
    public void registerController(Controller controller){
        controllers.add(controller);
    }
    
    public void fireModeChange(VideoAnnotationWindowController.Mode oldMode, VideoAnnotationWindowController.Mode newMode){
        for(Controller c : controllers){
            c.modeChanged(oldMode, newMode);
        }
    }
}
