package java4.fun.jdbc41;

import java.math.BigDecimal;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.nio.cs.ext.Big5;

public class PreparedStatementUpdate {

    public static void main(String...args){
        String query = "insert into cust_table(email,password,name,cartTotal,date) values(?,?,?,?,?)";
        try(Connection con = DriverManager.getConnection("jdbc:myDriver:myDB","username","password")) {
            java.sql.PreparedStatement pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, "email");            
            pstmt.setString(2, "password");            
            pstmt.setString(3, "name");            
            pstmt.setBigDecimal(4, BigDecimal.ZERO);            
            pstmt.setDate(5, new Date(System.currentTimeMillis()));            
            
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PreparedStatementUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
