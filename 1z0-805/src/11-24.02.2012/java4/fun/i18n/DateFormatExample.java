package java4.fun.i18n;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatExample {

    public static void main(String...args){
        Locale[] locales = {Locale.UK, Locale.FRANCE, Locale.ITALY};
        Date date = new Date();
        String s;
        
        for(int i = 0 ; i < locales.length ; i++){
            s = SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, locales[i]).format(date);
            System.out.println(locales[i].getDisplayLanguage() + "\t : " + s);
        }
    }
}
