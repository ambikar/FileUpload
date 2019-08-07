package rescale.fileupload;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.*;

public class LoginPage {

	WebDriver driver;

	/** LoginPage costructor which initializes the webdriver object and initializes the PageFactory. */
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/** WebElement locator for the username */
	@FindBy(className = ".input.active-input")
	public WebElement username;

	/** locator for the user next button */
	@FindBy(xpath ="/** *[@class='input-container']/div") 
	public WebElement usernext;

	/** locator for password field */
	@FindBy(xpath = "/** *[@name='password']")
	public WebElement password;

	/** locator for the login button */
	@FindBy(xpath = "/** *[@id='reactLoginComponentRoot']/div/div/div/div[1]/form/div[2]/div/button")
	public WebElement loginButton;
	
	
	/** Login method which takes the username, password and logs into the application */
	
	public void login(String username, String pwd) {
		/** JavascriptExecutor jse = (JavascriptExecutor) driver;
		/** jse.executeScript("document.getElementById('/** *[@class='active-input']').setAttribute('value', username");
*/
		this.username.sendKeys(username);
		this.usernext.click();
		this.password.sendKeys(pwd);
		
		this.loginButton.click();
	}

}