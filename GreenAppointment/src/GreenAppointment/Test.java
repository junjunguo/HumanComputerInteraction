/*
 * Created by GuoJunjun <junjunguo.com> on 1.2.2015.
 *
 * This file is part of GreenAppointment
 */

package GreenAppointment;

/** Created by GuoJunjun <junjunguo.com> on 01/02/15. */

public class Test {
    public static void main(String[] args) {
        new DataManager();
        for (Appointment a : DataManager.getAppointments()) {
            System.out.println(a.toString());
        }
        DataManager.JsontoJavaObject();
        System.out.println(DataManager.getAppointments().toString() + " " + DataManager.getAppointments().size());
        for (Appointment a : DataManager.getAppointments()) {
            System.out.println(a.toString());
        }
    }

}
