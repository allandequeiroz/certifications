package java4.fun.jdbc41;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreparedStatement {

    public static void main(String...args){
        try(Connection con = DriverManager.getConnection("jdbc:myDriver:myDB","username","password")) {
            java.sql.PreparedStatement pstmt = con.prepareStatement("select * from cust_table where email like ?");
            
            pstmt.setString(1, "allandequeiroz@gmail.com");            
            ResultSet rs = pstmt.executeQuery();
            
            pstmt.setString(1, "allandequeiroz02@gmail.com");
            rs = pstmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(PreparedStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
