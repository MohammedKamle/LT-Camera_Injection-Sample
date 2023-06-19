[Camera Injection](https://www.lambdatest.com/support/docs/camera-image-injection/) on Lambdatest Example With TestNG 
----

## Prerequisites

- Ensure you have the following dependencies installed on the machine
    - Java >= 8
    - Maven >= 3.1+
- Identify your Lambdatest username and access key from the [Lambdatest Dashboard](https://appautomation.lambdatest.com/build) and export them as environment variables using the below commands.
  - For \*nix based and Mac machines:

  ```sh
  export LT_USERNAME=<lambdatest-username> &&
  export LT_ACCESS_KEY=<lambdatest-access-key>
  ```

    - For Windows:

  ```shell
  set LT_USERNAME=<lambdatest-username>
  set LT_ACCESS_KEY=<lambdatest-access-key>
  ```
 
 ## Upload your App: [refer this](https://www.lambdatest.com/support/docs/upload-your-mobile-app/)
- You can download and use the sample [CameraImage-debug.apk](https://github.com/MohammedKamle/LT-Camera_Injection-Sample/blob/main/CameraImage-debug.apk) 
- Set the app url which you will get in response after uploading the app in [capabilities](https://github.com/MohammedKamle/LT-Camera_Injection-Sample/blob/76550fda546f70ac9dfc13374c3cd9fa229f7374/src/test/java/com/lambdatest/Setup.java#L23)
## Steps to inject the image
- Set enableImageInjection as true in [capabilities](https://github.com/MohammedKamle/LT-Camera_Injection-Sample/blob/14b67732176662b0fe15b6ff0cf2083f9ec1332a/src/test/java/com/lambdatest/Setup.java#L40)
- Set the path of the image to be injected [here](https://github.com/MohammedKamle/LT-Camera_Injection-Sample/blob/14b67732176662b0fe15b6ff0cf2083f9ec1332a/src/test/java/com/lambdatest/Setup.java#LL62C4-L62C4)
- Run the javaScript executor before clicking the shutter button as shown [here](https://github.com/MohammedKamle/LT-Camera_Injection-Sample/blob/14b67732176662b0fe15b6ff0cf2083f9ec1332a/src/test/java/com/lambdatest/Test.java#L26)

## Run the Test
run `mvn test`
