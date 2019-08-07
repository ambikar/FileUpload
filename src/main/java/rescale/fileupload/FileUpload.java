package rescale.fileupload;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.*;

public class FileUpload {

	WebDriver driver;

	/** FileUpload costructor which initializes the webdriver object and initializes the PageFactory.*/
	public FileUpload(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/** element locator for the File link in the menu bar */
	@FindBy(id="menuFiles")
	public WebElement filesMenu;

	/** element locator for the file upload button */
	@FindBy(xpath = "//*[@id='filesPageDropZone']/input")
	public WebElement fileUpload;

	/** element locator which locates the file uploaded in the Files page */
	@FindBy(xpath="//*[@id=\"filesList\"]/div/div/div[2]/div[3]/table/tbody/tr/td[2]")
	public WebElement fileList;
}
