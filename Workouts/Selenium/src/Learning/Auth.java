package Learning;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v108.network.Network;
import org.openqa.selenium.devtools.v108.network.model.Headers;
import org.openqa.selenium.interactions.Actions;

public class Auth {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.navigate().to("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on Element menu & opening the Wait page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//li[@id='menuform:j_idt38']")).click();
		driver.findElement(By.xpath("//span[text()='Auth']")).click();
		
		//Basic auth
		driver.findElement(By.id("j_idt88:j_idt90")).click();
		String currentWindow = driver.getWindowHandle();
		Set<String> newWindow =driver.getWindowHandles();
		for (String window : newWindow) {
			if(!window.equals(newWindow)) {
				driver.switchTo().window(window);
			}
		}
		//Store username & password in string
		String username = "admin";
		String password = "testleaf";
		
		//Created Session
		DevTools devTools = ((ChromeDriver) driver).getDevTools();
		devTools.createSession();
		
		devTools.send(Network.enable(Optional.of(10000), Optional.of(100000), Optional.of(100000)));
		String auth = username +":"+ password;
		
		String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Authorization", "Basic "+encodeToString);				
		devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
		
		driver.get("http://leafground.com:8090/login");
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();	
		
		String message = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Authorization message was "+ message);
	}

}
