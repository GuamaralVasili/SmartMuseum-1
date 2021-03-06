package it.sapienza.pervasivesystems.smartmuseum.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Guamaral on 5/13/2016.
 */
public class Utilities {

    /**
     * Function to convert milliseconds time to
     * Timer Format
     * Hours:Minutes:Seconds
     */
    public String milliSecondsToTimer(long milliseconds) {
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);
        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        // return timer string
        return finalTimerString;
    }

    /**
     * Function to get Progress percentage
     *
     * @param currentDuration
     * @param totalDuration
     */
    public int getProgressPercentage(long currentDuration, long totalDuration) {
        Double percentage = (double) 0;

        long currentSeconds = (int) (currentDuration / 1000);
        long totalSeconds = (int) (totalDuration / 1000);

        // calculating percentage
        percentage = (((double) currentSeconds) / totalSeconds) * 100;

        // return percentage
        return percentage.intValue();
    }

    /**
     * Function to change progress to timer
     *
     * @param progress      -
     * @param totalDuration returns current duration in milliseconds
     */
    public int progressToTimer(int progress, int totalDuration) {
        int currentDuration = 0;
        totalDuration = (int) (totalDuration / 1000);
        currentDuration = (int) ((((double) progress) / 100) * totalDuration);

        // return current duration in milliseconds
        return currentDuration * 1000;
    }

    /**
     *  format date to String by given pattern
     * @param date
     * @param pattern
     * @return
     */
    public String formatDateToString(Date date, String pattern) {

        String dateStr = "";

        try {
            DateFormat df = new SimpleDateFormat(pattern);
            dateStr = df.format(date);
        }catch (Exception e) {
            System.out.println("Error to format date");
        }

        return dateStr;
    }

    /**
     * trim String
     * @param str
     * @param length
     * @return
     */
    public static String trimString(String str, int length) {
        if(str == null || str.trim().isEmpty()){
            return str;
        }

        String newStr = "";

        if(str.length() < length) {
            newStr = str;
            for(int i = 0; i < length - str.length(); i++) {
                newStr+="\u00A0";
            }
        }
        else {
            String[] words = str.split(" ");

            for (int i = 0; i < words.length; i ++) {
                if(newStr.length() > length) {
                    break;
                }
                newStr += words[i] + " ";
            }
        }

        return newStr;
    }
}