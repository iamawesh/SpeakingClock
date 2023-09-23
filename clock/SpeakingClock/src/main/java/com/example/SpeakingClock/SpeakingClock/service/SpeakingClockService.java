package com.example.SpeakingClock.SpeakingClock.service;

import com.example.SpeakingClock.SpeakingClock.exception.SpeakingClockException;
import org.springframework.stereotype.Service;

@Service
public class SpeakingClockService {

    public String convertTimeToWords(String time) {
        if (time.equals("12:00")) {
            return "It's Midday.";
        } else if (time.equals("00:00")) {
            return "It's Midnight.";
        }

        try {
            return convertTimeToWordsLogic(time);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid time input: " + time, e);
        } catch (Exception e) {
            throw new SpeakingClockException("An error occurred while converting time to words.", e);
        }
    }

    private String convertTimeToWordsLogic(String time) {


        // Example implementation:
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);

        String hoursInWords = convertToWords(hours);
        String minutesInWords = convertToWords(minutes);

        return hoursInWords + " " + (minutes > 0 ? "and " + minutesInWords : "") + " minutes";
    }

    private String convertToWords(int number) {
        // Implement the logic to convert a number to words here
        // You can use a library or write custom logic for this.

        // Example implementation:
        String[] units = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] teens = {"", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "ten", "twenty", "thirty", "forty", "fifty"};

        if (number < 10) {
            return units[number];
        } else if (number >= 11 && number <= 19) {
            return teens[number - 11];
        } else {
            int tensDigit = number / 10;
            int unitsDigit = number % 10;
            return tens[tensDigit] + " " + units[unitsDigit];
        }
    }
}


