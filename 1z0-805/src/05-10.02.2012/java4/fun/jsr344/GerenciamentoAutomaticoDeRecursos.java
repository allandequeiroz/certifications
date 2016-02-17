package java4.fun.jsr344;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Nesta novidade o Java 7 faz desnecessário o uso do bloco finally em um 
 * try/finally ou até mesmo em um try/catch/finally. 
 * 
 * Isto só é possível quando utilizado no bloco finally um objeto que implemente 
 * a interface Closeable, que por sua vez estende a interface AutoCloseable.
 * 
 * Analisando a classe FileInputStream, pode se ver que ela estende a classe InputStream, 
 * que por sua vez implementa a interface Closeable que estende AutoCloseable. 
 * Até o Java 6 (doc: http://download.oracle.com/javase/6/docs/api/java/io/Closeable.html) 
 * a interface Closeable não possuía uma superclasse, já no Java 7 
 * (doc: http://download.oracle.com/javase/7/docs/api/java/io/Closeable.html) a interface AutoCloseable
 * */
public class GerenciamentoAutomaticoDeRecursos {
	
	private void iniciarShow() {
		
		try (
				MeuFileReader in = new MeuFileReader("README");
				BufferedReader br = new BufferedReader(in)
			) {
			
			System.out.println( br.readLine() );
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void main(String[] args) {
		new GerenciamentoAutomaticoDeRecursos().iniciarShow();
	}

	

}

class MeuFileReader extends FileReader{

	public MeuFileReader(String name) throws FileNotFoundException {
		super(name);
	}

	@Override
	public void close() throws IOException {
		System.out.println("MeuFileReader -> Fui fechado automaticamente :)");
		super.close();
	}
	
}

class MeuBufferedReader extends BufferedReader{

	public MeuBufferedReader(Reader in) {
		super(in);
	}
	
	@Override
	public void close() throws IOException {
		System.out.println("MeuBufferedReader -> Fui fechado automaticamente :)");
		super.close();
	}
	
}