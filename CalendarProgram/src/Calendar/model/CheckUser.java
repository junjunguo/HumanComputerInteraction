package Calendar.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/** Created by GuoJunjun <junjunguo.com> on 27/02/15. */

public class CheckUser {
    /**
     *
     * @param email
     * @return true if user exist false otherwise
     */
    public static boolean userExist(String email) {
        String queryCheck = "SELECT * FROM user WHERE email = '" + email + "'";
        Statement st;
        ResultSet rs;
        try {
            st = ConnectMysql.getConnection().createStatement();
            rs = st.executeQuery(queryCheck);
            if (rs.next()) {
                st.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("user exist check error: " + e);
        }
        return false;
    }

    /**
     *
     * @param email
     * @param pass
     * @return true is user has correct user name and password, false otherwise
     */
    public static boolean canLogin(String email, String pass) {
        String queryCheck =
                "SELECT * FROM user WHERE email = '" + email + "' AND pass ='"
                + pass + "'";
        Statement st;
        ResultSet rs;
        try {
            st = ConnectMysql.getConnection().createStatement();
            rs = st.executeQuery(queryCheck);
            if (rs.next()) {
                st.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("canLogin error: " + e);
        } catch (NullPointerException n){
            System.out.println("Check your internet connection !");
        }

        return false;
    }
    
}
