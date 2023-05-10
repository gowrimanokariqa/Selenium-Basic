package Learning;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HyperLinkWorkings {

	public static void main(String[] args) {
System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the HyperLink page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//span[text()='Hyper Link']")).click();
		
		//Take me to dashboard
		driver.findElement(By.linkText("Go to Dashboard")).click();
		driver.navigate().back();
		
		//Find my destination
		WebElement urlToFind = driver.findElement(By.linkText("Find the URL without clicking me."));
		String URL=urlToFind.getAttribute("href");
		System.out.println("URL of the link is "+ URL);
		
		//Am I broken link?
		driver.findElement(By.linkText("Broken?")).click();
		String currentTitle = driver.getTitle();
		if(currentTitle.contains("404"))
		{
			System.out.println("Link has broken");
		}else {
			System.out.println("Link is not broken");
		}
		driver.navigate().back();
		
		//Duplicate Link
		driver.findElement(By.linkText("Go to Dashboard")).click();		
		driver.navigate().back();
		
		//Count Links
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int linkCount=links.size();
		System.out.println("Total link count is "+linkCount);
		
		//Count Layout Link
		driver.findElement(By.linkText("How many links in this layout?")).click();
		List<WebElement> layoutLinks=driver.findElements(By.tagName("a"));
		int layoutLinkCount=layoutLinks.size();
		System.out.println("Total Layout link count is "+layoutLinkCount);
	}

}
