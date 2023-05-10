package Learning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButton {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the RadioButton page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt40']")).click();
		driver.findElement(By.xpath("//span[text()='Radio Button']")).click();	
		
		//most favorite browser
		driver.findElement(By.xpath("(//table[@id='j_idt87:console1']//div[@class='ui-radiobutton ui-widget'])[3]")).click();
		
		//selected
		WebElement firstValue = driver.findElement(By.id("//*[@id=\"j_idt87:console2\"]/tbody/tr/td[1]/div/div[2]"));
		boolean firstStatus = firstValue.isSelected();
		WebElement secondValue = driver.findElement(By.xpath("//*[@id=\"j_idt87:console2\"]/tbody/tr/td[2]/div/div[2]"));
		boolean secondStatus = secondValue.isSelected();
		WebElement thirdValue = driver.findElement(By.xpath("//*[@id=\"j_idt87:console2\"]/tbody/tr/td[3]/div/div[2]"));
		boolean thirdStatus = thirdValue.isSelected();
		WebElement fourthValue = driver.findElement(By.xpath("//*[@id=\"j_idt87:console2\"]/tbody/tr/td[4]/div/div[2]"));
		boolean fourthStatus = fourthValue.isSelected();
		System.out.println("is Chrome selected " +firstStatus +"\nis Firefox selected "+secondStatus +"\nis Safari selected "+thirdStatus+"\nis Edge selected "+fourthStatus );
		
		//Select the age group you wish to be
		driver.findElement(By.xpath("(//div[@id='j_idt87:age']//div[@class='ui-radiobutton-box ui-widget ui-corner-all ui-state-default'])[1]")).click();
		
	}
}


