package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC002_GET_Single_Employee_Record extends TestBase {

	@BeforeClass
	 void getallemployees () throws InterruptedException {
		
		logger.info("***********Started TC_002 get single Employee data************** ");

		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";       
		httpRequest=RestAssured.given();
		response=httpRequest.request(Method.GET,"/employee/"+ empid); 
		
		Thread.sleep(3000);
		
		}
	
	@Test
	void checkResponseBody() {       
		logger.info("***********Checking empid is in the body or not************* ");
		 String responseBody=response.getBody().asString();
		 Assert.assertEquals(responseBody.contains(empid), true);
		
     }
	
	@Test
	void checkStatusCode() {        
		
		logger.info("***********Checking Status Code************* ");  
		
		int statusCode=response.getStatusCode();      
		logger.info("Status code is: "+statusCode);          
		  Assert.assertEquals(statusCode, 200);   
		
     }
	
	@Test
	void checkResponseTime() {        
		
		logger.info("***********Checking Response Time************* ");  
		
		long responsetime=response.getTime();      
		logger.info("response time is: "+responsetime); 
		
		if (responsetime>2000)
			logger.warn("Response time is greater than 2000");
		
		  Assert.assertTrue(responsetime<2000);
	
	}
	
	@Test
	void checkStatusLine() {        
		
		logger.info("***********Checking Status Line************* ");  
		
		 String statusLine=response.getStatusLine();
		 logger.info("Status line is:"+statusLine);
		  Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");    
		
	}
	
	@Test
	void checkContentType() {        
		
		logger.info("***********Checking Content Type************* ");  
		
		 String contentType=response.header("Content-Type");
		 logger.info("Content Type is:"+contentType);
		  Assert.assertEquals(contentType, "application/json"); 
		
	}
	
	@Test
	void checkServerType() {        
		
		logger.info("***********Checking Server Type************* ");  
		
		 String serverType=response.header("Server");
		 logger.info("Content Type is:"+serverType);
		  Assert.assertEquals(serverType, "nginx/1.21.6"); 
		
	}
	
	@Test
	void checkContentEncoding() {        
		
		logger.info("***********Checking Content Encoding************* ");  
		
		String contentEncoding=response.header("Content-Encoding");
		 logger.info("Content Encoding is:"+contentEncoding);
		  Assert.assertEquals(contentEncoding,"gzip");
		
	}
	
	@Test
	void checkContentLength() {        
		
		logger.info("***********Checking Content Length************* ");  
		
		String contentlength=response.header("Content-Length");
		 logger.info("Content Encoding is:"+contentlength);
		  
		 if (Integer.parseInt(contentlength)>2000)
				logger.warn("Content length is greater than 2000");
			
			  Assert.assertTrue(Integer.parseInt(contentlength)<2000);
	}	
	

	@Test
	void getCookievalue() {        
		
		logger.info("***********get Cookie value************* ");  
		
		String cookie=response.getCookie("PHPSESSID");     // to get value of the mentioned cookie
		                                                 // we cannot apply validations on cookie because its value changes every runtime 
	}
	
	@AfterClass
	void TearDown(){
		
		logger.info("**********Finished TC_002 get single Employee data************** ");
	}
	
	
}
	
	
	

