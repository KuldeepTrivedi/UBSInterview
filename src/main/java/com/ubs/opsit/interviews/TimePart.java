package com.ubs.opsit.interviews;

public class TimePart {

    private int hours =0;
    private int minutes =0;
    private int seconds =0;

    public final String VALID_TIME_PATTERN = "[0-9]?[0-9]:[0-9]?[0-9]:[0-9]?[0-9]";

    TimePart(String aTime){
        isValidInput(aTime);
        String[] timeParts= aTime.split("\\:");
        setValidHours(Integer.parseInt(timeParts[0]));
        setValidMinutes(Integer.parseInt(timeParts[1]));
        setValidSeconds(Integer.parseInt(timeParts[2]));
    }

    private void isValidInput(String aTime) {
        if(!Validator.isValid(aTime,VALID_TIME_PATTERN)){
            throw new IllegalArgumentException("Invalid time format.");
        }
    }

    private void setValidSeconds( int seconds) {
        if(seconds>59 || seconds<0){
            throw new IllegalArgumentException("Invalid seconds component.");
        }
        this.seconds = seconds;
    }

    private void setValidMinutes(int minutes) {
        if(minutes>59 || minutes<0){
            throw new IllegalArgumentException("Invalid minutes component.");
        }
        this.minutes =minutes;
    }

    private void setValidHours(int hours) {
        if(hours>24 || hours<0){
            throw new IllegalArgumentException("Invalid hours component.");
        }
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}
