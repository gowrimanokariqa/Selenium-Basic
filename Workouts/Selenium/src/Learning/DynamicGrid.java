package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicGrid {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the Dynamic Grid page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt41']")).click();
		driver.findElement(By.xpath("//li[@id='menuform:m_dynamic']//span[text()='Dynamic Grid']")).click();
		
		//Find the no of Rows in the table
		int rowCount = driver.findElements(By.xpath("//*[@id='form:customers_data']//following::tr")).size();
		System.out.println("No of Rows in the Table are "+ rowCount);
		
		//Sort data in table by date
		driver.findElement(By.id("form:customers:j_idt91:1")).click();
		
		//Update column
		WebElement TextBox =driver.findElement(By.id("form:template"));
		TextBox.clear();
		TextBox.sendKeys("name status");
		driver.findElement(By.id("form:j_idt89")).click();
		System.out.println("Column in the table updated according to the entered data");
	}

}
