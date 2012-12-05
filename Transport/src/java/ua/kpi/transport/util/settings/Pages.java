package ua.kpi.transport.util.settings;

import java.util.ResourceBundle;

/**
 *
 * @author harker777
 */
public class Pages {
    private static final String FILE_NAME = "ua.kpi.transport.util.settings.pages";
    private static ResourceBundle bundle = ResourceBundle.getBundle(FILE_NAME);
    
    private Pages(){
    }
    
    public static String getPage(String page){
        return bundle.getString(page.toUpperCase());
    }
}
