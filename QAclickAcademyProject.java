package GenericCode;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.sun.java.swing.plaf.windows.resources.windows;

public class QAclickAcademyProject {

	private static final String Set = null;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
//		Thread.sleep(2000);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String str = "Krish";
		
		//Handling Header..
		
		WebElement img = driver.findElement(By.cssSelector("img.logoClass"));
		img.click();
		Thread.sleep(2000);
		driver.navigate().back();
		
		//Count the entire buttons in the page...
		
		System.out.println(driver.findElements(By.tagName("button")).size()); //Totally 6 buttons in the spage..
		
		//Home Button Window Handles..
//		WebElement Home = driver.findElement(By.xpath("//*[text()='Home']"));
//		Home.click();
//		Thread.sleep(2000);
//		driver.navigate().back();
		
		//Main Page..
		
		//Practice page..
		
		System.out.println(driver.findElement(By.xpath("//h1[text()='Practice Page']")).getText());
		
		//Radio Buttons..
		
		WebElement Radio = driver.findElement(By.xpath("//*[@value='radio3']"));
		Radio.click();
		//Number of radio buttons..
		System.out.println(driver.findElement(By.xpath("//*[@type='radio']")));
		
//		AutoSuggestive Text Box...
		WebElement auto = driver.findElement(By.id("autocomplete"));
		auto.click();
		auto.sendKeys("ind");
		auto.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN);
		auto.sendKeys(Keys.ENTER);
		
		//Dropdown Box..
		WebElement Dropdown = driver.findElement(By.cssSelector("#dropdown-class-example"));
		Dropdown.click();
		Select sel= new Select(Dropdown);
		sel.selectByValue("option1");

		//Checkboxes..
		
		WebElement Chk = driver.findElement(By.id("checkBoxOption2"));
		Chk.click();
		//Chk the number of text boxes present..
		System.out.println(driver.findElement(By.xpath("//input[@type='checkbox']")).getSize());
		
		//Switch Window..
		
		WebElement ParentWindow = driver.findElement(By.id("openwindow"));
		ParentWindow.click();
		
		//Set Operator to choose..
		Set <String> ids = driver.getWindowHandles();
		
		//Iterator is used to choose based on index..
		Iterator <String> it = ids.iterator();
		
		//it.next is the parewnt window id...
		String ParentWindowId = it.next();
		System.out.println("parent window id :" +ParentWindowId);
		
		//Child Window id..
		String ChildWindowId = it.next();
		System.out.println("parent window id :" +ChildWindowId);
		
		driver.switchTo().window(ChildWindowId);
		
		System.out.println("child window popup title :" +driver.getTitle());
		
		//Working on child window id..
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/ul/li[1]/div/h3/a")).click();
		Thread.sleep(2000);
		
		driver.close();
		
		//Switch from Child to Parent.. 
		driver.switchTo().window(ParentWindowId);
		System.out.println("parent window popup title:" +driver.getTitle());
		
//		//Working on Alerts..
		WebElement Alerts = driver.findElement(By.name("enter-name"));
		Alerts.click();
		Alerts.sendKeys(str); 
		Thread.sleep(2000);
		//Ok Button..
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
		//Cancel Button..
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		//Element Displayed Example

		WebElement inputbox = driver.findElement(By.id("displayed-text"));
		inputbox.click();
		inputbox.sendKeys("Krish");
		//Hide Button..
		WebElement Hide = driver.findElement(By.id("hide-textbox"));
		Hide.click();
		//Show
		WebElement Show = driver.findElement(By.id("show-textbox"));
		Show.click();
		
		//Mouseover Actions..
		WebElement Mouse = driver.findElement(By.xpath("//button[@id='mousehover']"));
//		Mouse.click();
		Actions act = new Actions(driver);
		act.moveToElement(Mouse).build().perform();
		
		//Reload the page using mouseover...
		WebElement Reload = driver.findElement(By.xpath("//*[@class='mouse-hover-content']/a[2]"));
		Thread.sleep(1000);
		Reload.click();
		
//		//Entering into Frames..
//		driver.switchTo().frame("//iframe[@id='courses-iframe']");
//		
//		//Working on frames..
//		//Selecting Selenium Course..
//		driver.findElement(By.linkText("Selenium Webdriver with Java Basics ")).click();
//		driver.switchTo().defaultContent();
		
		
		//Count the Entire links of the Footer Link only..
		//This is called Limiting the driver...
		WebElement FooterDriver = driver.findElement(By.xpath("//div[@id='gf-BIG']"));
		System.out.println("Number of footer links: " +FooterDriver.findElements(By.tagName("a")).size());
		
		//Count the 1st section link of the footer driver...
		WebElement Section1 = FooterDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println("Number of footer Section 1 links: " +Section1.findElements(By.tagName("a")).size());		
		
		//Get the text named discount coupen..
		System.out.println(driver.findElement(By.xpath("//*[text()='Discount Coupons']")).getText());
		
		//Click on each footer section 1 links and open it in the another tab..
		//Using Forloops..
		for(int i=1 ; i<Section1.findElements(By.tagName("a")).size(); i++)
		{
			//Press control keyt so that it will get open into the newtab..
			String Clickoneachlinks = Keys.chord(Keys.CONTROL,Keys.ENTER);
			
			//Getting i so that it is common for every links...
			//For every Keyboard events we have to use sendkeys method..
			Section1.findElements(By.tagName("a")).get(i).sendKeys(Clickoneachlinks); 
			Thread.sleep(4000);
		}
		
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> its=abc.iterator();
		
		while(its.hasNext()) //it.hasnext() it will search if there are any index present or not...
		{
			
		   driver.switchTo().window(its.next()); //it.next() will move to another tab...
		   System.out.println(driver.getTitle());
		
		}
		
		driver.quit();
}
	
}
