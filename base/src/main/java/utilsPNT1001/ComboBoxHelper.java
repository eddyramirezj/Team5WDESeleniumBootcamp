package utilsPNT1001;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ComboBoxHelper extends BaseClass {
	
	private static Select sel = null;
	
	public static void select(String locator,int index) {
		sel = new Select(getElementX(locator));
		sel.selectByIndex(index);
	}
	
	public static void select(String locator,String value) {
		sel = new Select(getElementX(locator));
		sel.selectByValue(value);
	}
	
	public static void selectByVisibleText(String locator,String text) {
		sel = new Select(getElementX(locator));
		sel.selectByVisibleText(text);
	}



	public static WebElement getElementX(String locator) {
		WebElement element = null;

		try {
			element = driver.findElement(By.xpath(locator));
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return element;

	}

}
