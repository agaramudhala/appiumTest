package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FirstAndroidTest {
    private static final String ANDROID_PHOTO_PATH = "/mnt/sdcard/Pictures";
    private static final By backupSwitch = By.id("com.google.android.apps.photos:id/auto_backup_switch");
    private static final By touchOutside = By.id("com.google.android.apps.photos:id/touch_outside");
    private static final By keepOff = By.xpath("//*[@text='KEEP OFF']");
    private static final By photo = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");
    private static final By trash = By.id("com.google.android.apps.photos:id/trash");
    private static final By moveToTrash = By.xpath("//*[@text='MOVE TO TRASH']");

    private static final By imgtobeClicked = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");

    private static final By info1 = By.xpath("//android.widget.ImageView[contains (@content-desc='Info')]");
    private static final By info = By.id("com.google.android.apps.photos:id/details");
    private static final By pathInfo = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]");

    public AndroidDriver androidDriver;

//    @Test
    public void setDriver() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformVersion", "8.1");
        dc.setCapability("deviceName", "Android Emulator");
        dc.setCapability("appPackage", "com.google.android.apps.photos");
        dc.setCapability("appActivity", ".home.HomeActivity");

        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        try {
            setupAppState(androidDriver);
            File assetDir = new File(classpathRoot, "./assets");
            File img = new File(assetDir.getCanonicalPath(), "HeadSpin-Drive-Test-Vehicle.png");
            androidDriver.pushFile(ANDROID_PHOTO_PATH + "/" + img.getName(), img);
            WebDriverWait wait = new WebDriverWait(androidDriver, (10));
            ExpectedCondition condition = ExpectedConditions.numberOfElementsToBe(photo, 1);
            wait.until(condition);
            WebDriverWait wait1 = new WebDriverWait(androidDriver, (10));
            wait1.until(ExpectedConditions.presenceOfElementLocated(photo)).click();
            androidDriver.rotate(ScreenOrientation.LANDSCAPE);
            WebDriverWait wait2 = new WebDriverWait(androidDriver, (17));
            wait2.until(ExpectedConditions.presenceOfElementLocated(info)).click();
            WebDriverWait wait3 = new WebDriverWait(androidDriver, (17));
            System.out.println("pathInfo   ****   " + wait3.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText());
            WebDriverWait wait5 = new WebDriverWait(androidDriver, (17));
            Assert.assertEquals(wait5.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText(), "/storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            androidDriver.quit();
        }
    }
    public void setupAppState(AndroidDriver androidDriver) {
        WebDriverWait wait = new WebDriverWait(androidDriver, (10));
        WebDriverWait shortWait = new WebDriverWait(androidDriver, (10));
        wait.until(ExpectedConditions.presenceOfElementLocated(backupSwitch)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(touchOutside)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(keepOff)).click();
        try {
            while (true) {
                shortWait.until(ExpectedConditions.presenceOfElementLocated(photo)).click();
                shortWait.until(ExpectedConditions.presenceOfElementLocated(trash)).click();
                shortWait.until(ExpectedConditions.presenceOfElementLocated(moveToTrash)).click();
            }
        } catch (TimeoutException ignore) {
        }
    }
    private static final String ANDROID_PHOTO_PATH1 = "/mnt/sdcard/Pictures";

    private static final By gotit = By.id("com.google.android.gm:id/welcome_tour_got_it");
    private static final By takeMeToGmail = By.id("com.google.android.gm:id/action_done");
    private static final By dismiss_button = By.id("com.google.android.gm:id/dismiss_button");
    private static final By dealLater = By.id("com.google.android.gm:id/subject_and_folder_view");
    private static final By SmartComoseGotit = By.id("android:id/button1");






    private static final By toAddress = By.id("com.google.android.gm:id/to");
    private static final By toAddress1  = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.EditText");
    private static final By avatar = By.id("com.google.android.gm:id/peoplekit_avatars_avatar");
    private static final By subject = By.id("com.google.android.gm:id/subject");
    private static final By composeBody = By.id("com.google.android.gm:id/wc_body");
    private static final By composeBodyArea = By.id("com.google.android.gm:id/composearea_tap_trap_bottom");





    private static final By composeMail = By.id("com.google.android.gm:id/compose_button");
    private static final By attachfile = By.id("com.google.android.gm:id/add_attachment");
    private static final By attachfromfile = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
    private static final By imgfile = By.id("com.android.documentsui:id/icon_thumb");
    private static final By imgfileOpen = By.id("com.android.documentsui:id/option_menu_grid");
    private static final By sendEmail = By.id("com.google.android.gm:id/send");


    //   private static final By gotit = By.id("com.google.android.gm:id/welcome_tour_got_it");
    //   private static final By takeMeToGmail = By.id("com.google.android.gm:id/action_done");
    private static final By backagree = By.id("com.google.android.gms:id/next_button");
    private static final By agree = By.xpath("//android.widget.Button[@content-desc='I agree']");

    private static final By Next = By.xpath("//android.widget.Button[@content-desc='Next']");
    private static final By selectgmail = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");

    private static final By selectgmail1 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
    private static final By gmailsignName = By.xpath("//android.webkit.WebView[@content-desc='Sign in with your Google Account. Learn more']/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText");
    private static final By gmailsignPass = By.xpath("//android.webkit.WebView[@content-desc='Welcome']/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    private static final By gmailsignPass1 = By.xpath("//android.webkit.WebView[@content-desc='Hi test']/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText");




    private static final By Gmail = By.xpath("(//android.widget.TextView[@content-desc=\\\"Gmail\\\"])[2]");
    private static final By drawer = By.id("Open navigation drawer");
    private static final By account_address = By.xpath("com.google.android.gm:id/account_address");
    private static final By recycler_list_view = By.xpath("com.google.android.gm:id/recycler_list_view");
    private static final By ImageView = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView");
    private static final By TextView = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");
    private static final By button = By.id("com.android.settings:id/button");  private static final By button1 = By.id("android:id/button1");






    //   @Test
    public void sendMail() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformVersion", "8.1");
        dc.setCapability("deviceName", "Android Emulator");
      //  dc.setCapability("appPackage", "com.google.android.gm");
      //  dc.setCapability("appActivity", "com.google.android.gm.setup.AccountSetupFinalGmail");
          dc.setCapability("appPackage", "com.google.android.gm");
         dc.setCapability("appActivity", "com.google.android.gm.GmailActivity");



        //      com.google.android.gm.ComposeActivityGmail  com.google.android.gm.setup.AccountSetupFinalGmail - Account setup
        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        try {
            //         setupAppState(androidDriver);
              File assetDir = new File(classpathRoot, "./assets");
               File img = new File(assetDir.getCanonicalPath(), "HeadSpin-Drive-Test-Vehicle.png");
                androidDriver.pushFile(ANDROID_PHOTO_PATH + "/" + img.getName(), img);

            //  com.android.email.activity.setup.AccountCredentials - Sign in  ,com.google.android.gm.ComposeActivityGmail - Gmail,, com.google.android.gm.ComposeActivityGmailExternal - Gmail
            // com.google.android.gm.GmailActivity - Gmail com.google.android.gm.photo.GmailPhotoViewActivity - Gmail com.google.android.gm.browse.FullMessageActivity - Gmail
            //     WebDriverWait swait = new WebDriverWait(androidDriver, (10));
            //     swait.until(ExpectedConditions.presenceOfElementLocated(Gmail)).click();
            // com.google.android.gm.welcome.WelcomeTourActivity - Gmail com.google.android.gm.welcome.SetupAddressesActivity - Gmail
            //  com.google.android.gm.job.SaveAttachmentsJob$SaveAttachmentsJobService - Gmail com.google.android.gm.job.SendSetNewEmailIndicatorJob$SendSetNewEmailIndicatorJobService - Gmail




            WebDriverWait swait = new WebDriverWait(androidDriver, (10));
            swait.until(ExpectedConditions.presenceOfElementLocated(gotit)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(takeMeToGmail)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(dismiss_button)).click();
            //   swait.until(ExpectedConditions.presenceOfElementLocated(dealLater)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(composeMail)).click();




            swait.until(ExpectedConditions.presenceOfElementLocated(SmartComoseGotit)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(toAddress1)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(toAddress1)).sendKeys("@gmail.com");
            swait.until(ExpectedConditions.presenceOfElementLocated(avatar)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(subject)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(subject)).sendKeys("attach");
            swait.until(ExpectedConditions.presenceOfElementLocated(composeBodyArea)).click();


            swait.until(ExpectedConditions.presenceOfElementLocated(attachfile)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(attachfromfile)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(imgfile)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(imgfileOpen)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(sendEmail)).click();










            //    ExpectedCondition condition = ExpectedConditions.numberOfElementsToBe(photo, 1);
            //     wait.until(condition);
                 WebDriverWait wait = new WebDriverWait(androidDriver, (10));
                 wait.until(ExpectedConditions.presenceOfElementLocated(selectgmail)).click();

                 WebDriverWait wait1 = new WebDriverWait(androidDriver, (15));
                 wait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignName)).click();
                 wait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignName)).sendKeys("@gmail.com");
                 wait1.until(ExpectedConditions.presenceOfElementLocated(Next)).click();
                 WebDriverWait wait2 = new WebDriverWait(androidDriver, (12));

                 wait2.until(ExpectedConditions.presenceOfElementLocated(gmailsignPass1)).click();
                 wait2.until(ExpectedConditions.presenceOfElementLocated(gmailsignPass1)).sendKeys("");
                 wait2.until(ExpectedConditions.presenceOfElementLocated(Next)).click();
                 WebDriverWait wait3 = new WebDriverWait(androidDriver, (13));

                 wait3.until(ExpectedConditions.presenceOfElementLocated(agree)).click();
                 wait3.until(ExpectedConditions.presenceOfElementLocated(backagree)).click();






            // This account already exists on your device
