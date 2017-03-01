package com.example.email_validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
	
	private static final int NUM_TESTS = 4;
	
	/**
	 * Validates an email through a series of tests
	 * @param email
	 * @return True if all tests passed
	 */
	public static boolean validate(String email) {
		return runTests(email) == NUM_TESTS;
	}
	
	/**
	 * Runs all tests on email
	 * @param email
	 * @return number of tests passed
	 */
	public static int runTests(String email) {
		int numPassed = 0;
		if (exactlyOneAt(email)) numPassed++;
		if (atLeastOnePeriod(email)) numPassed++;
		if (periodAfterAt(email)) numPassed++;
		if (longEnough(email)) numPassed++;
		return numPassed;
	}
	
	/**
	 * Checks email for exactly one @ character
	 * @param email
	 * @return true if exactly one
	 */
	public static boolean exactlyOneAt(String email) {
		Pattern p = Pattern.compile("[^@]*@[^@]*");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * Checks email for all least one . character
	 * @param email
	 * @return True if at least one
	 */
	public static boolean atLeastOnePeriod(String email) {
		Pattern p = Pattern.compile(".*\\..*");
		Matcher m = p.matcher(email);
		return m.matches();
	}
	
	/**
	 * Checks for a period character after at character
	 * @param email
	 * @return true if period after at
	 */
	public static boolean periodAfterAt(String email) {
		String afterAt = email.substring(email.indexOf("@") + 1);
		if (afterAt.indexOf(".") < 0)
			return false;
		else
			return true;
	}
	
	/**
	 * Checks is email is at least minimum possible length 
	 * @param email
	 * @return true if long enough to be an email
	 */
	public static boolean longEnough(String email) {
		return email.length() >= 5;
	}
}
