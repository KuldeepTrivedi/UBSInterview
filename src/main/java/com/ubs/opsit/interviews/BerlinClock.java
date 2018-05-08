package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

public class BerlinClock implements TimeConverter {

    char[][] lamps;
    TimePart timePart;

    private void intializeClock(String aTime){
        char[][] lamps ={
                {'Y'},
                {'R','R','R','R'},
                {'R','R','R','R'},
                {'Y','Y','R','Y','Y','R','Y','Y','R','Y','Y'},
                {'Y','Y','Y','Y'}
        };
        this.lamps = lamps;
        timePart = new TimePart(aTime);
    }

    private String getLampStatus(int remaingTime, int lampValue, char[] lamps){
        int offLamps = lamps.length - (remaingTime/lampValue);
        for(int i= lamps.length-1;i>=lamps.length-offLamps;i--){
            lamps[i] ='O';
        }
        return String.valueOf(lamps);
    }


   private String getSeconds(char[] lamps){
        if(timePart.getSeconds()%2==1){
            lamps[0]='O';
        }
        return String.valueOf(lamps);
    }

    private String getTime(){
        String [] berlinTime ={
                getSeconds(lamps[0]),
                getLampStatus(timePart.getHours(),5, lamps[1]),
                getLampStatus(timePart.getHours()%5,1, lamps[2]),
                getLampStatus(timePart.getMinutes(),5, lamps[3]),
                getLampStatus(timePart.getMinutes()%5,1, lamps[4])
        };
        return StringUtils.join(berlinTime,"\r\n");
    }

    @Override
    public String convertTime(String aTime) {
        intializeClock(aTime);
        return getTime();
    }
}
