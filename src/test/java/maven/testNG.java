package maven;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;



public class testNG {
	public static WebDriver driver=null;

	@BeforeSuite
	public void beforesuite() {
	
		  Date date = new Date();  
          Timestamp ts=new Timestamp(date.getTime());  
          SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
          System.out.println(formatter.format(ts));   
		
		
	}
	
	@BeforeTest
	
	private void Startdriver() {
		// TODO Auto-generated method stub

		//system.pr===chromepath
		
		///chromedriver 
		WebDriverManager.chromedriver().setup();
		
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
	}
	
	
	@BeforeClass
	
	private void NavigateToUrl() {
		
		driver.navigate().to("https://www.facebook.com/");
	}
	
	
	
	
	
	
	
	@Test
	private void tc1() {
		// TODO Auto-generated method stub

		
		//srcript validate login url
		WebDriverManager.chromedriver().setup();
		
		String currentUrl = driver.getCurrentUrl();
	
		Assert.assertEquals("https://www.facebook.com/", currentUrl);
	}
	
	@Test
	private void tc2() throws InterruptedException {
		// TODO Auto-generated method stub
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String expectedtitle = "Facebook – log in or sign up";
		String actualtitle= driver.getTitle();
	     Assert.assertEquals( actualtitle, expectedtitle);
		Thread.sleep(2000);
		

		
	}
	
	@Test
	private void tc3() throws InterruptedException {
		// TODO Auto-generated method stub

	
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("problem_user");
	   driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
		//String expectedurl = "Facebook – log in or sign up";
		//String actualtitle= driver.getTitle();
		//Assert.assertEquals( actualtitle, expectedurl);
		driver.findElement(By.className("_9ay7")).getText();
		String expectedtitle = "The email address you entered isn't connected to an account. Find your account and log in.";
		String actualtitle =driver.findElement(By.className("_9ay7")).getText();

		Assert.assertEquals(expectedtitle, actualtitle, "The email address you entered isn't connected to an account. Find your account and log in.");
          //System.out.println(actualtitle);
          Thread.sleep(2000);
	}
	
	
	
	
	
	@AfterTest
	private void testafter() {
		// TODO Auto-generated method stub
		driver.navigate().to("http://google.com");


		
	}
	
	@AfterClass
	
	private void classafter() {
		// TODO Auto-generated method stub
		driver.navigate().back();

		
		
	}
	
	
	@AfterSuite
	private void suiteafter() {
		// TODO Auto-generated method stub
		Date date = new Date();  
        Timestamp ts=new Timestamp(date.getTime());  
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        System.out.println(formatter.format(ts)); 
        driver.close();
			
	}
	
	

}
