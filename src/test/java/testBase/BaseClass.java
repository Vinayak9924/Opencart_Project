package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public Logger logger;
	public WebDriver driver;
	public Properties p;

	@BeforeClass
	@Parameters({ "os", "browser" })
	public void setUp(String os, String br) throws IOException {

		// Loading config.properties file
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);

		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("invalid browser name......");
			return;
		}

		logger = LogManager.getLogger(this.getClass());

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));// reading value from properties file
		driver.manage().window().maximize();
	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}

	public String randomString() {
		String GenertatedString = RandomStringUtils.randomAlphabetic(5);
		return GenertatedString;
	}

	public String randomNumber() {
		String Genertatednum = RandomStringUtils.randomAlphabetic(10);
		return Genertatednum;
	}

	public String randomAlphaNumeric() {
		String GenertatedString = RandomStringUtils.randomAlphabetic(3);

		String Genertatednum = RandomStringUtils.randomAlphabetic(3);
		return (GenertatedString + "@" + Genertatednum);
	}

}
