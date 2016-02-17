package java4.fun.jsr344;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Agora temos um novo recurso que possibilita agrupar excessoes similares,
 * para que seja possivel trata-las de maneira semelhante em um mesmo bloco.
 * */
public class ExcessoesSimilares {
	
	private void iniciarShow() {
		try {
			classNotFoundException();
			sqlException();
			iOException();
			arrayIndexOutOfBoundsException();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	private void classNotFoundException() throws ClassNotFoundException{
		throw new ClassNotFoundException("ClassNotFoundException");
	}

	private void sqlException() throws SQLException{
		throw new SQLException("SQLException");
	}
	
	private void iOException() throws IOException{
		throw new IOException("IOException");
	}
	
	private void arrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException{
		throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException");
	}
	
	public static void main(String[] args) {
		new ExcessoesSimilares().iniciarShow();
	}
}

