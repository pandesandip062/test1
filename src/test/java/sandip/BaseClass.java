package sandip;

import browserstack.shaded.com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class BaseClass {
    public AppiumDriverLocalService service;
    public AndroidDriver driver ;
    @BeforeMethod(alwaysRun = true)
    public void configuration() throws MalformedURLException, URISyntaxException, InterruptedException {

        //code for appium server start/stop

                service= new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Sandip");
        options.setApp("C:\\Users\\Admin\\IdeaProjects\\mobileAutomationNew\\src\\test\\resources\\ApiDemos-debug.apk");
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
    }

   @AfterMethod(alwaysRun = true)
    public void tearDown(){

        //driver.quit();
        service.stop();
    }
}
