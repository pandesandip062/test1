package ecommerace;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sandip.BaseClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

public class AppiumEcomarceBasic extends BaseClass {

    public AppiumDriverLocalService service;
    public AndroidDriver driver ;
    @BeforeMethod(alwaysRun = true)
    public void configuration() throws MalformedURLException, URISyntaxException, InterruptedException {

        //code for appium server start/stop
        ;

        service= new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withLogFile(new File("appium_logs.txt"))
                .build();

        service.start();

        while (!service.isRunning()) {
            Thread.sleep(1000); // Wait for 1 second and check again
        }
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Sandip");



        options.setChromedriverExecutable("C:\\Users\\Admin\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        options.setApp("C:\\Users\\Admin\\IdeaProjects\\mobileAutomationNew\\src\\test\\resources\\General-Store.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
