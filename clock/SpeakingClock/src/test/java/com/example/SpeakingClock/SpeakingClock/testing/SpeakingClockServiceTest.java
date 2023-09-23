package com.example.SpeakingClock.SpeakingClock.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.SpeakingClock.SpeakingClock.service.SpeakingClockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SpeakingClockServiceTest {

    private SpeakingClockService speakingClockService;

    @BeforeEach
    public void setUp() {
        speakingClockService = new SpeakingClockService();
    }

    @Test
    public void testValidTimeInput() {
        // Test valid time input
        String result = speakingClockService.convertTimeToWords("14:30");
        assertEquals("It's fourteen thirty.", result);
    }

    @Test
    public void testMidday() {
        // Test midday (12:00)
        String result = speakingClockService.convertTimeToWords("12:00");
        assertEquals("It's Midday.", result);
    }

    @Test
    public void testMidnight() {
        // Test midnight (00:00)
        String result = speakingClockService.convertTimeToWords("00:00");
        assertEquals("It's Midnight.", result);
    }

    @Test
    public void testInvalidTimeInput() {
        // Test invalid time input (hour > 23)
        assertThrows(IllegalArgumentException.class, () -> {
            speakingClockService.convertTimeToWords("24:30");
        });

        // Test invalid time input (minute > 59)
        assertThrows(IllegalArgumentException.class, () -> {
            speakingClockService.convertTimeToWords("10:60");
        });

        // Test invalid time input (negative hour)
        assertThrows(IllegalArgumentException.class, () -> {
            speakingClockService.convertTimeToWords("-1:30");
        });
    }

    @Test
    public void testExceptionHandling() {
        // Test exception handling for unexpected error (e.g., null input)
        assertThrows(RuntimeException.class, () -> {
            speakingClockService.convertTimeToWords(null);
        });
    }
}

