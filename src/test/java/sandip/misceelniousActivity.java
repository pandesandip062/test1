package sandip;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class misceelniousActivity extends  BaseClass {

    @Test
    public void landScapeMode() {

        //Test in landscape mode


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DeviceRotation deviceRotation1 = new DeviceRotation(0,0,0);
        driver.rotate(deviceRotation1);
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).clear();
        DeviceRotation deviceRotation = new DeviceRotation(0,0,90);
        driver.rotate(deviceRotation);
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        driver.findElement(By.id("android:id/edit")).sendKeys("Sandip_Wifi");
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String WifiString = driver.findElement(By.id("android:id/alertTitle")).getText();

        Assert.assertEquals("WiFi settings",WifiString);
    }

    @Test
    public void clipBoardCopy(){
        DeviceRotation deviceRotation1 = new DeviceRotation(0,0,0);
        driver.rotate(deviceRotation1);
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.findElement(By.id("android:id/checkbox")).clear();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        driver.setClipboardText("Sandip_wiwfi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String WifiString = driver.findElement(By.id("android:id/alertTitle")).getText();

        Assert.assertEquals("WiFi settings",WifiString);
    }

    @Test
    public void differntKays(){

        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));

    }
}
