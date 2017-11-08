package app;

import java.io.File;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class app {
	private boolean isInstall = false;
	public DesiredCapabilities apps(String device,String deviceName,
			String platformName,String platformVersion,String appPackage,String appActivity,String app){
		//启动appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("device", device);
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("sessionOverride", true);
		
		//安装APP
		if (isInstall) {
			File classpath = new File(System.getProperty("user.dir"));
			File appDir = new File(classpath, "apps");
			File apps = new File(appDir,app);  
            capabilities.setCapability("app", apps.getAbsolutePath());  
		}
		
		return capabilities;
	}
}
