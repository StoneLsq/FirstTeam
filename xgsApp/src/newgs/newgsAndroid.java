package newgs;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import tool.mouse;
import app.app;

public class newgsAndroid {
	private static AndroidDriver<WebElement> driver = null;
	mouse mouse = new mouse();
	TouchAction touch = new TouchAction(driver);
	public void androidApp() throws MalformedURLException{
		String device = "Android";
		String deviceName = "13765d19";
		String platformName = "Android";
		String platformVersion = "23";
		String appPackage = "com.xiaomi.shop";
//		String appActivity = "com.naodong.xgs.presentation.ui.LaunchActivity";
		String appActivity = "com.xiaomi.shop.activity.MainTabActivity";
		String app = "xiaomishangcheng.apk";
		DesiredCapabilities appCapabilities = new app().apps(device,deviceName,
				platformName,platformVersion,appPackage,appActivity,app);
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),appCapabilities);
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS); 
	}
	
	@Before
	public void before() throws Exception{
		androidApp();
	}
	@org.junit.Test
	public void Test() throws Exception{
		milogin();
	}
	@After
	public void after(){
		driver.close();
	}
	
	public void login() throws Exception{
		Thread.sleep(1000);
		driver.findElement(By.id("com.naodong.xgs.test:id/tab_friend_view")).click();
		Thread.sleep(200);
		driver.findElement(By.id("com.naodong.xgs.test:id/xgsLogoIV")).click();
		Thread.sleep(1000);
		driver.findElementById("com.naodong.xgs.test:id/edit_account").sendKeys("13457718147");
		driver.findElementById("com.naodong.xgs.test:id/edit_password").sendKeys("123456");
		driver.findElementById("com.naodong.xgs.test:id/button_submit").click();
	}
	
	
	public void milogin() throws Exception{
		System.out.println("success");
		Thread.sleep(3000);
		driver.findElement(By.id("com.xiaomi.shop.plugin.homepage:id/main_bottom_mine")).click();
		Thread.sleep(2000);
		driver.findElements(By.id("com.xiaomi.shop.plugin.homepage:id/listitem_user_item_rootview")).get(4).click();
		driver.findElement(By.id("com.xiaomi.shop2.plugin.setting:id/common_button_middletext")).click();
		driver.findElement(By.id("com.xiaomi.shop2.plugin.setting:id/common_button_middletext")).click();
		driver.findElement(By.id("com.xiaomi.shop.plugin.homepage:id/main_bottom_mine")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("com.xiaomi.shop.plugin.homepage:id/usercentral_listheader_username")).click();
		driver.findElement(By.id("com.xiaomi.shop.plugin.homepage:id/txv_system_login_change_account")).click();
		driver.findElement(By.id("com.xiaomi.shop:id/et_account_name")).sendKeys("13457718147");
		driver.findElement(By.id("com.xiaomi.shop:id/et_account_password")).sendKeys("lushiqin1012");
		driver.findElement(By.id("com.xiaomi.shop:id/btn_login")).click();
		Thread.sleep(3000);
	}
}
