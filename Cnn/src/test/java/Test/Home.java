package Test;
import CommonApi.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Kalkidan on 12/29/2015.
 */
public class Home extends Base{
   @Test
   public void navigateTabs(){
       driver.findElement(By.cssSelector("#search-button")).click();
   }
}
