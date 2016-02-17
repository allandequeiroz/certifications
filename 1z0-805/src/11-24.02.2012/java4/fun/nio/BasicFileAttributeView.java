package java4.fun.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributeView {

    public static void main(String...args) throws IOException{
        Path a = Paths.get("test");
        if(Files.notExists(a))
            Files.createFile(a);
        
        BasicFileAttributes attr = Files.readAttributes(a, BasicFileAttributes.class);
        
        System.out.println("creationTime " + attr.creationTime());
        System.out.println("lastAccessTime " + attr.lastAccessTime());
        System.out.println("lastModifiedTime " + attr.lastModifiedTime());
        System.out.println("isDirectory " + attr.isDirectory());
        System.out.println("isOther " + attr.isOther());
        System.out.println("isRegularFile " + attr.isRegularFile());
        System.out.println("isSymbolicLink " + attr.isSymbolicLink());
        System.out.println("size " + attr.size());
        
        long currentTime = System.currentTimeMillis();
        FileTime ft = FileTime.fromMillis(currentTime);
        Files.setLastModifiedTime(a, ft);
        System.out.println("lastModifiedTime " + attr.lastModifiedTime());
        
        Files.delete(a);
    }
}
