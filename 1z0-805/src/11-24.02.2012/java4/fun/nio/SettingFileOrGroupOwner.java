package java4.fun.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;

public class SettingFileOrGroupOwner {

    public static void main(String...args) throws IOException{
        Path a = Paths.get("move");
        Files.createFile(a);
        
        UserPrincipal owner = a.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("allan");
        Files.setOwner(a, owner);
        
        Files.delete(a);
    }
}
