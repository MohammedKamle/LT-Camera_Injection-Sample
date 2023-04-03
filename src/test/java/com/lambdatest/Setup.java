package com.lambdatest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import java.net.URL;

public class Setup {
    public AndroidDriver<AndroidElement> driver;
    @BeforeMethod
    public void beforeMethod() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "Camera injection feature build");
        capabilities.setCapability("name", "Android_Camera_injection_test");
        capabilities.setCapability("deviceName", "Pixel.*");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("isRealMobile", true);
        //AppURL (Create from Wikipedia.apk sample in project)
        capabilities.setCapability("app", "YOUR_APP_URL"); //Enter your app url
        capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("console", true);
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("enableImageInjection",true);
        capabilities.setCapability("media","YOUR_MEDIA_URL"); // eg: lt://MEDIAd508b730c7f84895aac014d584de0a07

        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");

        driver = new AndroidDriver<AndroidElement>(new URL("https://"+username+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }
}
