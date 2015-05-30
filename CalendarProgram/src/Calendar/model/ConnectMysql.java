package Calendar.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** Created by GuoJunjun <junjunguo.com> on 27/02/15. */

public class ConnectMysql {
    /**
     * @return Connection create a MySql database connection
     */
    public static Connection getConnection() {
        Connection con = null;
            String url = "jdbc:mysql://mysql.stud.ntnu.no/junjung_calendar?zeroDateTimeBehavior=convertToNull";
            String user = "junjung_mmi";
            String driver = "com.mysql.jdbc.Driver";
            String password = "mmi";
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, user, password);
            System.out.println("CONNECTION ESTABLISHED.");
        } catch (SQLException ex) {
            System.out.println("CONNECTION ERROR: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Feilet under driverlasting: " + ex.getMessage());
        } catch (Exception e) {
            System.out.println("CONNECTION COULD NOT BE ESTABLISHED.");
            e.printStackTrace();
        }
        return con;
    }
}
