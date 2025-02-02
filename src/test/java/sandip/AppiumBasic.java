package sandip;

import com.aventstack.extentreports.App;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumBasic extends BaseClass {

    @Test
    public void AppiumTest() {

        //driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Preference\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).clear();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Sandip_Wifi");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String WifiString = driver.findElement(By.id("android:id/alertTitle")).getText();

        Assert.assertEquals("WiFi settings",WifiString);

//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"App\"]")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Menu\"]")).click();
//        String menuValue = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Inflate from XML\"]")).getText();
//
//        System.out.println("value from menu --> "+menuValue);

    }
}
