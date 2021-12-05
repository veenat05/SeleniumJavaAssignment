package iprice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CouponPage {
	WebDriver driver;
	//Constructor that will be called as soon when object of the class is created
	public CouponPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//locator for international field
	By international = By.id("international");
	
	//locator of coupon stores
	By couponStores = By.xpath("//div[@class='rY']/p/a");
	

	public By getCouponStores() {
		return couponStores;
	}

	public void setCouponStores(By couponStores) {
		this.couponStores = couponStores;
	}

	public By getInternational() {
		return international;
	}

	public void setInternational(By international) {
		this.international = international;
	}
	
	
}