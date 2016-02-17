package java4.fun.patterns;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    public static void main(String...args){
        try(Connection con = DriverManager.getConnection("jdbc:myDriver:myDB","username","password")) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from questions");
            
            while(rs.next()){
                int questionId = rs.getInt("id");
                String question = rs.getString("question");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
