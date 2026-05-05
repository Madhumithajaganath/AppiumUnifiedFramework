package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class SelectLocationPage {
@iOSXCUITFindBy(accessibility = "Use current location")
private WebElement useCurLoc;

@iOSXCUITFindBy(accessibility = "Go to current location")
private WebElement goToLoc;

@iOSXCUITFindBy(accessibility = "Set location")
private WebElement setLoc;

public SelectLocationPage(IOSDriver driver) {
	PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}

public WebElement getUseCurLoc() {
	return useCurLoc;
}

public WebElement getGoToLoc() {
	return goToLoc;
}

public WebElement getSetLoc() {
	return setLoc;
}

public void location() {
	useCurLoc.click();
	goToLoc.click();
	setLoc.click();
}
}
