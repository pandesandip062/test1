package sandip;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import org.testng.reporters.jq.BasePanel;

public class scrollDemo extends BaseClass {

    @Test
    public void  scrollDemo(){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();


        //scrolling 1st method

        /*driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"WebView\"));")).click();*/

        //scrolling 2nd method

        driver.executeScript("mobile: scrollGesture", ImmutableMap.of( "left", 100, "top", 100, "width", 200, "height", 200,
                "direction", "down",
                "percent", 3.0));
    }

}
