package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListWorkings {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the List page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt42']")).click();
		driver.findElement(By.xpath("(//*[@id='menuform:m_list']//*[contains(text(),'List')])[1]")).click();
		driver.manage().window().maximize();
		
		//click on list view
		driver.findElement(By.xpath("//input[@id='j_idt88_list']//parent::div")).click();
		System.out.println("Product visibility changed to list");
		
		//click on grid view
		driver.findElement(By.xpath("//input[@id='j_idt88_grid']//parent::div")).click();
		System.out.println("Product visibility changed to Grid");
		
		//RE-Order Element in From Listbox
		driver.findElement(By.xpath("//ul[@aria-label='From']//li[text()='Rome']")).click();
		driver.findElement(By.xpath("//button[@title='Move top']")).click();
		System.out.println("Rome has been moved to Top");
		
		//Moving All element => From - To
		driver.findElement(By.xpath("//button[@title='Add all']")).click();
		System.out.println("All the Elements in the From listbox has moved to To listbox");
		
		//Moving Paris from To - From
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@aria-label='To']//li[text()='Paris']")));
		driver.findElement(By.xpath("//ul[@aria-label='To']//li[text()='Paris']")).click();
		driver.findElement(By.xpath("//button[@title='Remove']")).click();
		System.out.println("Paris has beem moved To - From");
		
		//Re-order from Order list
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),'Cities')]//following::ul//li[text()='Berlin']")));
		driver.findElement(By.xpath("//*[contains(text(),'Cities')]//following::ul//li[text()='Berlin']")).click();
		driver.findElement(By.xpath("//div[@id='j_idt111']//following::button[@title='Move Bottom']")).click();
		System.out.println("Berlin has moved to Bottom in the order list");
	}

}
