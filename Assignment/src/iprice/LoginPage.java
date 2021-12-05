package iprice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	//Constructor that will be called as soon when object of the class is created
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//locator for international field
	By international = By.id("international");
	
	//locator best deals
	By bestDeals = By.xpath("//div[@class='i-amphtml-carousel-scroll']/a/amp-img/following-sibling:: div");

	//locator for top trending products
	By topTrending = By.xpath("//div[@class='i-amphtml-carousel-scroll']/a[@data-vars-cgt='click_trending_category_carousel_label']");
	
	
	
	public By getTopTrending() {
		return topTrending;
	}

	public void setTopTrending(By topTrending) {
		this.topTrending = topTrending;
	}

	public By getBestDeals() {
		return bestDeals;
	}

	public void setBestDeals(By bestDeals) {
		this.bestDeals = bestDeals;
	}

	public By getInternational() {
		return international;
	}

	public void setInternational(By international) {
		this.international = international;
	}
	
	
	
	

}
