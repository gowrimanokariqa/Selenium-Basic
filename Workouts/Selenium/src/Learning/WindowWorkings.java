package Learning;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowWorkings {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Gowri_Backup\\driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		//open respective page
		driver.get("https://www.leafground.com/dashboard.xhtml");
		
		//clicking on browser menu & opening the Window page
		driver.findElement(By.xpath("//ul[@id='menuform:j_idt37']//following::li[@id='menuform:j_idt39']")).click();
		driver.findElement(By.xpath("//span[text()='Window']")).click();
		
		//click the button & confirm new window opened
		String firstWindow=driver.getWindowHandle();
		driver.findElement(By.id("j_idt88:new")).click();
		Set<String> allWindows=driver.getWindowHandles();
		for (String newWindow : allWindows) {
			driver.switchTo().window(newWindow);
		}
		String Title =driver.getTitle();
		System.out.println("New window title is "+Title);
		
		driver.switchTo().window(firstWindow);
		
		//click and open multiple
		driver.findElement(By.id("j_idt88:j_idt91")).click();
		Set<String> multipleWindows = driver.getWindowHandles();
		int openedWindows = multipleWindows.size();
		System.out.println("No of windows opened are "+ openedWindows);
		
		driver.switchTo().window(firstWindow);
		
		//Close all windows except Primary
		driver.findElement(By.id("j_idt88:j_idt93")).click();
		Set<String> closeWindows = driver.getWindowHandles();
		for (String currentwindow : closeWindows) {
			if(!currentwindow.equals(firstWindow)) {
				driver.switchTo().window(currentwindow);
				driver.close();
			}
		}
		driver.switchTo().window(firstWindow);
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//open window with delay
		driver.findElement(By.id("j_idt88:j_idt95")).click();
		Set<String> delayWindows = driver.getWindowHandles();
		int delayWindowsCount = delayWindows.size();
		
		wait.until(ExpectedConditions.numberOfWindowsToBe(delayWindowsCount));
		driver.quit();
	}
}
