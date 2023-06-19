package com.lambdatest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import okhttp3.*;
import org.json.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Setup {
    public AndroidDriver<AndroidElement> driver;
    protected String mediaUrl;
    @BeforeMethod
    public void beforeMethod() throws IOException {

        mediaUrl = uploadImageAndGetUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("build", "debug");
        //capabilities.setCapability("name", "Android_Camera_injection_test");
        capabilities.setCapability("deviceName", "Pixel.*");
        //capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("autoAcceptAlert", true);
        capabilities.setCapability("autoGrantPermission", true);
        capabilities.setCapability("isRealMobile", true);
        //AppURL (Create from Wikipedia.apk sample in project)
        capabilities.setCapability("app", "camera-inject"); //Enter your app url
        capabilities.setCapability("deviceOrientation", "PORTRAIT");
        capabilities.setCapability("console", true);
        capabilities.setCapability("network", true);
        capabilities.setCapability("visual", true);
        capabilities.setCapability("devicelog", true);
        capabilities.setCapability("enableImageInjection",true);
       // capabilities.setCapability("media","lt://MEDIA9186b4f4d60f459eb93555e0f9330bc3"); // eg: lt://MEDIAd508b730c7f84895aac014d584de0a07

        String username = System.getenv("LT_USERNAME");
        String accessKey = System.getenv("LT_ACCESS_KEY");

        driver = new AndroidDriver<AndroidElement>(new URL("https://"+username+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"), capabilities);
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private String uploadImageAndGetUrl() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("media_file","IMG_2020.jpg",
                        RequestBody.create(MediaType.parse("application/octet-stream"),
                                new File("/Users/mohammadk/Downloads/IMG_2024.PNG")))
                .addFormDataPart("type","image")
                .addFormDataPart("custom_id","my-photo")
                .build();

        Request request = new Request.Builder()
                .url("https://mobile-mgm.lambdatest.com/mfs/v1.0/media/upload")
                .method("POST", body)
                .addHeader("Authorization", "Basic bW9oYW1tYWRrOnJha2NCb0JZSGl5OEJXN29zVmk0TjFMR1lqZ0poUmZBd3ZMMXBQVXZ3Q0Exd2ZOQ2hk")
                .build();
        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JSONObject jo = new JSONObject(jsonString);
        return (String) jo.get("media_url");
    }
}
