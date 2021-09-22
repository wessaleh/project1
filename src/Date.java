/**
 * Date class that stores a given date in the format "mm/dd/yy"
 * This date class can also check if the date is valid according to certain specifications
 * @author Wesam Saleh
 */

import java.util.Calendar;
import java.util.StringTokenizer;

public class Date implements Comparable<Date>{
    private int year;
    private int month;
    private int day;

    private static final int QUADRENNIAL = 4;
    private static final int CENTENNIAL = 100;
    private static final int QUARTER_CENTENNIAL = 400;
    private static final int THE_EIGHTIES = 1980;
    private static final int MINIMUM_DAY_VALUE = 1;
    private static final int MINIMUM_MONTH_VALUE = 1;
    private static final int NUMBER_OF_MONTHS_IN_A_YEAR = 12;
    private static final String[] MONTHS = new String[] {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep",
            "Oct", "Nov", "Dec"};
    private static final int[] DAYS_OF_MONTH = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] DAYS_OF_MONTH_IN_LEAP_YEAR = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

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

        for(int i = 0; i < MONTHS.length; i++){
            if(month.equals(MONTHS[i])){
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
        Date currentDate = new Date();

        // validating year
        if(this.year < THE_EIGHTIES || this.year > currentDate.year)
            return false;

        // validating month
        if(this.month < MINIMUM_MONTH_VALUE || this.month > NUMBER_OF_MONTHS_IN_A_YEAR)
            return false;

        // validating day
        int monthIndex = month-1;
        int numDaysInThisMonth = isLeapYear(this.year) ? DAYS_OF_MONTH_IN_LEAP_YEAR[monthIndex] :
                DAYS_OF_MONTH[monthIndex];

        if(this.day < MINIMUM_DAY_VALUE || this.day > numDaysInThisMonth)
            return false;

        return true;
    }

    /**
     * Checks if a given year is a leap year
     * @param year - the year
     * @return - true if the year is a leap year, false if not
     */
    private static boolean isLeapYear(int year) {
        boolean isDivisibleByFour = year % QUADRENNIAL == 0;
        boolean isDivisibleBy100 = year % CENTENNIAL == 0;
        boolean isDivisibleBy400 = year % QUARTER_CENTENNIAL == 0;

        if(isDivisibleByFour){
            if(isDivisibleBy100){
                return isDivisibleBy400;
            }
            return true;
        }
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
        if(this.year - date.year != 0){ // check year first
            return this.year - date.year;
        }else if(this.month - date.month != 0){ // then check month
            return this.month - date.month;
        }else if(this.day - date.day != 0){ // then check day
            return this.day - date.day;
        }else {
            return 0; // otherwise, the two dates are equal
        }
    }

    @Override
    /**
     * returns the Date in string form
     */
    public String toString() {
        String monthInStringForm = this.month / 10 + "" + this.month % 10;
        String dayInStringForm = this.day / 10 + "" + this.day % 10;
        String yearInStringForm = this.year + "";

        return monthInStringForm + "/" + dayInStringForm + "/" + yearInStringForm;
    }

    /**
     * testbed main
     * @param args - command line arguments
     */
    public static void main(String[] args) {

    }
}
