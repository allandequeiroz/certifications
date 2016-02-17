package java4.fun.nio;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;


public class CreatingPath {

    public static void main(String...args){
        Path p1 = Paths.get("/tmp/htmlfiles");
        Path p2 = Paths.get(args[0]);
        Path p3 = Paths.get(URI.create("file:///D:/devtools/workspace"));
        Path p4 = Paths.get(System.getProperty("user.home"),"logs","traininglab.log");
        Path p5 = FileSystems.getDefault().getPath("/users/pop");
    }
}
