package demo;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import demo.pages.CartPage;
import demo.pages.Checkout;
import demo.pages.PDP;
import demo.pages.PLP;
import demo.pages.megaMenu;
import demo.pages.order;

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
        report.loadConfig(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.xml"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        test = report.startTest("TestCase01");
    }
    
    @Test(enabled = true)
    public static void TestCase01(){
        try {
            boolean status;
             SoftAssert softAssert = new SoftAssert();
            status=megaMenu.navigateToMegaMenuURL(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Navigate to LUMA home page"+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Navigate to LUMA home page"+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=megaMenu.clickToHeaderOptions(driver,"Gear","Bags");
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Hover on Gear option from Header Select Bags"+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Hover on Gear option from Header Select Bags"+test.addScreenCapture(captureScreenshot(driver)));
            }
            HashMap<String,String> map = PLP.fetchDataPLP(driver);
            String path=System.getProperty("user.dir");
            ExcelUtils.writeDataToExcel(map,path+"\\src\\\\test\\\\excelSheet\\\\QA_Excel_Data.xlsx");
            File file = new File(path);
            status=file.exists() && file.length()>0;
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Print all the product name and price in an excel file"+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Print all the product name and price in an excel file"+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=PLP.clickOnAnyProduct(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Click on any product to see product details."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Click on any product to see product details."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=PDP.verifyProductDetails(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Check product details page displayed or not.."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Check product details page displayed or not."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=PDP.changeTheQuantityOfTheProduct(driver, 2);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Change the quantity of the product."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Change the quantity of the product."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=PDP.addtocart(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Click on Add to Cart button."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Click on Add to Cart button."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=PDP.verifyProductIconSectionupdated(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Validate the product is updated or not in cart icon section."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Validate the product is updated or not in cart icon section."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=PDP.OpenCartPageThroughCartIconAndClickOnViewandEditCart(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Click on the Cart icon and select iVew and Edit cart button."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Click on the Cart icon and select iVew and Edit cart button."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=CartPage.ValidateProductDetailsOnCartPage(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Check Product is displayed or not in cart page."+test.addScreenCapture(captureScreenshot(driver)));
                test.log(LogStatus.PASS, "Verify the product details are correct or not in cart page."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Check Product is displayed or not in cart page."+test.addScreenCapture(captureScreenshot(driver)));
                test.log(LogStatus.PASS, "Verify the product details are correct or not in cart page."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=CartPage.ChangeTheQuantityOfTheProdcut(driver, 5);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Change the quatity of the product in cart page."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Change the quatity of the product in cart page."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=CartPage.ProceedToCheckOut(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Click on Check Out."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Click on Check Out."+test.addScreenCapture(captureScreenshot(driver)));
            }
            Thread.sleep(5000);
            status=Checkout.fillAllTheDetails(driver,"vasu","vasu","reddy"
            ,"BLTech","Bhubaneswar","Bhubaneswar","India","Odisha","764005","91");
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Fill all the Details to confirm the Order."+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Fill all the Details to confirm the Order."+test.addScreenCapture(captureScreenshot(driver)));
            }
            status=order.placeTheOrder(driver);
            softAssert.assertTrue(status);
            if (status) {
                test.log(LogStatus.PASS, "Place the order after filling all the details"+test.addScreenCapture(captureScreenshot(driver)));
            }else{
                test.log(LogStatus.FAIL, "Place the order after filling all the details"+test.addScreenCapture(captureScreenshot(driver)));
            }
            softAssert.assertAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        public static String captureScreenshot(WebDriver driver) throws IOException{
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir")+"\\src\\test\\screenshot\\img"+System.currentTimeMillis()+".jpeg");
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
