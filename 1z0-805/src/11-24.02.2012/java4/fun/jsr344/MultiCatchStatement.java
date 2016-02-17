package java4.fun.jsr344;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class MultiCatchStatement {

    public static void main(String...args){        
        String urlStr = "http://epractizelabs.com:80;enrolCourse.jsp?email=brian.christopher@epractizelabs.com";

        try{
            URL url = new URL(urlStr);
            InputStream is = url.openStream();
            is.close();
        }catch(RuntimeException | IOException e){
            System.out.printf(e.getMessage());
        }
    }
}
