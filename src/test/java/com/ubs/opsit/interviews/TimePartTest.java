package com.ubs.opsit.interviews;

import org.junit.Test;

public class TimePartTest {

    @Test(expected = IllegalArgumentException.class)
    public void testWhenInputTimeFormatIsNotValid(){
        TimePart timePart = new TimePart("12:345:42");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenInputTimeValueIsNotValid(){
        TimePart timePart = new TimePart("ab:45:42");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOutOfRangeHour(){
        TimePart timePart = new TimePart("25:35:42");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOutOfRangeMinutes(){
        TimePart timePart = new TimePart("25:60:00");

    }

    @Test(expected = IllegalArgumentException.class)
    public void testForOutOfRangeSeconds(){
        TimePart timePart = new TimePart("25:60:60");

    }

    @Test
    public void testForValidTime(){
        TimePart timePart = new TimePart("23:42:42");

    }

    @Test
    public void testForZeroTime(){
        TimePart timePart = new TimePart("00:00:00");

    }
}
