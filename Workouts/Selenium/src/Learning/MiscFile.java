package Learning;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MiscFile {

	public static void main(String[] args) throws AWTException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the File page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt43']")).click();
		driver.findElement(By.xpath("(//*[@id='menuform:m_file']//*[contains(text(),'File')])[1]")).click();
		driver.manage().window().maximize();
		
		//Upload
		driver.findElement(By.xpath("//*[@id='j_idt88:j_idt89']//span[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left']")).click();
		
		StringSelection select = new StringSelection("C:\\Users\\ADMIN\\Documents\\Product Test Data.xlsx");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("File has been uploaded");
		
		//Download
		driver.findElement(By.id("j_idt93:j_idt95")).click();
		System.out.println("File downloaded");
	
		//Advance upload using wrong data
		driver.findElement(By.xpath("//div[@id='j_idt97:j_idt98']//span[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-left ui-fileupload-choose']")).click();
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		boolean errorMessage = driver.findElement(By.xpath("//div[@class='ui-messages-error ui-corner-all']")).isEnabled();
		System.out.println("Is error message appeared "+errorMessage);
		
		StringSelection validImage = new StringSelection("C:\\Users\\ADMIN\\Desktop\\Test Data Image.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(validImage, null);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		driver.findElement(By.xpath("//span[text()='Upload']//parent::button")).click();
		System.out.println("Image has uploaded");
		
	}

}
