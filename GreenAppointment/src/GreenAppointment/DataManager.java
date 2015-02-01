package GreenAppointment;

/** Created by GuoJunjun <junjunguo.com> on 31/01/15. */

import java.io.*;
import java.util.ArrayList;

/**
 * DataManager is a static class:
 * <p/>
 * manages all the data appointments & user information
 */
public class DataManager {
    private static ArrayList<Appointment> appointments;

    public DataManager() {
        appointments = new ArrayList<Appointment>();
        System.out.println("loadData: " + loadData());
    }

    /**
     * add the given appointment to appointments array list
     *
     * @param appointment
     */
    public static void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    /**
     * remove the given appointment from the appointments array list
     *
     * @param appointment
     */
    public static void removeAppointment(Appointment appointment) {
        appointments.remove(appointment);
    }

    /**
     * @return appointments as an array list
     */
    public static ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    /**
     * save appointments to file
     *
     * @return true is succeed, false otherwise
     */
    public static boolean saveData() {
        try {
            FileOutputStream savefile = new FileOutputStream("appointmentSavedFile.txt");
            ObjectOutputStream save = new ObjectOutputStream(savefile);
            save.writeObject(appointments);
            System.out.println("save appointment: " + appointments.get(0).toString());

            save.close();
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * load appointments from file
     *
     * @return true is succeed, false otherwise
     */
    public static boolean loadData() {
        ArrayList<Appointment> ap;
        try {
            FileInputStream savedfile = new FileInputStream("appointmentSavedFile.txt");
            ObjectInputStream object = new ObjectInputStream(savedfile);
            ap = (ArrayList<Appointment>) object.readObject();
            System.out.println(ap.toString() + " length: " + ap.size());
            if (ap.get(0).getFormal() == null) {
                System.out.println("null Appointment");
            } else {
                appointments = ap;
                System.out.println("out print appointment: " + appointments.get(0).toString());
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
