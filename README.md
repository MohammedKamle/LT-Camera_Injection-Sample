Camera Injection on Lambdatest Example With TestNG
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
- Set the app url which your get in response after uploading the app in [capabilities](https://github.com/MohammedKamle/LT-Camera_Injection-Sample/blob/76550fda546f70ac9dfc13374c3cd9fa229f7374/src/test/java/com/lambdatest/Setup.java#L23)
## Upload the image to be injected: [refer this](https://www.lambdatest.com/support/docs/camera-image-injection/)
Set the media url of the image to be injected in [capabilities](https://github.com/MohammedKamle/LT-Camera_Injection-Sample/blob/76550fda546f70ac9dfc13374c3cd9fa229f7374/src/test/java/com/lambdatest/Setup.java#L30)

## Run the Test
run `mvn test`
