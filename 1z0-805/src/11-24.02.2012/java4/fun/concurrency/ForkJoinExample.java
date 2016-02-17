package java4.fun.concurrency;

import java.nio.file.Path;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExample {
    private final ForkJoinPool forkJoinPool = new ForkJoinPool();
    
    Long countOcurrencesInParall(Path folder, String searchedWord){
        return forkJoinPool.invoke(new FolderTextFilesSearchTask(null, null));
    }
    
    public static void main(String...args){
        ForkJoinExample wordCounter = new ForkJoinExample();
        System.out.println(wordCounter.countOcurrencesInParall(null,null));
    }
    
}

class WordSearchTask extends RecursiveTask<Long>{
    private final String content;
    private final String searchedWord;
    
    WordSearchTask(String content, String searchedWord){
        this.content = content;
        this.searchedWord = searchedWord;
    }

    @Override
    protected Long compute() {
        return occurrencesCount(content, searchedWord);
    }

    private Long occurrencesCount(String content, String searchedWord) {
        return 10L;
    }
}

class FolderTextFilesSearchTask extends RecursiveTask<Long>{
    private final Path folder;
    private final String searchedWord;
    
    FolderTextFilesSearchTask(Path folder, String searchedWord){
        this.folder = folder;
        this.searchedWord = searchedWord;
    }

    @Override
    protected Long compute() {
        return 10L;
    }
}