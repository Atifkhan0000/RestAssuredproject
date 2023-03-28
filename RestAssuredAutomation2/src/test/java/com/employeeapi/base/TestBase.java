package com.employeeapi.base;

import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Properties;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class TestBase {

	public static Logger logger;
    public Properties configprop;
    public static RequestSpecification httpRequest;
    public static Response response;
    public String empid="3";   // mention empid here in case to get detail of a single employee and also can be used in update request
	
	@BeforeClass
	public void setup () {
	
		logger= Logger.getLogger("EmployeesRestAPI");     // Added logger
		PropertyConfigurator.configure("log4j.properties"); //Added logger
		logger.setLevel(Level.DEBUG);    // logger.info("") waale messages ko print kraane ke liye ye syntax likhna zaroori h
		
	}
}
