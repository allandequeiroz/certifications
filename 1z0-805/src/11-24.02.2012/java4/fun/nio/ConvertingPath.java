package java4.fun.nio;

import java.nio.file.Path;
import java.nio.file.Paths;


public class ConvertingPath {

    public static void main(String...args){
        Path p1 = Paths.get("/Users/also");
        System.out.format("%s%n", p1.toUri());
    }
}
