package Calendar.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/** Created by GuoJunjun <junjunguo.com> on 27/02/15. */

public class Query {

    public static String addUser(
            String email, String firstname, String surname, int mobile, String pass) {


        if (CheckUser.userExist(email)) {
            return "userID: " + email + "already registered";
        }
        String query = " insert into user (email,firstname, surname, mobile, pass)  values (?, ?, ?, ?, ?)";

        try {
            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = ConnectMysql.getConnection().prepareStatement(query);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, firstname);
            preparedStmt.setString(3, surname);
            preparedStmt.setInt(4, mobile);
            preparedStmt.setString(5, pass);


            // execute the prepared statement
            preparedStmt.execute();

            return "succeed";
        } catch (Exception e) {
            return "add user exception!" + e.getMessage();
        }
    }


    /**
     * @return total amount of registered users at database
     */
    public static int getTotalRegisteredUser() {
        String query = " SELECT COUNT(*) AS rowcount FROM user";
        Statement st;
        ResultSet rs;
        try {
            st = ConnectMysql.getConnection().createStatement();
            rs = st.executeQuery(query);
            rs.next();
            int count = rs.getInt("rowcount");
            st.close();
            return count;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * @param email
     *
     * @return Username
     */
    public static String getUserName(String email) {
        String query = " SELECT * FROM user WHERE email = '" + email + "'";
        Statement st;
        ResultSet rs;
        try {
            st = ConnectMysql.getConnection().createStatement();
            rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString("firstname") + " " + rs.getString("surname");
            st.close();
            return name;
        } catch (SQLException e) {
            System.out.println("error at getUserName: " + e);
        }
        return "ERROR";
    }

    /**
     * @return all appointments
     */
    public static List getAllAppointments() {
        String query = " SELECT * FROM roomcalendar";
        Statement st;
        ResultSet rs;
        ArrayList<Appointment> appointments = new ArrayList<Appointment>();
        try {
            st = ConnectMysql.getConnection().createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Appointment appointment = new Appointment();
                // ??
                appointments.add(appointment);
            }
            st.close();
            return appointments;
        } catch (SQLException e) {
            System.out.println("error at getUserName: " + e);
        }
        return null;
    }


    /**
     * @param id
     *
     * @return Koie with all attributes set
     */
    public static Room getRoom(int id) {
        if (isRoomIdValid(id)) {
            String query = " SELECT * FROM koier WHERE id = '" + id + "'";
            Statement st;
            ResultSet rs;
            try {
                st = ConnectMysql.getConnection().createStatement();
                rs = st.executeQuery(query);
                rs.next();
                Room r = new Room();
                r.setRoomID(id);
                r.setRoomSize(rs.getInt("size"));
                r.setRoomAddress(rs.getString("address"));
                return r;
            } catch (SQLException e) {
                System.out.println("error at Query.getRoom: " + e);
                return null;
            }
        }
        return null;
    }

    private static boolean isRoomIdValid(int id) {
        if (id <= 0 || id > 10) {
            System.out.println("not valid room id !");
            return false;
        }
        return true;
    }
}
