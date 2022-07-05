package org.example;

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

public class androidTest {
    private static final String ANDROID_PHOTO_PATH = "/mnt/sdcard/Pictures";
    private static final By backupSwitch = By.id("com.google.android.apps.photos:id/auto_backup_switch");
    private static final By touchOutside = By.id("com.google.android.apps.photos:id/touch_outside");
    private static final By keepOff = By.xpath("//*[@text='KEEP OFF']");
    private static final By photo = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");

    private static final By photoToBeClicked = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");
    private static final By trash = By.id("com.google.android.apps.photos:id/trash");
    private static final By moveToTrash = By.xpath("//*[@text='MOVE TO TRASH']");

    private static final By imgtobeClicked = By.xpath("//android.view.ViewGroup[contains(@content-desc, 'Photo taken')]");

    private static final By info1 = By.xpath("//android.widget.ImageView[contains (@content-desc='Info')]");
    private static final By info = By.id("com.google.android.apps.photos:id/details");
    private static final By pathInfo = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]");
    private static final String ANDROID_PHOTO_PATH1 = "/mnt/sdcard/Pictures";

    private static final By gotit = By.id("com.google.android.gm:id/welcome_tour_got_it");
    private static final By takeMeToGmail = By.id("com.google.android.gm:id/action_done");
    private static final By dismiss_button = By.id("com.google.android.gm:id/dismiss_button");
    private static final By dealLater = By.id("com.google.android.gm:id/subject_and_folder_view");
    private static final By SmartComoseGotit = By.id("android:id/button1");

    private static final By toAddress = By.id("com.google.android.gm:id/to");
    private static final By toAddress1 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.EditText");
    private static final By avatar = By.id("com.google.android.gm:id/peoplekit_avatars_avatar");
    private static final By subject = By.id("com.google.android.gm:id/subject");
    private static final By composeBody = By.id("com.google.android.gm:id/wc_body");
    private static final By composeBodyArea = By.id("com.google.android.gm:id/composearea_tap_trap_bottom");

    private static final By composeMail = By.id("com.google.android.gm:id/compose_button");
    private static final By attachfile = By.id("com.google.android.gm:id/add_attachment");
    private static final By attachfromfile = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView");
    private static final By imgfile = By.id("com.android.documentsui:id/icon_thumb");
    private static final By imgfileOpen = By.id("com.android.documentsui:id/option_menu_grid");
    private static final By sendEmail = By.id("com.google.android.gm:id/send");     //   private static final By gotit = By.id("com.google.android.gm:id/welcome_tour_got_it");
    //   private static final By takeMeToGmail = By.id("com.google.android.gm:id/action_done");
    private static final By backagree = By.id("com.google.android.gm:id/action_done");
    private static final By agree = By.xpath("//android.widget.Button[@content-desc='I agree']");

    private static final By Next = By.xpath("//android.widget.Button[@content-desc='Next']");

    private static final By ExistingEmailAaddress = By.id("com.google.android.gm:id/og_apd_internal_image_view");
    private static final By ManageAccDevice = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.TextView");
    private static final By selectExistingEmail  = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.RelativeLayout");

    private static final By rmButton = By.id("com.android.settings:id/button");
    private static final By rmConfirmButton = By.id("android:id/button1");
    private static final By setup_addresses_add_anotherEmail = By.id("com.google.android.gm:id/setup_addresses_add_another");

    private static final By selectgmail = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    private static final By selectgmail2 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout");
    private static final By selectgmail1 = By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
    private static final By gmailsignName = By.xpath("//android.webkit.WebView[@content-desc=\"Sign in with your Google Account. Learn more\"]/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.widget.EditText");
    private static final By gmailsignPass = By.xpath("//android.webkit.WebView[@content-desc='Welcome']/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText");
    private static final By gmailsignPass1 = By.xpath("//android.webkit.WebView[@content-desc='Hi test']/android.view.View[2]/android.view.View[3]/android.view.View/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.widget.EditText");

    public AndroidDriver androidDriver;

        @Test
        public void googlePhotos() throws MalformedURLException {
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
                clearExistingPhotos(androidDriver);
                File assetDir = new File(classpathRoot, "./assets");
                File img = new File(assetDir.getCanonicalPath(), "HeadSpin-Drive-Test-Vehicle.png");
                androidDriver.pushFile(ANDROID_PHOTO_PATH + "/" + img.getName(), img);
                WebDriverWait wait = new WebDriverWait(androidDriver, (10));
                ExpectedCondition condition = ExpectedConditions.numberOfElementsToBe(photo, 1);
                wait.until(condition);
                WebDriverWait wait1 = new WebDriverWait(androidDriver, (10));
                wait1.until(ExpectedConditions.presenceOfElementLocated(photo)).click();
                androidDriver.rotate(ScreenOrientation.LANDSCAPE);
                WebDriverWait wait2 = new WebDriverWait(androidDriver, (10));
                wait2.until(ExpectedConditions.presenceOfElementLocated(info)).click();
                WebDriverWait wait3 = new WebDriverWait(androidDriver, (10));
                System.out.println("pathInfo   ****   " + wait3.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText());
                WebDriverWait wait5 = new WebDriverWait(androidDriver, (10));
                Assert.assertEquals(wait5.until(ExpectedConditions.presenceOfElementLocated(pathInfo)).getText(), "/storage/emulated/0/Pictures/HeadSpin-Drive-Test-Vehicle.png");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                androidDriver.quit();
            }
        }


        public void clearExistingPhotos(AndroidDriver androidDriver) {
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


    @Test
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

            LoginGmail( androidDriver);

            WebDriverWait swait = new WebDriverWait(androidDriver, (20));
            swait.until(ExpectedConditions.presenceOfElementLocated(takeMeToGmail)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(dismiss_button)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(composeMail)).click();


            swait.until(ExpectedConditions.presenceOfElementLocated(SmartComoseGotit)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(toAddress1)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(toAddress1)).sendKeys("");
            swait.until(ExpectedConditions.presenceOfElementLocated(avatar)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(subject)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(subject)).sendKeys("attach");
            swait.until(ExpectedConditions.presenceOfElementLocated(composeBodyArea)).click();


            swait.until(ExpectedConditions.presenceOfElementLocated(attachfile)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(attachfromfile)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(imgfile)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(imgfileOpen)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(sendEmail)).click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            androidDriver.quit();
        }
    }

    public void LoginGmail(AndroidDriver androidDriver) throws InterruptedException {
        WebDriverWait swait = new WebDriverWait(androidDriver, (20));
        swait.until(ExpectedConditions.presenceOfElementLocated(gotit)).click();
        swait.until(ExpectedConditions.presenceOfElementLocated(setup_addresses_add_anotherEmail)).click();
        swait.until(ExpectedConditions.presenceOfElementLocated(selectgmail2)).click();

        Thread.sleep(6999); WebDriverWait swait1 = new WebDriverWait(androidDriver, (20));
        swait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignName)).click();
        swait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignName)).sendKeys("@gmail.com");
        swait1.until(ExpectedConditions.presenceOfElementLocated(Next)).click();


        swait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignPass1)).click();
        swait1.until(ExpectedConditions.presenceOfElementLocated(gmailsignPass1)).sendKeys("");
        swait1.until(ExpectedConditions.presenceOfElementLocated(Next)).click();

        WebDriverWait swait2 = new WebDriverWait(androidDriver, (20));
        swait2.until(ExpectedConditions.presenceOfElementLocated(agree)).click();
        swait2.until(ExpectedConditions.presenceOfElementLocated(backagree)).click();

    }



          @Test
    public void clearGmail() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        File classpathRoot = new File(System.getProperty("user.dir"));
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("platformVersion", "8.1");
        dc.setCapability("deviceName", "Android Emulator");
