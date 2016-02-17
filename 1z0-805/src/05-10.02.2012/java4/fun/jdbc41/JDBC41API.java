package java4.fun.jdbc41;

import javax.sql.RowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/**
 * As novidades na api JDBC 4.1 ficam por conta do gerenciamento 
 * automatico de recursos no try:
 * try(RowSet rowSet = getRowSet()) 
 * 
 * E das classes :
 * -RowSetFactory
 * -RowSetProvider
 * 
 * E da interface RowSet que facilita a manipulacao de valores e resultados:
 *  
 * The RowSet interface provides a set of JavaBeans properties that allow a 
 * RowSet instance to be configured to connect to a JDBC data source and 
 * read some data from the data source.
 * */
public class JDBC41API {
	
	private static final String LOGIN = "root";
	private static final String SENHA = "";
	private static final String URL = "jdbc:mysql://127.0.0.1/1Z0-805"; 

	public void escrever() throws Exception{
		try(RowSet rowSet = getRowSet()) {
			rowSet.setCommand("select * from pessoa");
			rowSet.execute();
			
			rowSet.moveToInsertRow();
			rowSet.updateString("nome", "allan");
			rowSet.updateString("sobrenome", "queiroz");
			
			rowSet.insertRow();
		} 
	}

	public void ler() throws Exception{
		try(RowSet rowSet = getRowSet()) {
			rowSet.setCommand("select * from pessoa");
			rowSet.execute();
			
			while(rowSet.next()){
				Integer id = rowSet.getInt(1);
				String nome = rowSet.getString(2);
				String sobrenome = rowSet.getString(3);
				System.out.println(id + " " + nome + " " + sobrenome);
			}
			
		} 
	}

	public RowSet getRowSet() throws Exception {
		Class.forName("org.gjt.mm.mysql.Driver") ;

		RowSetFactory rowSetFactory = RowSetProvider.newFactory();
		RowSet rowSet = rowSetFactory.createJdbcRowSet();
		
		rowSet.setUrl(URL);
		rowSet.setUsername(LOGIN);
		rowSet.setPassword(SENHA);

		return rowSet;
	}
	
	public static void main(String[] args) throws Exception {
		JDBC41API jdbc = new JDBC41API();
		jdbc.escrever();
		jdbc.ler();
	}

}
