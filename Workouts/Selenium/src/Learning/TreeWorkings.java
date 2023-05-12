package Learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TreeWorkings {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the Tree page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt42']")).click();
		driver.findElement(By.xpath("(//*[@id='menuform:m_tree']//*[contains(text(),'Tree')])[1]")).click();
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		//Check Expenses.doc from the Tree
		driver.findElement(By.xpath("(//li[@id='j_idt88:0']//span[@class='ui-tree-toggler ui-icon ui-icon-triangle-1-e'])[1]")).click();
		driver.findElement(By.xpath("//li[@id='j_idt88:0_0']//span[@class='ui-tree-toggler ui-icon ui-icon-triangle-1-e']")).click();
		driver.findElement(By.xpath("//li[@id='j_idt88:0_0_0']//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default']")).click();
		System.out.println("Expenses.doc checkbox has clicked");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
		//Check the Goodfellas from Tree list
		driver.findElement(By.xpath("//*[@id='j_idt98_data']//following::tr[@id='j_idt98_node_2']//span[@class='ui-treetable-toggler ui-icon ui-icon-triangle-1-e ui-c']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='j_idt98_node_2']//following-sibling::tr[@id='j_idt98_node_2_1']//span[@class='ui-treetable-toggler ui-icon ui-icon-triangle-1-e ui-c']")));
		driver.findElement(By.xpath("//*[@id='j_idt98_node_2']//following-sibling::tr[@id='j_idt98_node_2_1']//span[@class='ui-treetable-toggler ui-icon ui-icon-triangle-1-e ui-c']")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='j_idt98_node_2_1_0']//following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")));
		driver.findElement(By.xpath("(//*[@id='j_idt98_node_2_1_0']//following::div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		System.out.println("Goodfellas has checked");
		
		js.executeScript("window.scrollBy(0,350)");
		
		//Expand the Horizontal tree
		driver.findElement(By.xpath("//td[@data-rowkey='root']//span[@class='ui-tree-toggler ui-icon ui-icon-plus']")).click();
		driver.findElement(By.xpath("//td[@data-rowkey='0']//span[@class='ui-tree-toggler ui-icon ui-icon-plus']")).click();
		driver.findElement(By.xpath("//td[@data-rowkey='0_0']//span[@class='ui-tree-toggler ui-icon ui-icon-plus']")).click();
		driver.findElement(By.xpath("//td[@data-rowkey='1']//span[@class='ui-tree-toggler ui-icon ui-icon-plus']")).click();
		driver.findElement(By.xpath("//td[@data-rowkey='2']//span[@class='ui-tree-toggler ui-icon ui-icon-plus']")).click();
		driver.findElement(By.xpath("//td[@data-rowkey='2_0']//span[@class='ui-tree-toggler ui-icon ui-icon-plus']")).click();
		System.out.println("Horizontal tree has expended");
	}
}
