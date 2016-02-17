package java4.fun.nio;

import java.nio.file.*;

public class PatchMatcherExample {

    public static void main(String...args){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{java}");
        
        Path file = Paths.get(".");
        if(matcher.matches(file)){
            System.out.println(file);
        }
    }
}
