package amazon;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import CommonApi.Base;

/**
 * Created by Kalkidan on 12/30/2015.
 */
public class Retail extends Base {
   @Test
   public void home(){
      typeByCss("#twotabsearchtextbox", "Dominique o'Brien");
   }
}
