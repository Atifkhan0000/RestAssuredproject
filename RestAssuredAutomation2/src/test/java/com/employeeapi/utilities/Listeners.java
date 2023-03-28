package com.employeeapi.utilities;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.aventstack.extentreports.reporter.configuration.Theme;

public class Listeners extends TestListenerAdapter
{
 
 public ExtentSparkReporter htmlReporter;    // This is noramlly for look and feel of the report
 public ExtentReports extent;    // this is basically for creating new entry and  adding additional information to the report
 public ExtentTest logger;
 
  
 public void onStart(ITestContext testContext)
 {
  htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/myReport.html");//specify location of the report
 
  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
  htmlReporter.config().setReportName("Functional Testing"); // name of the report
  htmlReporter.config().setTheme(Theme.STANDARD);
  
  extent=new ExtentReports();
  extent.attachReporter(htmlReporter);
  extent.setSystemInfo("Host name","localhost");
  extent.setSystemInfo("Environemnt","QA");
  extent.setSystemInfo("user","Atif");
  
 
 }
 
 public void onTestSuccess(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in th report
  logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
 }
 
 public void onTestFailure(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in th report
  logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the failed information to the report with RED color highlighted
  
  String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
  logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath)); 
 }
 
 public void onTestSkipped(ITestResult tr)
 {
  logger=extent.createTest(tr.getName()); // create new entry in th report
  logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));   // send the skipped information to the report with Orange color highlighted
 }
 
 public void onFinish(ITestContext testContext)
 {
  extent.flush();
 }
 
 }