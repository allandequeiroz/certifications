package java4.fun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComparingTwoPaths {

    public static void main(String...args){
        Path a = Paths.get("Users");
        Path b = Paths.get("also");
        
        if(a.equals(b)){
            System.out.print("equals");
            
        }else if(a.startsWith(b)){
            System.out.print("startsWith");
        
        }else if(a.endsWith(b)){
            System.out.print("endsWith");
        
        }else{
            System.out.print("ne");
        
        }
    }
}
