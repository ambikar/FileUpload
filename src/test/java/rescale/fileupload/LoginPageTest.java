package rescale.fileupload;

import org.testng.annotations.BeforeSuite;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPageTest {

	/**Variable containing the url for the test and creating references 
	 * for the webdriver and LoginPage object. 
	 */
	String url = "https://platform.rescale.com/";
	static WebDriver webdriver;
	LoginPage page;

	static Logger logger = Logger.getLogger(LoginPageTest.class.getName());

	/**BeforeSuite method runs before the suite of test cases 
	 * starts to execute. This initialises the webdriver
	 */
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/arajagopalan/Downloads/chromedriver-updated");
		webdriver = new ChromeDriver();
		logger.info("At before suite methodin loginPageTest class, created the chromedriver instance");
	}

	/**BeforeClass method which creates the LoginPage 
	 * object and passes the webdriver object as paramenter
	 */
	@BeforeClass
	public void beforeClass() {
		page = new LoginPage(webdriver);
		logger.info("Instantiated the login page class in beforeClass");
	}

	/**Test method to load the url and implicit wait 
	 * until the page is loaded
	 */
	@Test
	public void loadUrl() {
		webdriver.get(url);
		webdriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		logger.info("Started the chromedriver and loaded the platform rescale home page");

	}

	/**Test method which takes the user name and password
	 *  through the data provider and logs into the application
	 * @param username
	 * @param pwd
	 * @throws InterruptedException
	 */
	@Test(dependsOnMethods = "loadUrl", dataProvider = "loginDetails")
	public void login(String username, String pwd) throws InterruptedException {
		Thread.sleep(4000);
		page.login(username, pwd);
		logger.info("Logged into the rescale home page with the username and password provided");
		webdriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);

	}

	/**TestNG data provider which passes the username and 
	 * password for the login page
	 * @return username and password
	 */
	@DataProvider(name = "loginDetails")
	public Object[][] loginDetils() {
		return new Object[][] { { "ambikar@gmail.com", "Test@123" } };
	}

	/**static getter method for the webdriver object 
	 * which can be used for other test classes
	 * @return Webdriver object
	 */
	public static WebDriver getDriver() {
		return webdriver;

	}

	/**after class testNG method which deallocates 
	 * the page object and frees the memory
	 */
	@AfterClass
	public void afterClass() {
		page = null;
		logger.info("Deallocating the memory for the login page object. Its no more used");
	}

	/**AfterSUite method which quits the webdriver 
	 * after the testing of the entire suite is completed. 
	 */
	@AfterSuite
	public void tearDown() {
		webdriver.quit();
		logger.info("Quitting the webdriver as test is completed");
	}

}
