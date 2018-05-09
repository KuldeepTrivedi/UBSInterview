package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class BerlinClockTest {

    BerlinClock berlinClock;

    @Before
    public void intialize(){
        berlinClock = new BerlinClock();
    }


    @Test(expected = IllegalArgumentException.class)
    public void testWhenInputTimeFormatIsNotValid(){
        berlinClock.convertTime("12:345:42");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOutOfRangeHour(){
        berlinClock.convertTime("25:35:42");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOutOfRangeMinutes(){
        berlinClock.convertTime("25:60:00");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOutOfRangeSeconds(){
        berlinClock.convertTime("25:60:60");
    }

    @Test
    public void testWhenTimeIsZero(){
        String time = berlinClock.convertTime("00:00:00");
        Assert.assertEquals(time,"Y\r\nOOOO\r\nOOOO\r\nOOOOOOOOOOO\r\nOOOO");
    }

    @Test
    public void testOneSecondBeforeMidnight(){
        String time = berlinClock.convertTime("23:59:59");
        Assert.assertEquals(time,"O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY");
    }

    @Test
    public void testForMidnight(){
        String time = berlinClock.convertTime("24:00:00");
        Assert.assertEquals(time,"Y\r\nRRRR\r\nRRRR\r\nOOOOOOOOOOO\r\nOOOO");
    }

    @Test
    public void testForRandomTime(){
        String time = berlinClock.convertTime("13:17:01");
        Assert.assertEquals(time,"O\r\nRROO\r\nRRRO\r\nYYROOOOOOOO\r\nYYOO");
    }

}
