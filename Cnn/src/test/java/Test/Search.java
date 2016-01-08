package Test;

import CommonApi.Base;
import Util.DataReader;
import news.CnnBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import java.io.IOException;

/**
 * Created by Kalkidan on 1/5/2016.
 */
public class Search extends Base{
   DataReader dr= new DataReader();
   String path="Cnn\\Data\\file1.xls";


   @Test
   public void searchItems() throws IOException{
      String [][] itemLocator = dr.fileReader(path);

      typeByCssThenEnter(itemLocator[1][0], itemLocator[1][1]);
      typeByCssThenEnter(itemLocator[2][0], itemLocator[2][1]);
      typeByCssThenEnter(itemLocator[3][0], itemLocator[3][1]);
      typeByCssThenEnter(itemLocator[4][0], itemLocator[4][1]);
   }
}
