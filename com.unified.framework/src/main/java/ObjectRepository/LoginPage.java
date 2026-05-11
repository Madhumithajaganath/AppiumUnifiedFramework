package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage {

	AppiumDriver driver;
	
	LoginPage(AppiumDriver driver){
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Skip\"]")
	@iOSXCUITFindBy()
	private WebElement skipBtn;
	
	
	@AndroidFindBy(className = "android.widget.EditText")
	@iOSXCUITFindBy()
	private WebElement mobileNumber;
	
	@AndroidFindBy(id = "getOtpBtn")
	@iOSXCUITFindBy
	private WebElement getOTPBtn;

}
