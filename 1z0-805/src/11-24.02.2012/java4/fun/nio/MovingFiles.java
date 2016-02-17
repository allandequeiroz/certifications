package java4.fun.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MovingFiles {

    public static void main(String...args) throws IOException{
        Path a = Paths.get("move");
        Files.createFile(a);
        
        Path b = Paths.get("moved");
        
        Files.move(a, b, StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        
        System.out.format("%s moved to %s", a.toUri(), b.toUri());
    }
}
