package sandip;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class longPressTest extends BaseClass{


    @Test
    public void longPressAction(){

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement ele= driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

        //Long click

         driver.executeScript("mobile:longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));

         String title= driver.findElement(By.id("android:id/title")).getText();
        Assert.assertEquals("Sample menu",title,"assertion completed");


    }
}
