package demo.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PLP {
    static ChromeDriver driver;
    public static HashMap<String,String> fetchDataPLP(ChromeDriver driver){
            HashMap<String,String> map = new HashMap<>();
            List<WebElement> name = driver.findElements(By.className("product-item-link"));
            List<WebElement> price=driver.findElements(By.xpath("//span[contains(@id,'product-price-')]/span[text()]"));
            if (name.size()==price.size()) {
                for(int i=0;i<name.size();i++){
                    map.put(name.get(i).getText(), price.get(i).getText());
                }
            }
            return map;
    }
    
    public static boolean clickOnAnyProduct(ChromeDriver driver){
        boolean status;
        String p1=driver.getCurrentUrl();
        List<WebElement> name = driver.findElements(By.className("product-item-link"));
        Random random = new Random();
        int randomIndex=random.nextInt(name.size());
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", name.get(randomIndex));
        name.get(randomIndex).click();
        String p2=driver.getCurrentUrl();
        if(p1!=p2){status=true;}
        else{status=false;}
        return status;
    }
}
