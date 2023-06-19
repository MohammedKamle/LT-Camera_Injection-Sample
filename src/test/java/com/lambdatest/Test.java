package com.lambdatest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import okhttp3.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class Test extends Setup{
    @org.testng.annotations.Test
    public void cameraInjectionTest() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        MobileElement element1 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_button")));
        element1.click();

        MobileElement element2 = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.bsstag.cameraimage:id/button")));
        element2.click();


        driver.executeScript("lambda-image-injection="+mediaUrl);



        MobileElement element4 = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.GoogleCamera:id/shutter_button")));
        element4.click();

        MobileElement element5 = (AndroidElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.google.android.GoogleCamera:id/shutter_button")));
        element5.click();
    }



}
