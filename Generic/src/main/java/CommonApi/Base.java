package CommonApi;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Kalkidan on 12/29/2015.
 */

public class Base {

   public WebDriver driver=null;
   @Parameters({"useSauceLab","userName","key","appUrl", "os","browserName","browserVersion"})
   @BeforeMethod
   public void setUp(boolean useSauceLab, String userName, String key,String appUrl, String os, String browserName, String browserVersion)
   throws IOException{
      if(useSauceLab==true){
         getSauceLabDriver(userName,key,os,browserName,browserVersion);
      }else {
         driver = getLocalDriver(os, browserName);
      }
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.navigate().to(appUrl);
         driver.manage().window().maximize();
   }

   @AfterMethod
   public void cleanUp() throws InterruptedException{
      driver.quit();
   }
   //get local Driver
   public WebDriver getLocalDriver(String os, String browserName){
      if(browserName.equalsIgnoreCase("firefox")){
         driver=new FirefoxDriver();
      }else if(browserName.equalsIgnoreCase("chrome")){
         if(os.equalsIgnoreCase("Windows")){
            System.setProperty("webdriver.chrome.driver","Generic\\Selenium-Browse-Driver\\SeleniumInternetDrivers\\chromedriver.exe");
         }else{
            System.setProperty("webdriver.chrome.driver","Generic/Selenium-Browse-Driver/SeleniumInternetDrivers/chromedriver.exe");
         }
         driver=new ChromeDriver();
      }else if(browserName.equalsIgnoreCase("safari")){
         driver=new SafariDriver();
      }else if(browserName.equalsIgnoreCase("ie")){
         System.setProperty("webdriver.ie.driver","Generic\\Selenium-Browse-Driver\\SeleniumInternetDrivers\\IEDriverServer.exe" );
         driver = new InternetExplorerDriver();
      }else if(browserName.equalsIgnoreCase("htmlunit")){
         driver=new HtmlUnitDriver();
      }
      return driver;
   }
   //get cloud Driver
   public WebDriver getSauceLabDriver(String userName, String key, String os, String browserName,String browserVersion) throws IOException{
      DesiredCapabilities cap=new DesiredCapabilities();
      cap.setCapability("platform",os);
      cap.setBrowserName(browserName);
      cap.setCapability("version",browserVersion);
      driver=new RemoteWebDriver(new URL("http://"+ userName + ":"+ key + "@ondemand.saucelabs.com:80/wd/hub"), cap);
      return driver;
   }

   public void clickByCss(String locator){
      driver.findElement(By.cssSelector(locator)).click();
   }
   public void clickByXpath(String locator){
      driver.findElement(By.xpath(locator)).click();
   }
   public void typeByCss(String locator, String value){
      driver.findElement(By.cssSelector(locator)).sendKeys(value, Keys.CLEAR);
   }
   public void typeByCssThenEnter (String locator, String value){
      driver.findElement(By.cssSelector(locator)).sendKeys(Keys.CLEAR, value, Keys.ENTER);
   }
   public void typeByXpath(String locator){
      driver.findElement(By.xpath(locator)).click();
   }
   public void clickById(String locator){
      driver.findElement(By.id(locator)).click();
   }
   public void navigateBack(){
      driver.navigate().back();
   }
   public void navigateForward(){
      driver.navigate().forward();
   }
   public String getTextByCss(String locator){
      String st = driver.findElement(By.cssSelector(locator)).getText();
      return st;
   }
   public String getTextByXpath(String locator){
      String st=driver.findElement(By.xpath(locator)).getText();
      return st;
   }
   public String getTextById(String locator){
      String st=driver.findElement(By.id(locator)).getText();
      return st;
   }
   public String getTextByName(String locator){
      String st=driver.findElement(By.name(locator)).getText();
      return st;
   }
   public WebElement getWebElementByCss(String locator){
      WebElement element = driver.findElement(By.cssSelector(locator));
      return element;
   }
   public List<WebElement> getWebElementsByCss(String locator){
      List<WebElement> elementList=new ArrayList<WebElement>();
      elementList = driver.findElements(By.cssSelector(locator));
      return elementList;
   }
   public WebElement getWebElementByXpath(String locator){
      WebElement element=driver.findElement(By.xpath(locator));
      return element;
   }
}
