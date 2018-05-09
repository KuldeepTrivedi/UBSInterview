package com.ubs.opsit.interviews;

import org.apache.commons.lang.StringUtils;

public class BerlinClock implements TimeConverter {

    private char[][] lamps;
    private TimePart timePart;

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

    private String getLampStatus(int timeLeftForDisplay, int notionValueOfLamp, char[] lamps){
        int totalLampsInRow = lamps.length;
        int totalOnLamps = timeLeftForDisplay/notionValueOfLamp;
        for(int i= totalLampsInRow-1;i>=totalOnLamps;i--){
            lamps[i] ='O';
        }
        return String.valueOf(lamps);
    }


   private String getLampsToDisplaySecond(char[] lamps){
        if(timePart.getSeconds()%2==1){
            lamps[0]='O';
        }
        return String.valueOf(lamps);
    }


    private int getTimeLeftToDisplayInSecondRow(int totalTime,int notionValueOfLampInFirstRow ){
        return totalTime%notionValueOfLampInFirstRow;
    }



    private String getNormalizedBerlinTime(){
        String [] berlinTime ={
                getLampsToDisplaySecond(lamps[0]),
                getLampStatus(timePart.getHours(),5, lamps[1]),
                getLampStatus(getTimeLeftToDisplayInSecondRow(timePart.getHours(),5),1, lamps[2]),
                getLampStatus(timePart.getMinutes(),5, lamps[3]),
                getLampStatus(getTimeLeftToDisplayInSecondRow(timePart.getMinutes(),5),1, lamps[4])
        };
        return StringUtils.join(berlinTime,"\r\n");
    }

    @Override
    public String convertTime(String aTime) {
        intializeClock(aTime);
        return getNormalizedBerlinTime();
    }
}
