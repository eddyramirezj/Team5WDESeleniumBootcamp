package utilsPNT1001;

import base.BaseClass;

import java.util.ArrayList;
import java.util.List;

public class WindowHelper extends BaseClass {
	
	public static void switchTo(int index) {
		try {
			List<String> win = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(win.get(index));
		} catch (IndexOutOfBoundsException e) {
			throw new IndexOutOfBoundsException("Invalid Window Index : " + index);
		}
		
	}
	
	public static void switchToParentWithClose() {
		List<String> win = new ArrayList<String>(driver.getWindowHandles());
		
		for(int i = 1; i < win.size(); i++){
			driver.switchTo().window(win.get(i));
			driver.close();
		}
		driver.switchTo().window(win.get(0));
		
	}
	
	public static void back() {
		driver.navigate().back();
		
	}
	
	public static  void forward() {
		driver.navigate().forward();
		
	}
	
	public static void refresh() {
		driver.navigate().refresh();
		
	}
	
	public static void navigateToPage(String url) {
		driver.navigate().to(url);
	}
	
	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

}
