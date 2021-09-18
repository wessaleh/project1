/**
 * @author Wesam Saleh
 */

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 200;
    public static final int QUARTERCENTENNIAL = 400;
    public static final int THE_EIGHTYS = 1980;
    public static final String[] months = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
            "Oct", "Nov", "Dec"};

    /**
     * take "mm/dd/yyyy" and create a Date object
     * @param date - the date in string form
     */
    public Date(String date) {
        this.month = Integer.parseInt(date.substring(0,2));
        this.day = Integer.parseInt(date.substring(4,5));
        this.year = Integer.parseInt(date.substring(7));
    }

    /**
     * Creates an object with today's date (see Calendar class)
     * Uses string tokenizer to format the date received from Calendar class
     */
    public Date() {
        String date = Calendar.getInstance().getTime().toString();
        StringTokenizer dateTokens = new StringTokenizer(date); // parsing the date which is in a particular format

        dateTokens.nextToken();
        this.month = Integer.parseInt(convertMonthCodeToNumber(dateTokens.nextToken()));
        this.day = Integer.parseInt(dateTokens.nextToken());
        dateTokens.nextToken();
        dateTokens.nextToken();
        this.year = Integer.parseInt(dateTokens.nextToken());
    }

    /**
     * Takes a 3 letter month and converts it to the month's numerical value
     * @param month - the 3 letter month
     * @return - the numerical value of the month as a String
     */
    private static String convertMonthCodeToNumber(String month){
        String monthNumber = "";

        for(int i=0; i<months.length; i++){
            if(month.equals(months[i])){
                monthNumber = (i+1)/10 + "" + (i+1)%10; // to ensure single digits have a 0 in front
            }
        }

        return monthNumber;
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

    @Override
    /**
     * compares this Date to the date passed in
     * @param date - the date passed in
     * @return - a number indicating if the current date is before (<0), after (>0), or equal to (=0) the
     * date passed in>
     */
    public int compareTo(Date date) {
        return 0;
    }

    /**
     * testbed main
     * @param args - command line arguments
     */
    public static void main(String[] args){

    }
}
