package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.iOSGestureUtility;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class ProductPage {
	
	IOSDriver driver;
	
	
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
	
	public ProductPage(IOSDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	public void product() {
		image.click();
		
		iOSGestureUtility glib=new iOSGestureUtility(driver);
		glib.doubleTap(200, 431);
		glib.doubleTap(200, 431);
		glib.swipe("left");
		glib.swipe("right");
		close.click();

}
}
