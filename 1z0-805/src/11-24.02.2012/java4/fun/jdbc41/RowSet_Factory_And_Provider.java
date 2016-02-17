package java4.fun.jdbc41;

import java.math.BigDecimal;
import java.sql.*;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java4.fun.patterns.Factory;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import sun.nio.cs.ext.Big5;

public class RowSet_Factory_And_Provider {

    public static void main(String... args) {
        RowSetFactory factory;
        JdbcRowSet jdbcRs;
        ResultSet rs;
        Statement stmt;

        try {
            factory = RowSetProvider.newFactory();
            jdbcRs = factory.createJdbcRowSet();
            
            jdbcRs.setUrl("jdbc:myDriver:myDB");
            jdbcRs.setUsername("username");
            jdbcRs.setPassword("password");
            
            jdbcRs.setCommand("select * from cust_table");
            jdbcRs.execute();
        } catch (SQLException ex) {
            Logger.getLogger(RowSet_Factory_And_Provider.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
