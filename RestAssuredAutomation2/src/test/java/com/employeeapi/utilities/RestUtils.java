package com.employeeapi.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	 public static String ename() {   // static lene se we can use this in another class directly without creating object likewise{RestUtils.ename();}
     	String generatedString1=RandomStringUtils.randomAlphabetic(1);    // 1 means we can take string of 1 character
     	return ("john"+generatedString1);
      }
	
	
	 public static String esalary() {
	     	String generatedString2=RandomStringUtils.randomNumeric(5);   // 5 means we can take 5 digits in salary
	     	return (generatedString2);
	      }
		
	 public static String eage() {
	     	String generatedString3=RandomStringUtils.randomNumeric(2);    // 2 means age contains 2 digits
	     	return (generatedString3); 
	      }
		
}
