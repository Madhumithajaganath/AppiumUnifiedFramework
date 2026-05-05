package genericUtilities;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.ScreenOrientation;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HasDeviceTime;
import io.appium.java_client.HasOnScreenKeyboard;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.InteractsWithApps;
import io.appium.java_client.LocksDevice;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.appium.java_client.remote.SupportsRotation;

public class DriverUtility {

	AppiumDriver driver;
	public DriverUtility(AppiumDriver driver) {
		this.driver=driver;
	}
		public void installApp(String path){
			((InteractsWithApps) driver).installApp(path);
		}

		public void activateApp(String Package) {
			((InteractsWithApps) driver).activateApp(Package);
		}
	  
		public void closeApp(String Package) {
			((InteractsWithApps) driver).terminateApp(Package);
		}

		public void isAppInstalled(String Package) {
			System.out.println(((InteractsWithApps) driver).isAppInstalled(Package));
		}
	  
		public void isDeviceLocked() {
			System.out.println(((LocksDevice) driver).isDeviceLocked());
		}
	  
		public void isKeyboardShown() {
			System.out.println(((HasOnScreenKeyboard) driver).isKeyboardShown());
		}

		public void changeOrientationToPotriat() {
			ScreenOrientation screen = ((SupportsRotation) driver).getOrientation();
			((SupportsRotation) driver).rotate(screen.PORTRAIT);
		}
		
		public void changeOrientationLandscape() {
			ScreenOrientation screen = ((SupportsRotation) driver).getOrientation();
			((SupportsRotation) driver).rotate(screen.LANDSCAPE);
		}

		public void lockDevice(int sec) {
		  ((LocksDevice) driver).lockDevice(Duration.ofSeconds(sec));
		}
	  
		public void unlockDevice() {
		  ((LocksDevice) driver).unlockDevice();
		}
	  
		public void runAppInBackground(int sec) {
		  ((InteractsWithApps) driver).runAppInBackground(Duration.ofSeconds(sec));

		}
		
		public void deviceTime() {
		  System.out.println(((HasDeviceTime) driver).getDeviceTime());
		}
		
		public void deviceTime(String format) {
			  System.out.println(((HasDeviceTime) driver).getDeviceTime(format));
			}
		
		public void openNotifications() {
	        ((AndroidDriver) driver).openNotifications();
		}
		
		public void hideKeyboard() {
	        ((HidesKeyboard) driver).hideKeyboard();
		}
		
		public void deleteApp(String Package) {
		   ((InteractsWithApps) driver).removeApp(Package);
		}
		
		public void get(String url) {
			driver.get(url);
		}
		
		public void switchContext() {
			Set<String> ch = ((SupportsContextSwitching) driver).getContextHandles();
			 int count=ch.size();
			 System.out.println(count);
			 for (String c : ch) {
				System.out.println(ch);
				
				if(ch.contains("WEBVIEW_")) {
					((SupportsContextSwitching) driver).context(c);
				}
		 }
	}
}
