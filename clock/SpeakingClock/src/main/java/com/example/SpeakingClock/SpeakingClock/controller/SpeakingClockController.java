package com.example.SpeakingClock.SpeakingClock.controller;

import com.example.SpeakingClock.SpeakingClock.service.SpeakingClockService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/time")
@Api(tags = "Speaking Clock", description = "APIs for the Speaking Clock")
public class SpeakingClockController {

    private final SpeakingClockService speakingClockService;

    @Autowired
    public SpeakingClockController(SpeakingClockService speakingClockService) {
        this.speakingClockService = speakingClockService;
    }


    @GetMapping("/convertTime")
    @ApiOperation(value = "Convert time to words", notes = "Converts the input time to words")
    public ResponseEntity<String> convertTimeToWords(@RequestParam String time) {
        try {
            String timeInWords = speakingClockService.convertTimeToWords(time);
            return ResponseEntity.ok(timeInWords);
        } catch (IllegalArgumentException e) {
            // Handle invalid time input
            return ResponseEntity.badRequest().body("Invalid time input: " + time);
        } catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(500).body("An error occurred while converting time to words.");
        }
    }
}
