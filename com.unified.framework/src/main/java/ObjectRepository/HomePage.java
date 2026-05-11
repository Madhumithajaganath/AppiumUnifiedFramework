package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage {
	AppiumDriver driver;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Search for  \"`]")
	@AndroidFindBy(id = "searchBox")
	private WebElement search;
	
	@iOSXCUITFindBy(accessibility = "Search 20000+ products")
	@AndroidFindBy(className = "android.widget.EditText")
	private WebElement searchfield;
	
	@iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Chocolate\"])[1]")
	@AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Chocolate\"])[1]")
	private WebElement item;
	
	

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getItem() {
		return item;
	}
	
	public HomePage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void home(String itemName) {
		search.click();
		searchfield.sendKeys(itemName);
		item.click();
	}

}
