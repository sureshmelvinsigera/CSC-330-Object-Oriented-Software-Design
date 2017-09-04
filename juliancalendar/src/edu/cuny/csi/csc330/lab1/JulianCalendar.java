package edu.cuny.csi.csc330.lab1;

/**
 * Course: 330-E001(12968)
 * Filename : JulianCalendar.java
 * Purpose: This program output the Julian Calendar in a horizontal and vertical line table.
 *
 * @author Suresh Melvin Sigera
 * @date 08/10/2017
 */

public class JulianCalendar {

    // Max number of Days in a month
    static private final int MAX_DAY = 31;

    // abbreviated Month names
    static private final String[] MONTH_NAMES = {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    // day length of each month
    static private final int[] MONTH_SIZES = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    /**
     * display The "DAY" Column Heading
     */
    static private void displayDayHeading() {
        System.out.printf("%5s", "Day");
    }

    /**
     * display Month names between Day .... Day
     */
    static private void displayHeading() {
        displayDayHeading();
        for (int i = 0; i < MONTH_NAMES.length; ++i) {
            System.out.printf("%5s", MONTH_NAMES[i]);
        }
        displayDayHeading();
    }

    static public void display() {
        displayHeading(); // display heading
        int previousMonthCalculated = 0;
        System.out.println("");
        //Loop for the days
        for (int i = 1; i < MAX_DAY + 1; i++) {
            //Display the Day column
            System.out.printf("%3d%s", i, "    ");
            //Loop through months
            for (int j = 0; j < 12; j++) {
                previousMonthCalculated = i;
                //Add the days of previous months upto this month
                for (int k = 0; k < j; k++)
                    previousMonthCalculated += MONTH_SIZES[k];
                //If the total days of month are greater than i
                if (MONTH_SIZES[j] >= i) {
                    //System.out.print(formatted+"  ");
                    System.out.printf("%03d%s", previousMonthCalculated, "  ");
                }
                //Else print 000  if days of month are less than current i value
                else
                    System.out.printf("%s", "000  ");
            }
            System.out.printf("%d", i);
            System.out.println("");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // invoke display method
        display();
    }
}