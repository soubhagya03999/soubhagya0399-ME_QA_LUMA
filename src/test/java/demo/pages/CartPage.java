package demo.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CartPage {
    static ChromeDriver driver;
    public static boolean ValidateProductDetailsOnCartPage(ChromeDriver driver){
        try {
            WebElement elem = driver.findElement(By.xpath("(//div[@class='product-item-details'])[2]"));
            if (elem.isDisplayed()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean ChangeTheQuantityOfTheProdcut(ChromeDriver driver,int quantity){
        try {
            WebElement element = driver.findElement(By.xpath("//div/div/label/input"));
            element.clear();
            element.sendKeys(String.valueOf(quantity));
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            driver.navigate().refresh();
            WebElement element = driver.findElement(By.xpath("//div/div/label/input"));
            element.clear();
            element.sendKeys(String.valueOf(quantity));
            if (element.isEnabled()) {
                return true;
            }
            return false;
        }
    }
    public static boolean ProceedToCheckOut(ChromeDriver driver){
        try {
            Thread.sleep(5000);
            WebElement element = driver.findElement(By.xpath("(//button[contains(@class,'checkout')])[2]"));
            Thread.sleep(3000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            Thread.sleep(2000);
            element.click();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}
