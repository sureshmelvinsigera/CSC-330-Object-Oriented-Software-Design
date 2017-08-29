/**
 * Course: 330-E001(12968)
 * Filename : lab1.cpp
 * Purpose: Print Hello World, and current system time to the standard output.
 * @author Suresh Melvin Sigera
 * @date 08/10/2017
 */

package edu.cuny.csi.csc330.examples;

import java.util.Calendar;
import java.util.Date;

public class HelloWorld {
    public static void main(String args[]) {

        //print message to the standard output
        System.out.println("Hello, World");

        Date now = Calendar.getInstance().getTime();

        //System.out.println("The current date/time is: " + Calendar.getInstance().getTime());

        //print current system time
        System.out.println("The current date/time is: " + now);
    }
}//end of class HelloWorld