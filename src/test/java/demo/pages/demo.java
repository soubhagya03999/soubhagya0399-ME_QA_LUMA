package demo.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demo {
    static ChromeDriver driver;
    static String url="https://www.opencart.com/index.php?route=cms/demo";


    public static boolean navigateToDemoURL(ChromeDriver driver){
        try {
            boolean status;
            driver.get(url);
            status=driver.getCurrentUrl().endsWith("demo");
            return status;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean clickToHeaderOptions(ChromeDriver driver,String option){
        try {
            List<WebElement> elem = driver.findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a"));
            for(WebElement c1:elem){
                if (c1.getText().equalsIgnoreCase(option)) {
                    if (c1.isDisplayed()) {
                        if (c1.isEnabled()) {
                            c1.click();
                            break;
                        }
                    }
                }
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean selectViewStoreFront(ChromeDriver driver){
        try {
            WebElement elem = driver.findElement(By.xpath("//span[contains(text(),'View Store Front')]/parent::a"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].scrollIntoView();", elem);
            elem.click();
            String parent = driver.getWindowHandle();
            Set<String> child=driver.getWindowHandles();
            for (String s1 : child) {
                if (!s1.equals(parent)) {
                    driver.switchTo().window(s1);
                }
            }
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}
