package CommonApi;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kalkidan on 12/29/2015.
 */

public class Base {

   public WebDriver driver=null;
   @Parameters(("url"))
   @BeforeMethod
   public void setUp(String url){
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.navigate().to(url);
      driver.manage().window().maximize();
   }

   @AfterMethod
   public void cleanUp(){
      driver.quit();
   }

   public void clickByCss(String locator){
      driver.findElement(By.cssSelector(locator)).click();
   }
   public void clickByXpath(String locator){
      driver.findElement(By.xpath(locator)).click();
   }
   public void typeByCss(String locator, String value){
      driver.findElement(By.cssSelector(locator)).sendKeys(value);
   }
   public void typeByXpath(String locator, String value){
      driver.findElement(By.xpath(locator)).sendKeys(value);
   }
   public void enterkeys(){
      
   }
}
