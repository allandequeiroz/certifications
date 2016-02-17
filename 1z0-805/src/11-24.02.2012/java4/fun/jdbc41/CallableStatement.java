package java4.fun.jdbc41;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CallableStatement {

    public static void main(String...args){
        try(Connection con = DriverManager.getConnection("jdbc:myDriver:myDB","username","password")) {
            java.sql.CallableStatement cs = con.prepareCall("{call CUST_TABLE(?,?,?)}");
            cs.setString(1, "username");
            cs.setString(2, "password");
            cs.registerOutParameter(3, Types.DATE);
            cs.executeQuery();
            Date lastLogin = cs.getDate(3);
        } catch (SQLException ex) {
            Logger.getLogger(CallableStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
