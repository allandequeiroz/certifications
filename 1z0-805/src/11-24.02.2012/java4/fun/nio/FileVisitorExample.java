package java4.fun.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FileVisitorExample extends SimpleFileVisitor<Path> {
    
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(attrs.isSymbolicLink()){
            System.out.format("Symbolic link: %s ", file);
        
        }else if(attrs.isRegularFile()){
            System.out.format("Regular file: %s ", file);
        
        }else{
            System.out.format("Other: %s ", file);
        
        }
        
        System.out.format("(" + attrs.size() + " bytes)");
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.format("Directory : %s%n", dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.err.println(exc);
        return FileVisitResult.CONTINUE;
    }
   
    public static void main(String...args) throws IOException{
        Files.walkFileTree(Paths.get("."), new FileVisitorExample());
    }
}