//android.view.View[@content-desc="This account already exists on your device"]


 /*           MobileElement el1 = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Gmail\"])[2]");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.gm:id/account_address");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.gm:id/recycler_list_view");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView");
            el5.click();
            MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");
            el6.click();
            MobileElement el7 = (MobileElement) driver.findElementById("com.android.settings:id/button");
            el7.click();
            MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
            el8.click();*/



           //     androidDriver.rotate(ScreenOrientation.LANDSCAPE);
            //      WebDriverWait wait2 = new WebDriverWait(androidDriver, (17));
            //     wait2.until(ExpectedConditions.presenceOfElementLocated(info)).click();
            //     WebDriverWait wait3 = new WebDriverWait(androidDriver, (17));
            //      System.out.println("pathInfo   ****   " + wait3.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText());
            //     WebDriverWait wait5 = new WebDriverWait(androidDriver, (17));
            //    Assert.assertEquals(wait5.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText(), "/storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
                 androidDriver.quit();
        }
    }
    @Test
    public void LoginGmail() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformVersion", "8.1");
        dc.setCapability("deviceName", "Android Emulator");
        dc.setCapability("appPackage", "com.google.android.gm");
        dc.setCapability("appActivity", "com.google.android.gm.setup.AccountSetupFinalGmail");
        // dc.setCapability("appPackage", "com.google.android.gm");
        //dc.setCapability("appActivity", "com.google.android.gm.GmailActivity");



        //      com.google.android.gm.ComposeActivityGmail  com.google.android.gm.setup.AccountSetupFinalGmail - Account setup
        androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        try {


            //  com.android.email.activity.setup.AccountCredentials - Sign in  ,com.google.android.gm.ComposeActivityGmail - Gmail,, com.google.android.gm.ComposeActivityGmailExternal - Gmail
            // com.google.android.gm.GmailActivity - Gmail com.google.android.gm.photo.GmailPhotoViewActivity - Gmail com.google.android.gm.browse.FullMessageActivity - Gmail
            //     WebDriverWait swait = new WebDriverWait(androidDriver, (10));
            //     swait.until(ExpectedConditions.presenceOfElementLocated(Gmail)).click();
            // com.google.android.gm.welcome.WelcomeTourActivity - Gmail com.google.android.gm.welcome.SetupAddressesActivity - Gmail
            //  com.google.android.gm.job.SaveAttachmentsJob$SaveAttachmentsJobService - Gmail com.google.android.gm.job.SendSetNewEmailIndicatorJob$SendSetNewEmailIndicatorJobService - Gmail












              WebDriverWait swait = new WebDriverWait(androidDriver, (10));
            //     swait.until(ExpectedConditions.presenceOfElementLocated(gotit)).click();

            //   swait.until(ExpectedConditions.presenceOfElementLocated(takeMeToGmail)).click();
            //  swait.until(ExpectedConditions.presenceOfElementLocated(dismiss_button)).click();




            WebDriverWait wait = new WebDriverWait(androidDriver, (10));
            wait.until(ExpectedConditions.presenceOfElementLocated(selectgmail1)).click();
            WebDriverWait wait1 = new WebDriverWait(androidDriver, (15));




            wait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignName)).click();
            wait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignName)).sendKeys("@gmail.com");
            wait1.until(ExpectedConditions.presenceOfElementLocated(Next)).click();
            WebDriverWait wait2 = new WebDriverWait(androidDriver, (12));

            wait2.until(ExpectedConditions.presenceOfElementLocated(gmailsignPass1)).click();
            wait2.until(ExpectedConditions.presenceOfElementLocated(gmailsignPass1)).sendKeys("");
            wait2.until(ExpectedConditions.presenceOfElementLocated(Next)).click();
            WebDriverWait wait3 = new WebDriverWait(androidDriver, (13));

            wait3.until(ExpectedConditions.presenceOfElementLocated(agree)).click();
            wait3.until(ExpectedConditions.presenceOfElementLocated(backagree)).click();






            // This account already exists on your device
