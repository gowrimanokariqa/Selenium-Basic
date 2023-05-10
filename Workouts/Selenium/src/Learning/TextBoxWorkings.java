package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TextBoxWorkings {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the TextBox page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
		
		//Type name
		driver.findElement(By.id("j_idt88:name")).sendKeys("Gowrimanokari");
		
		//Append City
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Coimbatore");
		
		//Checking whether the textbox is enabled
		boolean isTextBoxEnabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
		System.out.println("Is the Text Box enabled " + isTextBoxEnabled);
		
		//Clear the text
		driver.findElement(By.id("j_idt88:j_idt95")).clear();
		
		//Retrieve the Typed Text
		String WordinTheBox = driver.findElement(By.id("j_idt88:j_idt97")).getAttribute("value");
		System.out.println("Text present in the box is " + WordinTheBox);
		
		//Type mail & click TAB
		WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
		email.sendKeys("gowri@widelast.com");
		email.sendKeys(Keys.TAB);
		
		//Type about self
		driver.findElement(By.id("j_idt88:j_idt101")).sendKeys("Test Engineer");
		
		//Text Editor
		driver.findElement(By.xpath("(//div[@id='j_idt88:j_idt103_editor']//following::div[@class='ql-clipboard'])[1]")).sendKeys("Check");
		driver.findElement(By.className("ql-bold")).click();
		
		//Press enter & ensure error appeared
		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(Keys.ENTER);
		boolean errorEnabled = driver.findElement(By.id("j_idt106:thisform:j_idt110")).isEnabled();
		System.out.println("The Error message has appeared "+ errorEnabled);
		
		//Ensure the position changes
		WebElement label = driver.findElement(By.id("j_idt106:j_idt113"));
		Dimension starting_point = label.getSize();
		WebElement initial =driver.findElement(By.id("j_idt106:float-input"));
		initial.click();
		Dimension next_point = label.getSize();
		System.out.println("The position of Label change from " +starting_point+"to " +next_point);
		
		//Type text & choose third option
		/*driver.findElement(By.xpath("//input[@id='j_idt106:auto-complete_input']")).sendKeys("Gowri");
		List<WebElement> values =driver.findElements(By.xpath("(//span[@id='j_idt106:auto-complete_panel'])//li"));
		values.get(3).click();*/
		
		//type your DOB & ensure entered date selected
		driver.findElement(By.id("j_idt106:j_idt116_input")).sendKeys("04/10/1995");
		
		//Type number and spin to confirm value changed
		WebElement number = driver.findElement(By.id("j_idt106:j_idt118_input"));
		number.sendKeys("5");
		driver.findElement(By.xpath("//*[@id='j_idt106:j_idt118_input']//following::a[1]")).click();
		System.out.println("Number in the field should be "+number.getAttribute("aria-valuenow"));
		
		//Type random number (1-100) and confirm slider moves correctly
		driver.findElement(By.id("j_idt106:slider")).sendKeys("50");
		String sliderValue=driver.findElement(By.xpath("//div[@id='j_idt106:j_idt120']//div[@class='ui-slider-range ui-corner-all ui-widget-header ui-slider-range-min']")).getAttribute("style");
		System.out.println("Slider value is "+sliderValue);
		
		//Click and Confirm Keyboard appears
		driver.findElement(By.id("j_idt106:j_idt122")).click();
		boolean keyboardVisibility = driver.findElement(By.xpath("//div[@id='j_idt133']//following::div[@class='ui-widget ui-widget-content ui-corner-all ui-shadow keypad-popup ui-input-overlay']")).isEnabled();
		System.out.println("Is Keyboard enabled "+keyboardVisibility);	
	}
	
}
