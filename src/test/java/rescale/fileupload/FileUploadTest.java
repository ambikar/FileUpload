package rescale.fileupload;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class FileUploadTest {

	/**  Reference variable for webdriver and FileUpload created */
	WebDriver webdriver;
	FileUpload file;
	WebDriverWait wait;

	static Logger logger = Logger.getLogger(FileUploadTest.class.getName());

	/** Before class method which initializes the FileUpload object and creates the WebDriver and WebdriverWait 
	 * object
	 */
	@BeforeClass
	public void setUp() {
		webdriver = LoginPageTest.getDriver();
		file = new FileUpload(webdriver);
		wait = new WebDriverWait(webdriver, 40);
		logger.info("Instantiated the webdriver and file object");
	}

	/** Test method which opens the File navigation page and uploads the file. 
	 * The file name is passe as parameter 
	 * @param filePath
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "filePath")
	public void clickFileUpload(String filePath) throws InterruptedException {
		logger.info("method to click on the file menu and upload the file");
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(file.filesMenu));
		element.click();
		webdriver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);

		file.fileUpload.sendKeys(filePath);
		Thread.sleep(3000);
		webdriver.navigate().refresh();
		
		logger.info("The file is uploaded and refreshed");
	}
	
	/** TestNG assertion which tests the name of the file uploaded matches 
	 * with the actual file in the Files page
	 */
	@Test
	public void testFileUploaded() {
		logger.info("asserting the name of file in the rescales files page matches with the file name uploaded");
		WebElement list = file.fileList;
		Assert.assertTrue(list.getText().contains("file"));

	}

	/** DataProvider containing the path to 
	 * the file to be uploaded
	 * @return Path to the file
	 */
	@DataProvider(name = "filePath")
	public Object[][] filePath() {
		return new Object[][] { { "/** Users/** arajagopalan/** data/** file" } };
	}
}