//android.view.View[@content-desc="This account already exists on your device"]


 /*           MobileElement el1 = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Gmail\"])[2]");
            el1.click();
            MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Open navigation drawer");
            el2.click();
            MobileElement el3 = (MobileElement) driver.findElementById("com.google.android.gm:id/account_address");
            el3.click();
            MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.gm:id/recycler_list_view");
            el4.click();
            MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView");
            el5.click();
            MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.TextView[1]");
            el6.click();
            MobileElement el7 = (MobileElement) driver.findElementById("com.android.settings:id/button");
            el7.click();
            MobileElement el8 = (MobileElement) driver.findElementById("android:id/button1");
            el8.click();*/



            //     androidDriver.rotate(ScreenOrientation.LANDSCAPE);
            //      WebDriverWait wait2 = new WebDriverWait(androidDriver, (17));
            //     wait2.until(ExpectedConditions.presenceOfElementLocated(info)).click();
            //     WebDriverWait wait3 = new WebDriverWait(androidDriver, (17));
            //      System.out.println("pathInfo   ****   " + wait3.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText());
            //     WebDriverWait wait5 = new WebDriverWait(androidDriver, (17));
            //    Assert.assertEquals(wait5.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText(), "/storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            androidDriver.quit();
        }
    }

//    MobileElement el1 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Apps list");
//el1.click();
//    MobileElement el2 = (MobileElement) AndroidDriver.findElementByXPath("(//android.widget.TextView[@content-desc=\"Gmail\"])[2]");
//el2.click();
//    MobileElement el3 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/welcome_tour_skip");
//el3.click();
//    MobileElement el4 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/setup_addresses_add_another");
//el4.click();
//    MobileElement el5 = (MobileElement) AndroidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");
//el5.click();
//    MobileElement el7 = (MobileElement) AndroidDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"Sign in with your Google Account. Learn more\"]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText");
//el7.click();
//    MobileElement el8 = (MobileElement) AndroidDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"Sign in with your Google Account. Learn more\"]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText");
//el8.sendKeys("@gmail.com");
//    MobileElement el9 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Next");
//el9.click();
//    MobileElement el10 = (MobileElement) AndroidDriver.findElementByXPath("//android.view.View[@content-desc=\"Show password\"]");
//el10.click();                                                              //android.webkit.WebView[@content-desc="Welcome"]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText
//    MobileElement el11 = (MobileElement) AndroidDriver.findElementByXPath("//android.webkit.WebView[@content-desc=\"Hi test\"]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
//el11.click();
//el11.sendKeys("");
//    MobileElement el12 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Next");
//el12.click();
//    MobileElement el13 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Don’t turn on");
//el13.click();
//    MobileElement el14 = (MobileElement) AndroidDriver.findElementByAccessibilityId("I agree");
//el14.click();
//    MobileElement el15 = (MobileElement) AndroidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button");
//el15.click();
//    MobileElement el16 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/action_done");
//el16.click();
//    MobileElement el17 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/recycler_list_view");
//el17.click();
//    MobileElement el18 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/recycler_list_view");
//el18.click();
//el18.click();
//    MobileElement el19 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/recycler_list_view");
//el19.click();
//    MobileElement el20 = (MobileElement) AndroidDriver.findElementById("android:id/button2");
//el20.click();
//    MobileElement el21 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/to");
//el21.sendKeys("wew@dsds.com");
//    MobileElement el22 = (MobileElement) AndroidDriver.findElementById("com.google.android.gm:id/subject");
//el22.click();
//el22.sendKeys("img");
//    MobileElement el23 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Compose email");
//el23.click();
//el23.click();
//    MobileElement el24 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Compose email");
//el24.click();
//    MobileElement el25 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Attach file");
//el25.click();
//    MobileElement el26 = (MobileElement) AndroidDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView");
//el26.click();
//    MobileElement el27 = (MobileElement) AndroidDriver.findElementById("com.android.documentsui:id/icon_thumb");
//el27.click();
//    MobileElement el28 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Grid view");
//el28.click();
//    MobileElement el29 = (MobileElement) AndroidDriver.findElementByAccessibilityId("Send");
//el29.click();

}
