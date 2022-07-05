package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
//import java.time.Duration.ofSeconds;

public class FirstAndroidTest1 {
    private static String ANDROID_PHOTO_PATH = "/mnt/sdcard/Pictures";
    private static By backupSwitch = By.id("com.google.android.apps.photos:id/auto_backup_switch");
    private static By touchOutside = By.id("com.google.android.apps.photos:id/touch_outside");
    private static By keepOff = By.xpath("//*[@text='KEEP OFF']");
    private static By photo = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");
    private static By trash = By.id("com.google.android.apps.photos:id/trash");
    private static By moveToTrash = By.xpath("//*[@text='MOVE TO TRASH']");

    private static By imgtobeClicked = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");

    private static By info1 = By.xpath("//android.widget.ImageView[contains (@content-desc='Info')]");
    private static By info = By.id("com.google.android.apps.photos:id/details");

    private static By pathInfo = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]");

    //public AppiumDriver androidDriver  ;
    public AndroidDriver androidDriver  ;

    @Test
    public void setDriver() throws MalformedURLException {
        DesiredCapabilities dc= new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));

        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformVersion", "8.1");
        dc.setCapability("deviceName", "Android Emulator");
        dc.setCapability("appPackage", "com.google.android.apps.photos");
        dc.setCapability("appActivity", ".home.HomeActivity");

        androidDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"),dc);
        try {
            // there's some screens we need to navigate through and ensure there are no existing photos
            setupAppState((AndroidDriver) androidDriver);

            // set up the file we want to push to the phone's library  /Users/bs/IdeaProjects/sampleProj/assets/HeadSpin-Drive-Test-Vehicle.png
            File assetDir = new File(classpathRoot, "./assets");
            File img = new File(assetDir.getCanonicalPath(), "HeadSpin-Drive-Test-Vehicle.png");

            // actually push the file
            androidDriver.pushFile(ANDROID_PHOTO_PATH + "/" + img.getName(), img);

            // wait for the system to acknowledge the new photo, and use the WebDriverWait to verify
            // that the new photo is there
            // WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(7);
            WebDriverWait wait = new WebDriverWait(androidDriver, (10) );
            ExpectedCondition condition = ExpectedConditions.numberOfElementsToBe(photo,1);
            wait.until(condition);
            System.out.println("1 pic left ");

            WebDriverWait wait1 = new WebDriverWait(androidDriver, (10) );

            wait1.until(ExpectedConditions.presenceOfElementLocated(photo)).click();

            androidDriver.rotate(ScreenOrientation.LANDSCAPE);
            WebDriverWait wait2 = new WebDriverWait(androidDriver, (17) );
            wait2.until(ExpectedConditions.presenceOfElementLocated(info)).click();
            WebDriverWait wait3 = new WebDriverWait(androidDriver, (17) );
            // wait3.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText();
            System.out.println("pathInfo   ****   "+ wait3.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText());
            WebDriverWait wait5 = new WebDriverWait(androidDriver, (17) );
            Assert.assertEquals(wait5.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText(), "/storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png");
            // System.out.println("result.getText()    "+result.getText());
            // MobileElement el2 = (MobileElement) androidDriver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Photo taken']"));
            //.findElementByAccessibilityId("Photo taken on Jun 28, 2022 9:53:18 PM.");
            //   el2.click();



//            AndroidElement el3 = (AndroidElement) androidDriver.findElementByAccessibilityId("Photo taken on Jun 28, 2022 9:53:18 PM.");
//            el3.click();
            //,, WebElement result=  androidDriver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']")) ; //.findElementsByXPath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']");
            // WebElement result= (WebElement) androidDriver.findElementsByXPath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']");
            // WebElement result=  (WebElement) androidDriver.findElementsByXPath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']");

            //MobileElement result = (MobileElement) androidDriver.findElementByAccessibilityId("Info");
//            androidDriver.rotate(ScreenOrientation.LANDSCAPE);
//            result.click();
//            Assert.assertEquals(result.getText(), "/storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png");
//            System.out.println("result.getText()    "+result.getText());


            //             System.out.println("pic uploaded");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            androidDriver.quit();
        }
    }

//    @Test
//    public void sendPhoto(AppiumDriver driver) {
//
//        this.driver = driver;
//
//    }




    public void setupAppState(AndroidDriver androidDriver) {
        // navigate through the google junk to get to the app
        //WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10)  );
        //  WebDriverWait shortWait = new WebDriverWait(androidDriver, Duration.ofSeconds(10) );
        WebDriverWait wait = new WebDriverWait(androidDriver, (10)  );
        WebDriverWait shortWait = new WebDriverWait(androidDriver, (10) );
        wait.until(ExpectedConditions.presenceOfElementLocated(backupSwitch)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(touchOutside)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(keepOff)).click();

        // delete any existing pictures using an infinite loop broken when we can't find any
        // more pictures
        try {
            while (true) {
                shortWait.until(ExpectedConditions.presenceOfElementLocated(photo)).click();
                shortWait.until(ExpectedConditions.presenceOfElementLocated(trash)).click();
                shortWait.until(ExpectedConditions.presenceOfElementLocated(moveToTrash)).click();
            }
        } catch (TimeoutException ignore) {}
    }
//   //android.view.ViewGroup[@content-desc="Photo taken on Jun 28, 2022 9:53:18 PM."]
//    MobileElement el1 = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Photos\"])[2]");
//el1.click();
//    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Photo taken on Jun 28, 2022 9:53:18 PM.");
//el2.click();
//    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("Info");
//el3.click();
//    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("Navigate up");
//el4.click();
//  /storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png
}
