package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PDP {
    static ChromeDriver driver;
    public static boolean verifyProductDetails(ChromeDriver driver){
        try {
            if (driver.findElement(By.id("description")).isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("description")));
                return true;
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
    public static boolean changeTheQuantityOfTheProduct(ChromeDriver driver,int quantity){
        try {
            WebElement elem=driver.findElement(By.xpath("//input[contains(@class,'input-text qty')]"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", elem);
            elem.clear();
            elem.sendKeys(String.valueOf(quantity));
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean addtocart(ChromeDriver driver){
        try {
            driver.findElement(By.id("product-addtocart-button")).click();
            Thread.sleep(5000);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean verifyProductIconSectionupdated(ChromeDriver driver){
        try {
            WebElement elem = driver.findElement(By.className("counter-number"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", elem);
            if (elem.isDisplayed()) {
                if (!elem.getText().equals("0")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean OpenCartPageThroughCartIconAndClickOnViewandEditCart(ChromeDriver driver){
        try {
            WebElement elem = driver.findElement(By.xpath("//a[@class='action showcart']"));
            if (elem.isEnabled()) {
                elem.click();
                WebElement element = driver.findElement(By.linkText("View and Edit Cart"));
                if (element.isEnabled()) {
                    element.click();
                    Thread.sleep(5000);
                    return true;
                }
            }
            
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}
