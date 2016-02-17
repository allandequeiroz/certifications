package java4.fun.jdbc41;

import java.math.BigDecimal;
import java.sql.*;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java4.fun.patterns.Factory;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import sun.nio.cs.ext.Big5;

public class JDBCTransaction {

    public static void main(String... args) {
        Map<String,Integer> sales = new HashMap<>();
        
       java.sql.PreparedStatement updateCartTable = null;
       java.sql.PreparedStatement updateCustomerTable = null;
       
       String updateCart = "update cart set cart_total = ? where cart_id = ?";
       String updateCustomer = "update cust_table set cart_total = ? where cart_id = ?";

        try(Connection con = DriverManager.getConnection("jdbc:myDriver:myDB","username","password")) {
            con.setAutoCommit(false);
            
            updateCartTable = con.prepareStatement(updateCart);
            updateCustomerTable = con.prepareStatement(updateCustomer);
            
            
            for(Map.Entry<String,Integer> e : sales.entrySet()){
                
                updateCartTable.setInt(1, e.getValue().intValue());
                updateCartTable.setString(2, e.getKey());
                updateCartTable.executeUpdate();
                
                updateCustomerTable.setInt(1, e.getValue().intValue());
                updateCustomerTable.setString(2, e.getKey());
                updateCustomerTable.executeUpdate();
                
                con.commit();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBCTransaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
