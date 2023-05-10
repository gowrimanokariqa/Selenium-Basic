package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TableWorkings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the HyperLink page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt41']")).click();
		driver.findElement(By.xpath("//li[@id='menuform:m_table']//span[text()='Table']")).click();
		
		//Search by Country
		WebElement search= driver.findElement(By.id("form:j_idt89:globalFilter"));
		search.sendKeys("India");
		List<WebElement> noOfRepresentative =driver.findElements(By.xpath("//tbody[@id='form:j_idt89_data']//tr"));
		int repCount = noOfRepresentative.size();
		System.out.println("No of Representative from india are "+ repCount);
		search.clear();
		
		//Sort by Name
		driver.findElement(By.id("form:j_idt89:j_idt92")).click();
		System.out.println("Table has beem sorted bu name");
		
		//Find the no of column in the table
		List<WebElement> Columns =driver.findElements(By.xpath("//thead[@id='form:j_idt89_head']//th"));
		int columnCount = Columns.size();
		System.out.println("Total no of column present in the table was "+columnCount);
	
		//Qualified rep count
		int qualifiedCount = driver.findElements(By.xpath("//span[contains(text(),'Status')]//following::span[contains(text(),'QUALIFIED')]")).size();
		System.out.println("Total qualified members on 1st page are "+ qualifiedCount);
		
		//Navigate to the NextPage
		driver.findElement(By.xpath("//a[@aria-label='Next Page']")).click();
	}

}
