package demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
    static ChromeDriver driver;
    public static boolean fillAllTheDetails(ChromeDriver driver,String email1,String FN,String LM,String CMP,String adrs,String cty,String cntry,String st,String PC,String number){
        try {
            WebElement email= driver.findElement(By.xpath("(//input[@id='customer-email'])[1]"));
            email.sendKeys(email1+String.valueOf(System.currentTimeMillis())+"@gamail.com");
            WebElement name=driver.findElement(By.xpath("//input[@name='firstname']"));
            name.sendKeys(FN+String.valueOf(System.currentTimeMillis()));
            WebElement Lname=driver.findElement(By.xpath("//input[@name='lastname']"));
            Lname.sendKeys(LM+String.valueOf(System.currentTimeMillis()));
            WebElement company=driver.findElement(By.xpath("//input[@name='company']"));
            company.sendKeys(CMP+String.valueOf(System.currentTimeMillis()));
            WebElement address=driver.findElement(By.xpath("(//input[@class='input-text'])[7]"));
            address.sendKeys(adrs);
            WebElement city =driver.findElement(By.xpath("(//input[@class='input-text'])[10]"));
            city.sendKeys(cty);
            WebElement country= driver.findElement(By.xpath("//span[text()='Country']/parent::label/following-sibling::div/select"));
            Select select = new Select(country);
            select.selectByVisibleText(cntry);
            WebElement state= driver.findElement(By.xpath("//span[text()='State/Province']/parent::label/following-sibling::div/select"));
            Select select1 = new Select(state);
            select1.selectByVisibleText(st);
            WebElement pin = driver.findElement(By.xpath("//span[text()='Zip/Postal Code']/parent::label/following-sibling::div/input"));
            pin.sendKeys(PC);
            WebElement num = driver.findElement(By.xpath("//span[text()='Phone Number']/parent::label/following-sibling::div/input"));
            num.sendKeys(number+String.valueOf(System.currentTimeMillis()));
            Thread.sleep(5000);
            WebElement button = driver.findElement(By.xpath("//button[@data-role='opc-continue']"));
            if (button.isEnabled()) {
                button.click();
                return true;
            }
            Thread.sleep(5000);
            return false;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
}
