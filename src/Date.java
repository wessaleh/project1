/**
 * @author Wesam Saleh
 */

public class Date {
    private int year;
    private int month;
    private int day;

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 200;
    public static final int QUARTERCENTENNIAL = 400;
    public static final int THE_EIGHTYS = 1980;

    /**
     * take "mm/dd/yyyy" and create a Date object
     * @param date - the date in string form
     */
    public Date(String date) {

    }

    /**
     * Creates an object with today's date (see Calendar class)
     */
    public Date() {

    }

    /**
     * Check to see if the current date is valid
     * Dates before 1980 or beyond the current date are invalid
     * Days of the month must also be valid (including leap years)
     * @return - true if the date is valid, false if not
     */
    public boolean isValid() {
        return false;
    }

    /**
     * compares this Date to the date passed in
     * @param date - the date passed in
     * @return - a number indicating if the current date is before (<0), after (>0), or equal to (=0) the
     * date passed in>
     */
    public int compareTo(Date date) {
        return 0;
    }
}
