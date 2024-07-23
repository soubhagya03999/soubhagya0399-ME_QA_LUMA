package demo.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class megaMenu {
    static ChromeDriver driver;
    static String url="https://magento.softwaretestingboard.com/";


    public static boolean navigateToMegaMenuURL(ChromeDriver driver){
        try {
            boolean status;
            driver.get(url);
            status=driver.getCurrentUrl().contains("magento");
            return status;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean clickToHeaderOptions(ChromeDriver driver,String option,String select){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            List<WebElement> header = driver.findElements(By.xpath("//a[@class='level-top ui-corner-all']/span[text()]"));
            wait.until(ExpectedConditions.visibilityOfAllElements(header));
            Actions action = new Actions(driver);
            for (WebElement c1 : header) {
                if (c1.getText().equalsIgnoreCase(option)) {
                    action.moveToElement(c1);
                    action.perform();
                    break;
                }
            }
            Actions action1 = new Actions(driver);
            List<WebElement> drop = driver.findElements(By.xpath("//li[contains(@class,'level1 nav-4')]/a/span[text()]"));
            wait.until(ExpectedConditions.visibilityOfAllElements(drop));
            for (WebElement c2 : drop) {
                if (c2.getText().equalsIgnoreCase(select)) {
                    action1.click(c2);
                    action1.perform();
                    break;
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
