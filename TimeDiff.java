/**
 * Name: KC
 * Date: 01/06/2015
 * Assignment #1: 1. prompt the user for two time (HHMMSS in 24H)
 *                2. compute the difference
 * Summary: 1. convert to proper time pattern
 *          2. create time objective
 */

import java.util.*;

public class TimeDiff {

    public static void main(String[] arg) throws Exception {

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Enter first time in HHMMSS: ");
            Time first = new Time(input.nextInt());

            System.out.print("Enter second time in HHMMSS: ");
            Time second = new Time(input.nextInt());

            System.out.println("Time difference: " + computeDif(first.timeInSeconds(), second.timeInSeconds()));
            System.exit(0);

        } catch (InputMismatchException ex1) {
            System.out.println("Error: time should be integer");
        } catch (EnterTimeException ex2) {
            System.out.println(ex2.getMessage());
        }
    }
    static int computeDif(int firstInSeconds, int secondInSeconds) {

        int diffInSeconds = firstInSeconds - secondInSeconds;
        int difSecond = diffInSeconds % 3600 % 60;
        int difMinute = diffInSeconds % 3600 / 60;
        int difHour = diffInSeconds / 3600;

        int difTime = difHour * 10000 + difMinute * 100 + difSecond;
        return difTime;
    }
}
class Time {

    private int hour, minute, second;

    Time(int time) throws EnterTimeException {

        hour = time / 10000;
        if (hour > 23)
            throw new EnterTimeException("Error: hour should not exceed 23");

        minute = (time / 100) % 100;
        if (minute > 59)
            throw new EnterTimeException("Error: minute should not exceed 59");

        second = time % 100;
        if (second > 59)
            throw new EnterTimeException("Error: second should not exceed 59");
    }

    int timeInSeconds () {

        return hour * 3600 + minute * 60 + second;
    }
}
class EnterTimeException extends Exception {

    EnterTimeException(){

        super();
    }
    EnterTimeException(String message) {

        super(message);
    }
}