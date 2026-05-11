package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.iOSGestureUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductPage {
	
	AppiumDriver driver;
	
	
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeOther[`name == \"imgProduct\"`]")
	private WebElement image;
	
	@iOSXCUITFindBy(accessibility = "closeButton")
	private WebElement close;

	public WebElement getImage() {
		return image;
	}

	public WebElement getClose() {
		return close;
	}
	
	public ProductPage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void product() {
		image.click();
		
}
}
