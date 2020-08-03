package SauceLabs;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SauceLabTest {
	
	public static final String USERNAME = "ademkarapinar";
	public static final String ACCESS_KEY = "6273fe7a-7a14-4bf4-8b51-f790729bb870";
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    public static  String browsername = "Firefox";

	public static void main(String[] args) throws MalformedURLException {
		
		//Use Options function to change browser following:
		
		FirefoxOptions cap = new FirefoxOptions();
		
        //ChromeOptions cap = new ChromeOptions(); 
		//SafariOptions cap = SafariOptions();
		
		//Dont change this part
         cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
	                  UnexpectedAlertBehaviour.IGNORE);
         //Create desired capabilities
         DesiredCapabilities caps = new DesiredCapabilities();
         caps.setCapability("name", "Google verification");
         caps.setCapability("browserName", "Firefox");
         caps.setCapability("browserVersion", "70");
         caps.setCapability("platformName", "Windows 10");
         caps.setCapability("version", "53.0");

		//driver = new RemoteWebDriver(new URL("http://hub:4444/wd/hub"),cap);
		
		
		WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), cap);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Selenium Automation");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		System.out.println(driver.getTitle());
		
		driver.quit();
		System.out.println("Test is completed... ");
	
	}
}
