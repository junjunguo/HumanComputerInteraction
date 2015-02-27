package Calendar.model;

/** Created by GuoJunjun <junjunguo.com> on 27/02/15. */

public class Utility {
    /**
     * check if a given string is a valid email address or not
     *
     * @param email
     *
     * @return true if the email address (format: "x@y.z") is valid;
     */
    public static boolean isValidEmailAddress(String email) {
        String ePattern
                = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(" +
                  "([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * @param s
     *
     * @return true if a String s (can parse to Int) a Integer
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

}
