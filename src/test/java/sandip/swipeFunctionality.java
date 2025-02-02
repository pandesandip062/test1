package sandip;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class swipeFunctionality extends BaseClass{

    @Test
    public void swipeFunctionality() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
       WebElement ele = driver.findElement(By.xpath("//android.widget.ImageView[1s]"));
       String attribute = ele.getAttribute("focusable");
        Assert.assertEquals(attribute,"true");

        //swipe code
        driver.executeScript("mobile: swipeGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "direction", "left",
                        "percent", 0.75));
        Thread.sleep(2000);

        Assert.assertEquals(attribute,"false");
    }
}
