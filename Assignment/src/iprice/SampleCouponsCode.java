package iprice;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class SampleCouponsCode {
    public static void main(String args[]) {
        System.setProperty("webdriver.chrome.driver", "C://Users//User//project/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.get("https://iprice.my/coupons");
        driver.manage().window().maximize();
        CouponPage coupon = new CouponPage(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(coupon.getInternational()));

        //getting the list of stores under Coupon Stores
        List < WebElement > couponStoreList = driver.findElements(coupon.getCouponStores());
        System.out.println("Count of list of stores under Coupon Stores =  " + couponStoreList.size());

        //to check whether all urls are active
        for (int k = 0; k < couponStoreList.size(); k++) {
            assertTrue(couponStoreList.get(k).isEnabled());
        }

        //to navigate to each and every url in the top stores
        String[] linksText = new String[couponStoreList.size()];
        String[] link = new String[couponStoreList.size()];
        int i = 0;
        for (WebElement a: couponStoreList) {
            linksText[i] = a.getText();
            link[i] = a.getAttribute("href");
            i++;
        }
        for (int j = 0; j < linksText.length; j++) {
            By linkTextLocator = By.linkText(linksText[j]);
            driver.findElement((linkTextLocator)).click();
            if (driver.getCurrentUrl() == link[j]) {
                assertTrue("Both Urls are the same", true);
            }
            driver.navigate().back();
        }
        driver.quit();
    }
}