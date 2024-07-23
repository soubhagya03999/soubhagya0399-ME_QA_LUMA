package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class order {
    static ChromeDriver driver;
    public static boolean placeTheOrder(ChromeDriver driver){
        try {
            Thread.sleep(5000);
            WebElement element = driver.findElement(By.xpath("//span[text()='Place Order']/parent::button"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            element.click();
            Thread.sleep(8000);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}
