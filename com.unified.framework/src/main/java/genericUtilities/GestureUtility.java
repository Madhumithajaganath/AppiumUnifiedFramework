package genericUtilities;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class GestureUtility {
	
	AppiumDriver driver;
	public GestureUtility(AppiumDriver driver) {
		this.driver=driver;
	}
	
	public void clickByElements(WebElement element) {
		((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
			ImmutableMap.of("elementId",((RemoteWebElement)element).getId()));
	}
	
	public void clickByCordinates(int x, int y) {
		((JavascriptExecutor)driver).executeScript("mobile:clickGesture",
		    ImmutableMap.of("x",x,"y",y));
	}
	
	public void longClickByElement(WebElement element, int time) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", time));
	}
	
	public void longClickByCordinates(int x, int y, int time) {
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
				ImmutableMap.of("x", x, "y", y, "duration", time));
	}

	public void doubleClickByElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));
	}
	
	public void doubleClickByCordinates(int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: doubleClickGesture", ImmutableMap.of("x", x, "y", y));
	}
	
	public void dragAndDrop(WebElement element, int x, int y) {
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "endX", x, "endY", y));
	}

	public void zoomIn(WebElement element, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchOpenGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent));
	}

	public void zoomOut(WebElement element, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: pinchCloseGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "percent", percent));
	}

	public void swipeByCordinates(int left, int top, int width, int height, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("left", left, "top", top,
				"width", width, "height", height, "direction", direction, "percent", percent));
	}

	public void swipeByElement(WebElement element, String direction, double percent) {
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
		((RemoteWebElement) element).getId(), "direction", direction, "percent", percent));
	}

	public WebElement scrollByText(String text) {
		WebElement elementText = driver.findElement(AppiumBy.androidUIAutomator
		("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		return elementText;
	}

	public WebElement scrollById(String id) {
		WebElement elementId = (WebElement) driver.findElements(AppiumBy.androidUIAutomator(
		"new UiScrollable (new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceIdMatches(\""+id+"\"));"));
		return elementId;
	}
	
	
	
	public  JavascriptExecutor js=(JavascriptExecutor)driver;
	public Map<String, Object> param=new HashMap<String, Object>();


	public void tapGesture(int x,int y) {
		param.put("x", x);
		param.put("y",y);
		js.executeScript("mobile:tap", param);		
	}
	
	public void alert() {
		param.put("action", "accept");
		js.executeScript("mobile:alert", param);
	}
	
	public void touchAndHold(WebElement ele,double duration) {
		param.put("element" ,((RemoteWebElement)ele).getId());
		param.put("duration", duration);
		js.executeScript("mobile:touchAndHold", param);
		
	}
	
	public void doubleTap(int x,int y) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 Map<String, Object> param=new HashMap<String, Object>();
		
		param.put("x",x);
		param.put("y", y);
		js.executeScript("mobile:doubleTap", param);
	}
	
	public void dragAndDrop(int startx,int starty,int endx,int endy) {
		PointerInput pointer = new PointerInput(PointerInput.Kind.TOUCH,"finger");
       Sequence dragAndDrop = new Sequence(pointer, 1);
       
       dragAndDrop.addAction(pointer.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startx, starty));
       dragAndDrop.addAction(pointer.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
       
       dragAndDrop.addAction(new Pause(pointer, Duration.ofMillis(200)));
       
       dragAndDrop.addAction(pointer.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endx, endy));
       
       dragAndDrop.addAction(pointer.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
       
       driver.perform(Collections.singletonList(dragAndDrop));
	}
	
	public void swipe(String direction) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 Map<String, Object> param=new HashMap<String, Object>();
		param.put("direction", direction);
		js.executeScript("mobile:swipe",param);
	}

}
