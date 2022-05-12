import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18NManager {
    final static Logger logger = Logger.getLogger(I18NManager.class);
    private static I18NManager instance;
    private final HashMap<String, ResourceBundle> cache;

    private I18NManager(){
        cache = new HashMap<>();
    }

    public static I18NManager getInstance(){
        if(instance==null) instance=new I18NManager();
        return instance;
    }

    public void clear(){

    }

    public String getText(String l, String w){
        ResourceBundle bundle = cache.get(l);
        
        if (bundle==null) {
            logger.info(l+" no està en cache");
            bundle = ResourceBundle.getBundle(l);
            cache.put(l, bundle);
        }
        else {
            logger.info(l+" sí està en cache");
        }
        return bundle.getString(w);

    }
}
