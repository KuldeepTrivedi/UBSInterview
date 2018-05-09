package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeValidator {

    private static Pattern pattern;
    private static Matcher matcher;
    private   static final String VALID_TIME_PATTERN = "[0-9]?[0-9]:[0-9]?[0-9]:[0-9]?[0-9]";

    public void validateInputTimeFormat(String time){
        pattern = Pattern.compile(VALID_TIME_PATTERN);
        matcher = pattern.matcher(time);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Invalid time format.");
        }
    }

    public void validateSeconds( int seconds) {
        if(seconds>59 || seconds<0){
            throw new IllegalArgumentException("Invalid seconds component.");
        }
    }

    public void validateMinutes(int minutes) {
        if(minutes>59 || minutes<0){
            throw new IllegalArgumentException("Invalid minutes component.");
        }
    }

    public void validateHours(int hours) {
        if(hours>24 || hours<0){
            throw new IllegalArgumentException("Invalid hours component.");
        }

    }
}
