import CommonApi.Base;
import org.testng.annotations.Test;

/**
 * Created by Kalkidan on 12/29/2015.
 */
public class HomePage extends Base{
   @Test
   public void navigateTabs(){

      clickByCss("#search-button");
   }
}
