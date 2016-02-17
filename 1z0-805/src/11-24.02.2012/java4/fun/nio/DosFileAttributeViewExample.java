package java4.fun.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeViewExample {

    public static void main(String...args) throws IOException{
        Path a = Paths.get("test");
        if(Files.notExists(a))
            Files.createFile(a);
        
        DosFileAttributes attr = Files.readAttributes(a, DosFileAttributes.class);
        
        System.out.println("isReadOnly " + attr.isReadOnly());
        System.out.println("isHidden " + attr.isHidden());
        System.out.println("isArchive " + attr.isArchive());
        System.out.println("isSystem " + attr.isSystem());
        
        Files.setAttribute(a, "dos:hidden", true);
    }
}
