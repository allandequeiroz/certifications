package java4.fun.nio;

import java.io.IOException;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class WatchServiceExample {

    public static void main(String...args) throws IOException, InterruptedException{
        
        final FileSystem fileSystem = FileSystems.getDefault();
        
        try(final WatchService watchService = fileSystem.newWatchService()){
            
            final Map<WatchKey, Path> keyMap = new HashMap<>();
            
            for(final String arg : args.length > 0 ? args : new String[]{"."}){
                
                final Path path = Paths.get(arg);
                keyMap.put(path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE), path);
            }
            
            WatchKey watchKey = null;
            
            do{
                watchKey = watchService.take();
                
                final Path eventDir = keyMap.get(watchKey);
                
                for(final WatchEvent<?> event : watchKey.pollEvents()){
                    final WatchEvent.Kind kind = event.kind();
                    final Path eventPath = (Path) event.context();
                    System.out.println(eventDir + ": " + event.kind() + ": " + event.context());
                }
            }while(watchKey.reset());
        }
    }
}
