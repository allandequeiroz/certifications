package java4.fun.i18n;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberFormatExample {

    public void format(Locale currentLocale){
        Integer intNum = new Integer(9807544);
        Double doubleNum = new Double(99.99);
        String intNumOut, doubleNumOut;
        
        NumberFormat numberFormatter = NumberFormat.getNumberInstance(currentLocale);
        intNumOut = numberFormatter.format(intNum);
        doubleNumOut = numberFormatter.format(doubleNum);
        
        System.out.printf("Int : %s , Double : %s\n", intNumOut, doubleNumOut);
    }
    
    public static void main(String...args){
        Locale[] locales = new Locale[]{
            new Locale("fr","FR"), new Locale("de","DE"),
            new Locale("ca","CA"), new Locale("rs","RS"),
            new Locale("en","IN")
        };
        
        NumberFormatExample[] formate = new NumberFormatExample[locales.length];
        
        for(int i = 0 ; i < locales.length ; i++){
            formate[i] =  new NumberFormatExample();
            formate[i].format(locales[i]);
        }
    }
}
