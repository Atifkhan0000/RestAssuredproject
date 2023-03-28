package com.employeeapi.testcases;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;


public class TC005_Delete_Employee_Record extends TestBase {



		@BeforeClass
		 void DeleteExistingEmployeeRecord () throws InterruptedException {
			
			logger.info("***********Started TC_005 to delete existing employee record************** ");

			// Specify base URI
			
			RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";       // here we write the domain part only
			
			//Request object
			  httpRequest=RestAssured.given();
			  
			  response=httpRequest.request(Method.GET,"/employees"); 
			  
	          String empid=response.jsonPath().get("[2].id");
			
			  response=httpRequest.request(Method.DELETE,"/delete/"+empid);  // pass id to delete record
			           
			  Thread.sleep(2000);
			
			}
		
		@Test
		void checkResponseBody() {       
		
			 String responseBody=response.getBody().asString();	
			 assertEquals(responseBody.contains("Successfully! Record has been deleted"), true);
			 
		}
		@Test
		void checkStatusCode() {        
			int statusCode=response.getStatusCode();              
			  Assert.assertEquals(statusCode, 200);   
			
	      }
		
		@AfterClass
		void TearDown(){
			
			logger.info("**********Finished TC_005 to delete existing employee record************** ");
			
		
	}
		

		
}
