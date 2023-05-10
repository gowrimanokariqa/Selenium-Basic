package Learning;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ButtonWorkings {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the Button page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//span[text()='Button']")).click();

		//click button & get title
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		String Title = driver.getTitle();
		System.out.println("The page title is "+ Title);
		driver.navigate().back();
		
		//Check if the button is enabled
		WebElement Button = driver.findElement(By.id("j_idt88:j_idt92"));
		boolean statusOfButton = Button.isEnabled();
		System.out.println("Is button enabled " +statusOfButton);
		
		//Find the position of button
		WebElement submitButton = driver.findElement(By.id("j_idt88:j_idt94"));
		Point position = submitButton.getLocation();
		System.out.println("The Position of the Submit button was " +position);
		
		//Find the button color
		WebElement saveButton = driver.findElement(By.id("j_idt88:j_idt96"));
		String buttonColor= saveButton.getCssValue("color");
		System.out.println("Save button color was "+buttonColor);
		
		//Find height and width of the button
		WebElement submitButton1 =driver.findElement(By.id("j_idt88:j_idt98"));
		Dimension heightWidth = submitButton1.getSize();
		System.out.println("Height and Width of Subimit button was "+heightWidth);
		
		//Mouse over and confirm the color changed
		WebElement sucessButton = driver.findElement(By.id("j_idt88:j_idt100"));
		String beforeHoverAction = sucessButton.getCssValue("background-color");
		System.out.println("Color of button before mousehover "+beforeHoverAction);
		Actions action= new Actions(driver);
		action.moveToElement(sucessButton).perform();
		String afterHoverAction = sucessButton.getCssValue("background-color");
		System.out.println("Color of button after mousehover "+afterHoverAction);
		
		//Click Image Button and Click on any hidden button
		WebElement imageButton = driver.findElement(By.id("j_idt88:j_idt102:imageBtn"));
		imageButton.click();
		
		//How many buttons are there?
		List<WebElement> roundedButtonCount = driver.findElements(By.tagName("button"));
		System.out.println("Count of button is "+roundedButtonCount.size());			
	}
}
