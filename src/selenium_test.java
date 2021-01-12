import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class selenium_test {
	// Browser config javascript commands (need to be launched from chrome://flags)
	private static String enable_quic_command = "chrome.send('enableExperimentalFeature',['enable-quic' + '@' + 1, 'true'])";
	private static String enable_fastopen_command  = "chrome.send('enableExperimentalFeature', ['enable-tcp-fast-open', 'true'])";

	public static void main(String[] args) throws Exception {

		String chromedriver = "/Users/sagjain/paypal-workspace/DSPE/Data-Releases/releases/selfservice/tests/app/chromedriver";
		System.setProperty("webdriver.chrome.driver",chromedriver);
		ChromeOptions options = new ChromeOptions();
//		Set disk and media cache size to disable caching
		options.setBinary(chromedriver);
		options.addArguments("--disk-cache-size=1");
		options.addArguments("--media-cache-size=1");

		options.addArguments("start-maximized"); // open Browser in maximized mode
		options.addArguments("disable-infobars"); // disabling infobars
		options.addArguments("--disable-extensions"); // disabling extensions
		options.addArguments("--disable-gpu"); // applicable to windows os only
		options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
		options.addArguments("--no-sandbox"); // Bypass OS security model
		options.addArguments("--headless");


//		Set our own, to be re-used, profile
		String time_string = "NOT SURE OF THIS";
		String profile_folder = "/tmp/" + "profile_chrome_" + time_string;
		options.addArguments("user-data-dir=" + profile_folder);

//		Create driver
		ChromeDriver driver = new ChromeDriver(options);
//		WebDriver driver = new RemoteWebDriver(new URL("https://localhost"), options);
//		Set experimental features
		chrome_configure_experimental_flags(driver);
//		Close and re-build driver with same options (and so same profile, so experimental flags will be kept)
		driver.close();
//		driver = new ChromeDriver(options);
	}
	private static void chrome_configure_experimental_flags(ChromeDriver myDriver) throws InterruptedException {
		myDriver.get("chrome://flags");                     // Load page where configuration javascript commands are allowed
		JavascriptExecutor js = (JavascriptExecutor)myDriver;
		js.executeScript(enable_quic_command);				// Enable QUIC
		js.executeScript(enable_fastopen_command); 			// Enable TCP
		myDriver.get("chrome://flags");						// Re-load so that we can check
		Thread.sleep(2000);
	}

}