//        dc.setCapability("appPackage", "com.google.android.gm");
//        dc.setCapability("appActivity", "com.google.android.gm.setup.AccountSetupFinalGmail");
        dc.setCapability("appPackage", "com.google.android.gm");
        dc.setCapability("appActivity", "com.google.android.gm.GmailActivity");


        //      com.google.android.gm.ComposeActivityGmail  com.google.android.gm.setup.AccountSetupFinalGmail - Account setup
        AndroidDriver androidDriver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), dc);
        try {

            Thread.sleep(6999);
            WebDriverWait swait = new WebDriverWait(androidDriver, (20));
            swait.until(ExpectedConditions.presenceOfElementLocated(gotit)).click();
            WebDriverWait swait1 = new WebDriverWait(androidDriver, (20));
            swait1.until(ExpectedConditions.presenceOfElementLocated(takeMeToGmail)).click();
            swait1.until(ExpectedConditions.presenceOfElementLocated(dismiss_button)).click();


            swait.until(ExpectedConditions.presenceOfElementLocated(ExistingEmailAaddress)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(ManageAccDevice)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(selectExistingEmail)).click();

            swait.until(ExpectedConditions.presenceOfElementLocated(rmButton)).click();
            swait.until(ExpectedConditions.presenceOfElementLocated(rmConfirmButton)).click();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            androidDriver.quit();
        }
    } }
