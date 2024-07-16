package demo;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import demo.pages.demo;

// Extent report imports
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestCases {
    static ChromeDriver driver;
    static ExtentTest test;
    static ExtentReports report;

    @BeforeSuite(alwaysRun = true)
    public static void openBrowser(){
        driver = new ChromeDriver();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String timestampString = String.valueOf(timestamp.getTime());
        report = new ExtentReports(System.getProperty("user.dir")+"\\src\\test\\extentReport\\report"+timestampString+".html",true);  
        report.loadConfig(new File("C:\\projectnew\\soubhagya0399-ME_QA_OPENCHART\\src\\test\\resources\\config.xml"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        test = report.startTest("TestCase01");
    }
    
    @Test(enabled = true)
    public static void TestCase01(){
        try {
            boolean status;
             SoftAssert softAssert = new SoftAssert();
            status=demo.navigateToDemoURL(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Navigate to Demo url");
            }else{
                test.log(LogStatus.FAIL, "Navigate to Demo url");
            }
            status=demo.clickToHeaderOptions(driver,"DEMO");
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Click on Demo option from Header.");
            }else{
                test.log(LogStatus.FAIL, "Click on Demo option from Header.");
            }
            status=demo.selectViewStoreFront(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Click on View Store Front.");
            }else{
                test.log(LogStatus.FAIL, "Click on View Store Front.");
            }
            
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Print all the product name and extract Discount price and MRP in an excel file:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Select any product from Product List Page:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Navigate to PDP:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Change the quantity of the product:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Add product to cart:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Validate the product is updated or not in cart icon section:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Open cart page through cart icon:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Validate the product details on cart page:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Change the quantity of the prodcut.:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Move Product to Checkout:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
            test.log(LogStatus.FAIL,test.addScreenCapture(captureScreenshot(driver)) + "Fill all the Details to confirm the Order:API INFO REQUIRED FOR ANTI BOT CAPTCHA");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static String captureScreenshot(WebDriver driver) throws IOException{
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir")+"\\src\\test\\screenshot\\img"+System.currentTimeMillis()+".png");
        FileUtils.copyFile(srcFile, destFile);
        String errorFile = destFile.getAbsolutePath();
        return errorFile;
    }

    @AfterSuite(alwaysRun = true)
    public static void closeBrowser(){
    driver.quit(); 
    report.endTest(test);
    report.flush();
    }
}
