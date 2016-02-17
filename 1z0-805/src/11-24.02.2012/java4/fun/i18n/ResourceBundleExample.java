package java4.fun.i18n;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceBundleExample {
    
    private Locale locale;
    private ResourceBundle bundle;
    
    public ResourceBundleExample(){
        bundle = ResourceBundle.getBundle("EPL_RES",Locale.getDefault());
    }
    
    public ResourceBundleExample(int language){
        switch(language){
            case 1:
                locale = new Locale("jp","JP");
                bundle = ResourceBundle.getBundle("EPL_RES",locale);
                break;
            case 2:
                locale = new Locale("ge","GE");
                bundle = ResourceBundle.getBundle("EPL_RES",locale);
                break;
            case 3:
                locale = new Locale("sp","SP");
                bundle = ResourceBundle.getBundle("EPL_RES",locale);
                break;
            default:
                bundle = ResourceBundle.getBundle("EPL_RES",locale);
                break;            
        }
    }
    
    public String getItemInLocale(String itemName){
        String res = bundle.getString(itemName);
        return res;
    }
}
