package java4.fun.nio;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import static java.nio.file.StandardWatchEventKinds.OVERFLOW;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.nio.file.attribute.BasicFileAttributes;

public class NIOEx {

	Charset charset = Charset.forName("ISO-8859-1");

	private String nomeDiretorio = ".";
	private String nomeArquivo = "nio.txt";
	private String nomeAlterado = "niold.txt";
	private String nomeBackup = "nio-backup.txt";

	private Path diretorio = Paths.get(nomeDiretorio);
	private Path arquivo = diretorio.resolve(nomeArquivo);
	private Path alterado = diretorio.resolve(nomeAlterado);
	private Path backup = diretorio.resolve(nomeBackup);

	public static void main(String[] args) throws IOException {
		new NIOEx().iniciarShow("Ola NIO2!");
	}

	private void iniciarShow(String texto) throws IOException{
		Files.deleteIfExists(arquivo);
		Files.deleteIfExists(alterado);
		Files.deleteIfExists(backup);

		_1UseThePathClassToOperateOnFileAndDirectoryPaths(texto);
		_2UseTheFilesClassToCheckDeleteCopyOrMoveAFileOrDirectory();
		_3ReadAndChangeFileAndDirectoryAttributes();
		_4RecursivelyAccessADirectoryTree();
		_5FindAFileByUsingThePathMatcherClass();
		_6WatchADirectoryForChangesByUsingWatchService();
	}

	/*
	 * 1. Use the Path class to operate on file and directory paths
	 * */
	private void _1UseThePathClassToOperateOnFileAndDirectoryPaths(String texto) throws IOException {
		try(BufferedWriter writer = Files.newBufferedWriter(arquivo, charset)){
			writer.write(texto, 0, texto.length());
		}
	}

	/*
	 * 2. Use the Files class to check, delete, copy, or move a file or directory
	 * */
	private void _2UseTheFilesClassToCheckDeleteCopyOrMoveAFileOrDirectory() throws IOException {
		//deleta
		Files.deleteIfExists(backup);

		//copia
		Files.copy(arquivo, backup);

		//move
		Files.move(arquivo, alterado);
	}

	/*
	 * 3. Read and change file and directory attributes
	 * */
	private void _3ReadAndChangeFileAndDirectoryAttributes() throws IOException{
		System.out.println( "isDirectory -> " + Files.isDirectory(diretorio) );
		System.out.println( "isExecutable -> " + Files.isExecutable(diretorio) );
		System.out.println( "isHidden -> " + Files.isHidden(diretorio) );
		System.out.println( "isReadable -> " + Files.isReadable( diretorio) );
		System.out.println( "isRegularFile -> " + Files.isRegularFile(diretorio) );
		System.out.println( "isSameFile -> " + Files.isSameFile(diretorio, alterado) );
		System.out.println( "isSymbolicLink -> " + Files.isSymbolicLink(diretorio) );
		System.out.println( "isWritable -> " + Files.isWritable(diretorio) );

		//Aqui o segundo parametro refere-so aos atributos encontrados em FileAttributeView(sub)
		System.out.println( "FileAttributeView(lastAccessTime) -> " + Files.getAttribute(diretorio,"lastAccessTime") );
		System.out.println( "getOwner -> " + Files.getOwner(diretorio) );
		System.out.println( "BasicFileAttributes(readAttributes) -> " + Files.readAttributes(diretorio, BasicFileAttributes.class) );
	}

	/*
	 * 4. Recursively access a directory tree
	 * */
	private void _4RecursivelyAccessADirectoryTree() throws IOException{
		Files.walkFileTree(diretorio, new SimpleFileVisitor<Path>(){

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println( file.getFileName() );
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
				if(e == null){
					return FileVisitResult.CONTINUE;
				}else{
					throw e;
				}
			}

		});
	}

	/*
	 * 5. Find a file by using the PathMatcher class
	 * 
	 * http://docs.oracle.com/javase/7/docs/api/java/nio/file/Files.html#newDirectoryStream(java.nio.file.Path, java.lang.String)
	 * 
	 * http://docs.oracle.com/javase/7/docs/api/java/nio/file/FileSystem.html#getPathMatcher(java.lang.String)
	 * */
	private void _5FindAFileByUsingThePathMatcherClass() throws IOException{
		Files.walkFileTree(diretorio, new SimpleFileVisitor<Path>(){
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {

				/*
				 * Internamente newDirectoryStream fazendo uso de PatchMatcher:
				 * 
				 * final PathMatcher matcher = fs.getPathMatcher("glob:" + glob);
				 * 
				 * */
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*.java")) {

					for (Path path : stream) {
						System.out.println("\\_" + path.getFileName());
					}
				}
				return FileVisitResult.CONTINUE;
			}
		});
	}

	/*
	 * 6. Watch a directory for changes by using WatchService
	 * */
	private void _6WatchADirectoryForChangesByUsingWatchService() throws IOException{

		WatchService watcher = FileSystems.getDefault().newWatchService();

		for(;;){

			WatchKey key = diretorio.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);

			for (WatchEvent<?> evento : key.pollEvents()) {
				WatchEvent.Kind<?> tipo = evento.kind();

				if (tipo == ENTRY_CREATE) {
					System.out.println("ENTRY_CREATE");

				}else if (tipo == ENTRY_DELETE) {
					System.out.println("ENTRY_DELETE");

				}else if (tipo == ENTRY_MODIFY) {
					System.out.println("ENTRY_MODIFY");

				}else if (tipo == OVERFLOW) {
					System.out.println("OVERFLOW");
				} 

				WatchEvent<Path> ev = (WatchEvent<Path>)evento;
				Path arquivo = ev.context();

				System.out.println(arquivo + "\n" + Files.probeContentType(diretorio.resolve(arquivo)) + "\n");

				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			}

		}

	}
}
