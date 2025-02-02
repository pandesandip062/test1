package sandip;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.Activity;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppActivity extends BaseClass {

    @Test
    public void AppAcivity(){

        driver.executeScript("mobile: startActivity",
                ImmutableMap.of( "intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

        driver.setClipboardText("Sandip_wiwfi");
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        String WifiString = driver.findElement(By.id("android:id/alertTitle")).getText();

        Assert.assertEquals("WiFi settings",WifiString);
    }
}
