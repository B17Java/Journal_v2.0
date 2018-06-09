package com.journal.validator;

import com.journal.exception.IncorrectInputException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    private static Pattern regexPattern;
    private static Matcher regMatcher;

    public static boolean validateEmailAddress(String emailAddress) {

        regexPattern = Pattern.compile("^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$");
        regMatcher   = regexPattern.matcher(emailAddress);
        if(regMatcher.matches()) {
            return true;
        } else {
            System.out.println("Incorrectly input email");
            return false;
        }
    }

    public static boolean validateMobileNumber(String mobileNumber) {
        regexPattern = Pattern.compile("^\\+[0-9]{2,3}+-[0-9]{10}$");
        regMatcher   = regexPattern.matcher(mobileNumber);
        if(regMatcher.matches()) {
            return true;
        } else {
            System.out.println("Incorrectly input mobile number");
            return false;
        }
    }

    public static void validateGroup(String group) throws IncorrectInputException {
        regexPattern = Pattern.compile("[a-zA-Z-а-яА-Я]{1,3}[0-9]{1,2}");
        regMatcher   = regexPattern.matcher(group);
        if(!regexPattern.matcher(group).matches()) {
            throw new IncorrectInputException("Incorrectly input group");
        }
    }

    public static void validateText(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("[A-ZА-ЯІ][a-z-а-яії]{1,15}",Pattern.UNICODE_CHARACTER_CLASS);
        if(!regexPattern.matcher(str).matches()){
            throw new IncorrectInputException("Incorrectly input text");
        }
    }

    public static void validateNumber(String str) throws IncorrectInputException {
        regexPattern = Pattern.compile("[1-9][0-9]{0,15}",Pattern.UNICODE_CHARACTER_CLASS);
        if(!regexPattern.matcher(str).matches()) {
            throw new IncorrectInputException("Incorrectly input number");
        }
    }
}
