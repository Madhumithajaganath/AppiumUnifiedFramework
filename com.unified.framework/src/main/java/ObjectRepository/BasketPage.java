package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class BasketPage {
@iOSXCUITFindBy(accessibility = "trailingIcon")
private WebElement icon;

@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeSwitch[`name == \"optionalChargesListItemSwitch\"`]")
private WebElement radio;



public BasketPage(IOSDriver driver) {
	PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}

public WebElement getIcon() {
	return icon;
}

public WebElement getRadio() {
	return radio;
}

public void icon() {
	icon.click();
}

public void radio() {
	radio.click();
}
}
