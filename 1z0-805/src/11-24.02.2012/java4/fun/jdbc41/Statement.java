package java4.fun.jdbc41;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Statement {

    public static void main(String...args){
        try(Connection con = DriverManager.getConnection("jdbc:myDriver:myDB","username","password")) {
            java.sql.Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select name from cust_table");
            String updateString = "insert into cust_table values('allan','allandequeiroz@gmail.com')";
            int count = stmt.executeUpdate(updateString);
        } catch (SQLException ex) {
            Logger.getLogger(Statement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
