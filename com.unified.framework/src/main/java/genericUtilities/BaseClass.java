package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import GenericUtility.AndroidDriverUtility;
import GenericUtility.FileUtility;
import GenericUtility.iOSDriverUtility;
import GenericUtility.iOSGestureUtility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	public AppiumDriverLocalService service; 
	FileUtility fUtil = new FileUtility();
	public IOSDriver driverI;
	public AndroidDriver driverA;
	public AppiumDriver driver;
	
	public DriverUtility dutil = new DriverUtility(driver);
	@BeforeSuite
	public void startServer() {
		File nodePath = new File("/Users/madhumitha/.nvm/versions/node/v20.19.6/bin/node");
		File f = new File("/Users/madhumitha/.nvm/versions/node/v20.19.6/lib/node_modules/appium/index.js");
		service = new AppiumServiceBuilder().usingDriverExecutable(nodePath).withAppiumJS(f).withIPAddress("127.0.0.1").
				  usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
		
		System.out.println("server started");
	}
	
	@BeforeClass
	public void config() throws IOException {
	    DesiredCapabilities dc = new DesiredCapabilities();

	    String automationName = fUtil.dataFromPropertiesFile("automationName");

	    dc.setCapability("platformName", fUtil.dataFromPropertiesFile("platformName"));
	    dc.setCapability("automationName", automationName);
	    dc.setCapability("deviceName", fUtil.dataFromPropertiesFile("deviceName"));
	    dc.setCapability("udid", fUtil.dataFromPropertiesFile("udid"));
	    dc.setCapability("platformVersion", fUtil.dataFromPropertiesFile("platformVersion"));

	    URL u = new URL("http://localhost:4723");

	    if ("xcuitest".equalsIgnoreCase(automationName)) {
	        driverI = new IOSDriver(u, dc);
	    } 
	    else if ("uiautomator2".equalsIgnoreCase(automationName)) {
	        driverA = new AndroidDriver(u, dc);
	    } 
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	    System.out.println("connection established");
	}
	
	@BeforeMethod
	public void launchApp() throws IOException {

	    String platform = fUtil.dataFromPropertiesFile("platformName");

	    if ("ios".equalsIgnoreCase(platform)) {

	        dutil.activateApp(fUtil.dataFromPropertiesFile("bundleId"));

	    } 
	    else if ("android".equalsIgnoreCase(platform)) {
	     dutil.activateApp(fUtil.dataFromPropertiesFile("appPackage"));
	    } 

	    System.out.println("app launched");
	}
	
	@AfterMethod
	public void closeApp() throws IOException {
		
		String platform = fUtil.dataFromPropertiesFile("platformName");
        dutil.activateApp(fUtil.dataFromPropertiesFile("bundleId"));

        if ("ios".equalsIgnoreCase(platform)) {
	        dutil.closeApp(fUtil.dataFromPropertiesFile("bundleId"));  
        }

	else if ("android".equalsIgnoreCase(platform)) {

     dutil.closeApp(fUtil.dataFromPropertiesFile("appPackage"));

    } 
		System.out.println("app closed");
	}
	
	@AfterSuite
	public void stopServer() {
		service.stop();
		System.out.println("server stopped");
	}

}
