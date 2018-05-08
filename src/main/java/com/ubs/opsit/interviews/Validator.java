package com.ubs.opsit.interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    private static Pattern pattern;
    private static Matcher matcher;

    public static boolean isValid(final String time, final String validPattern){

        pattern = Pattern.compile(validPattern);
        matcher = pattern.matcher(time);
        return matcher.matches();
    }

}
