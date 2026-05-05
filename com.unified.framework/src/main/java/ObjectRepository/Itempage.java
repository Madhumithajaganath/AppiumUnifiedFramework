package ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Itempage {
	IOSDriver driver;
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Milkybar Moosha Caramel & Nougat Bar\"]")
	private WebElement product;
	
	@iOSXCUITFindBy(iOSNsPredicate = "label == \"Add\" AND name == \"addButtonProduct\"")
	private WebElement add;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Basket']")
	private WebElement basket;

	public WebElement getProduct() {
		return product;
	}
	
	public WebElement getAdd() {
		return add;
	}
	public WebElement getBasket() {
		return basket;
	}
	
	public Itempage(IOSDriver driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void item() {
		
		driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Milkybar Moosha Caramel & Nougat Bar\"]")).click();
		
	}
	
	public void add() {
		add.click();
		basket.click();
	}

}
