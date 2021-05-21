package studio.mkko120.coffeeutils.DB;

import java.sql.*;

public class DatabaseUtils {

    public static ResultSet loadData(String statement) {
        Connection con = null;
        Statement smt = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/minecraft",
                "luckperms",
                "password");
            smt = con.createStatement();
            rs = smt.executeQuery(statement);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if ( rs != null ) {
                try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if ( smt != null ) {
                try { smt.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if ( con != null ) {
                try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return null;
    }

    public static boolean pushData(String statement) {
        Connection con = null;
        Statement smt = null;
        boolean executed;
        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost:3306",
                    "luckperms",
                    "password");
            smt = con.createStatement();
            executed = smt.execute(statement);
            return executed;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if ( smt != null ) {
                try { smt.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
            if ( con != null ) {
                try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
        return false;
    }
}
