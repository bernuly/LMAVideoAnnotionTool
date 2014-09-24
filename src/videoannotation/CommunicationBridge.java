package videoannotation;

/**
 *
 * @author Ankit Gupta
 */
public class CommunicationBridge {
    private VideoAnnotationApplication app;
    
    private CommunicationBridge(){
        
    }
    
    private static final CommunicationBridge instance = new CommunicationBridge();

    public static CommunicationBridge getInstance() {
        return instance;
    }
    
    public void setApplication(VideoAnnotationApplication app){
        this.app = app;
    }
    
    public void next(){
        app.next();
    }
}
