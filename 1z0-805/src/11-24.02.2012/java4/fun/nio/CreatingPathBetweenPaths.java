package java4.fun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPathBetweenPaths {

    public static void main(String...args){
        Path p1 = Paths.get("Users");
        Path p2 = Paths.get("also");
        Path p3 = Paths.get("Users/also/Desktop");
        
        Path p1_to_p2 = p1.relativize(p2);
        System.out.println(p1_to_p2.toUri());
        
        Path p2_to_p1 = p2.relativize(p1);
        System.out.println(p2_to_p1.toUri());
        
        Path p1_to_p3 = p1.relativize(p3);
        System.out.println(p1_to_p3.toUri());
        
        Path p3_to_p1 = p3.relativize(p1);
        System.out.println(p3_to_p1.toUri());
        
    }
}
