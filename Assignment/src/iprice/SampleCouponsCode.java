package iprice;

import static org.testng.AssertJUnit.assertTrue;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SampleCouponsCode {
	public static void main(String args[]){  
    System.setProperty("webdriver.chrome.driver","C://Users//User//project/chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 WebDriverWait wait = new WebDriverWait(driver,20);
	 driver.get("https://iprice.my/coupons");
	 driver.manage().window().maximize();
	 CouponPage coupon = new CouponPage(driver);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(coupon.getInternational()));
	 
	 //getting the list of stores under Coupon Stores
	 List<WebElement> couponStoreList = driver.findElements(coupon.getCouponStores());
	 System.out.println("Count of list of stores under Coupon Stores =  "+couponStoreList.size());
 	 for(int i = 0; i<couponStoreList.size() ; i++){
  		assertTrue(couponStoreList.get(i).isEnabled());
  		
      }
 	 driver.quit();
	}
}
