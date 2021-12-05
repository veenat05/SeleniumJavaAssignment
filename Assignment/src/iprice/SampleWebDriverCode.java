package iprice;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SampleWebDriverCode {
	
	 public static void main(String args[]){  
     System.setProperty("webdriver.chrome.driver","C://Users//User//project/chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 WebDriverWait wait = new WebDriverWait(driver,20);
	 driver.get("https://www.iprice.my");
	 driver.manage().window().maximize();
	 LoginPage login = new LoginPage(driver);
	 wait.until(ExpectedConditions.visibilityOfElementLocated(login.getInternational()));
	 
	 //getting the list of stores under Find Best deals Online
	 List<WebElement> bestDealsList = driver.findElements(login.getBestDeals());
	 System.out.println("Count of list of stores under Find Best deals Online =  "+bestDealsList.size());
	 System.out.println("Stores under Find Best deals Online:");
	 	 for(int i = 0; i<bestDealsList.size() ; i++){
		 	System.out.println(bestDealsList.get(i).getText());
	     }
	 	 
	 //getting the list of stores under Top trending Products
	 List<WebElement> topTrendingList = driver.findElements(login.getTopTrending());
	 System.out.println("Count of list of stores under Top Trending Products =  "+topTrendingList.size());
	 System.out.println("Stores under Find Top Trending Deals:");
	 
 	 for(int i = 0; i<topTrendingList.size() ; i++){
 		if(topTrendingList.get(i).getAttribute("data-vars-cgt")!=null) {
	 	System.out.println(topTrendingList.get(i).getText());
 		} else {
 			System.out.println("Attribute data-vars-cgt not present");
 		}
     }
	 driver.quit();
	 }
}
