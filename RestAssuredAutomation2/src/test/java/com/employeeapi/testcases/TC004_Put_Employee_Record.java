package com.employeeapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;
import com.employeeapi.utilities.RestUtils;

import io.restassured.RestAssured;
import io.restassured.http.Method;



public class TC004_Put_Employee_Record extends TestBase {

	String ename=RestUtils.ename();
	String esalary=RestUtils.esalary();
	String eage=RestUtils.eage();


		@BeforeClass
		 void UpdateExistingEmployeeRecord () throws InterruptedException {
			
			logger.info("***********Started TC_004 to update existing employee record************** ");

			// Specify base URI
			
			RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";       // here we write the domain part only
			
			//Request object
			  httpRequest=RestAssured.given();
			
			//Request payload sending along with post request
			  JSONObject requestparams= new JSONObject();  //JSONObject supports java.util.Map interface 
			                                               // hence we use put command to add things likewise in collection h.put(key,value)
			  requestparams.put("name",ename);           
			  requestparams.put("salary",esalary);
			  requestparams.put("age",eage);
			  
			  httpRequest.header("Content-Type","application/json"); // to show above data is in JSON format we use header here
			   
			  httpRequest.body(requestparams.toJSONString());   //// to attach above data to the request
			  
			//Response object
			  response=httpRequest.request(Method.PUT,"/update/"+empid);  
			            // means we update the existing record of this empid with the randomly generated name,salary and age.
			
			  Thread.sleep(2000);
			
			}
		
		@Test
		void checkResponseBody() {        // we have to check validations that is written in the test case document
			                              // so here we have create a method for each validation 
			logger.info("***********Checking Response Body************* "); 
			
			 String responseBody=response.getBody().asString();
			 logger.info("Response Body is:" +responseBody);    // just to print response body 
			 Assert.assertEquals(responseBody.contains(ename), true);
			 Assert.assertEquals(responseBody.contains(esalary), true);
			 Assert.assertEquals(responseBody.contains(eage), true);
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
			  Assert.assertEquals(contentType, "text/html; charset=UTF-8"); 
			
		}
		
		@Test
		void checkServerType() {        
			
			logger.info("***********Checking Server Type************* ");  
			
			 String serverType=response.header("Server");
			 logger.info("Content Type is:"+serverType);
			  Assert.assertEquals(serverType, "nginx/1.14.1"); 
			
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
			
			logger.info("**********Finished TC_004 to update existing employee record************** ");
		}
		
		
		
		
	}

	


	
	

