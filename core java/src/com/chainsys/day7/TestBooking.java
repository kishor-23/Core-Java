package com.chainsys.day7;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class TestBooking {

    public static void main(String[] args) {
        Date date = null; // Initialize date variable

        Scanner sc = new Scanner(System.in);
        ArrayList<Bus> buses = new ArrayList<Bus>();
        buses.add(new Bus(true, 20, "madurai"));
        buses.add(new Bus(false, 10, "chennai"));
        buses.add(new Bus(true, 30, "theni"));
        for (Bus b : buses) {
            System.out.println(b.toString());
        }

        boolean validDate = false;
        while (!validDate) {
            System.out.println("Enter date dd-mm-yyyy:");
            String dateInput = sc.next();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            try {
                date = new Date(dateFormat.parse(dateInput).getTime());
                validDate = true; // Set validDate to true if parsing succeeds
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please enter date in dd-mm-yyyy format.");
            }
        }

      System.out.println("date is:"+date);
        
    }
}
