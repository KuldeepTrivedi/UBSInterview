package com.ubs.opsit.interviews;

public class TimePart {

    private int hours =0;
    private int minutes =0;
    private int seconds =0;
    private TimeValidator validator;

    TimePart(String aTime){
        validator = new TimeValidator();
        validator.validateInputTimeFormat(aTime);
        String[] timeParts= aTime.split("\\:");
        setHours(Integer.parseInt(timeParts[0]));
        setMinutes(Integer.parseInt(timeParts[1]));
        setSeconds(Integer.parseInt(timeParts[2]));
    }


    public void setHours(int hours) {
        validator.validateHours(hours);
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        validator.validateMinutes(minutes);
        this.minutes = minutes;
    }

    public void setSeconds(int seconds) {
        validator.validateSeconds(seconds);
        this.seconds = seconds;
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
