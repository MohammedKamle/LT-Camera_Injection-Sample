package com.lambdatest;

import io.appium.java_client.android.AndroidElement;

public class Test extends Setup{
    @org.testng.annotations.Test
    public void cameraInjectionTest() throws InterruptedException {
        AndroidElement el1 = (AndroidElement) driver.findElementById("com.android.permissioncontroller:id/permission_allow_button");
        el1.click();
        Thread.sleep(2000);
        AndroidElement el2 = (AndroidElement) driver.findElementById("com.bsstag.cameraimage:id/button");
        el2.click();
        Thread.sleep(2000);
        AndroidElement el4 = (AndroidElement) driver.findElementByAccessibilityId("Take photo");
        el4.click();
        Thread.sleep(2000);
        AndroidElement el5 = (AndroidElement) driver.findElementById("com.google.android.GoogleCamera:id/shutter_button");
        el5.click();
        Thread.sleep(2000);
    }
}
