package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.time.Duration.ofSeconds;

public class FirstIOSTest {
    private static String ANDROID_PHOTO_PATH = "/mnt/sdcard/Pictures";
    private static By backupSwitch = By.id("com.google.android.apps.photos:id/auto_backup_switch");
    private static By touchOutside = By.id("com.google.android.apps.photos:id/touch_outside");
    private static By keepOff = By.xpath("//*[@text='KEEP OFF']");
    private static By photo = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");
    private static By trash = By.id("com.google.android.apps.photos:id/trash");
    private static By moveToTrash = By.xpath("//*[@text='MOVE TO TRASH']");



    @Test
    public void setDriver() throws MalformedURLException {
        DesiredCapabilities dc= new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));

        dc.setCapability("platformName", "iOS");
        dc.setCapability("automationName", "XCUITEST");
        dc.setCapability("platformVersion", "15.5");
        dc.setCapability("deviceName", "iPhone SE");

        dc.setCapability("appPackage", "com.google.android.apps.photos");
        dc.setCapability("appActivity", ".home.HomeActivity");

        // AppiumDriver  androidDriver=new AndroidDriver(new URL("http://localhost:4723/wd/hub"),dc);
        IOSDriver       iosDriver=new IOSDriver(new URL("http://localhost:4723/wd/hub"),dc);
       // AppiumDriver Driver;
        // =new AndroidDriver(new URL("http://localhost:4723/wd/hub"),dc);
        try {
            // there's some screens we need to navigate through and ensure there are no existing photos
            setupAppState(iosDriver);

            // set up the file we want to push to the phone's library  /Users/bs/IdeaProjects/sampleProj/assets/HeadSpin-Drive-Test-Vehicle.png
            File assetDir = new File(classpathRoot, "./assets");
            File img = new File(assetDir.getCanonicalPath(), "HeadSpin-Drive-Test-Vehicle.png");

            // actually push the file
            iosDriver.pushFile(ANDROID_PHOTO_PATH + "/" + img.getName(), img);

            // wait for the system to acknowledge the new photo, and use the WebDriverWait to verify
            // that the new photo is there
           // WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(7);
            WebDriverWait wait = new WebDriverWait(iosDriver, (10) );
            ExpectedCondition condition = ExpectedConditions.numberOfElementsToBe(photo,1);
            wait.until(condition);
            
            // WebElement result=  androidDriver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']")) ; //.findElementsByXPath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']");
            // WebElement result= (WebElement) androidDriver.findElementsByXPath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']");
           // WebElement result=  (WebElement) androidDriver.findElementsByXPath("//android.view.ViewGroup[@content-desc='Photo taken on Jun 28, 2022 9:53:18 PM.']");

            //MobileElement result = (MobileElement) androidDriver.findElementByAccessibilityId("Info");
//            androidDriver.rotate(ScreenOrientation.LANDSCAPE);
//            result.click();
//            Assert.assertEquals(result.getText(), "/storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png");
//            System.out.println("result.getText()    "+result.getText());


            System.out.println("pic uploaded");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            iosDriver.quit();
        }
    }

//    @Test
//    public void sendPhoto(AppiumDriver driver) {
//
//        this.driver = driver;
//
//    }




    public void setupAppState(IOSDriver iosDriver) {
        // navigate through the google junk to get to the app
        //WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(10)  );
      //  WebDriverWait shortWait = new WebDriverWait(androidDriver, Duration.ofSeconds(10) );
        WebDriverWait wait = new WebDriverWait(iosDriver, (10)  );
        WebDriverWait shortWait = new WebDriverWait(iosDriver, (10) );
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
