package testPom;

import base.MySQLConnection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;

public class TestResultsPage extends TestBase {

  @Test (enabled = true)
    public void testGetNumberOfBedsOnSale() {
      MySQLConnection mySQLConnection = new MySQLConnection();
      String numOfBedsOnSale = getResultsPage().getNumberOfBedsOnSale();

      String[] results = numOfBedsOnSale.split("of ");
      mySQLConnection.insertResultsIntoDB("seleniumbootcamp. overstock_search_results", "product", "results", "beds", results[1]);

      String actualResults = results[1];
      String expectedResults = "780 Results";

      Assert.assertEquals(actualResults, expectedResults);


  }

}
