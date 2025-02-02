package sandip;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DragDropFunctionality extends BaseClass{

    @Test
    public void DragDrop(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement sourceEle = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

        driver.executeScript("mobile: dragGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)sourceEle).getId(),
                        "endX",614,
                        "endY",605
                        ));

        String result = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();

        Assert.assertEquals("Dropped!",result);


    }
}
