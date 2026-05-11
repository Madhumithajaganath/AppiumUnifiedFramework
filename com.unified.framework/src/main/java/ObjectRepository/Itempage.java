package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Itempage {
	
	AppiumDriver driver;
	public Itempage(AppiumDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSXCUITFindBy(iOSNsPredicate = "label == \"Add\" AND name == \"addButtonProduct\"")
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='addButtonProduct']")
	private WebElement add;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Basket']")
	@AndroidFindBy(id = "basketButton")
	private WebElement basket;

	public WebElement getAdd() {
		return add;
	}
	public WebElement getBasket() {
		return basket;
	}
	
	public void item() {
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Milkybar Moosha Caramel & Nougat Bar\"]")).click();
	}
	
	public void add() {
		add.click();
		basket.click();
	}

}
