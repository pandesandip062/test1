package ecommerace;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class formFill extends  AppiumEcomarceBasic{


    @Test
    public void forFillTest(){


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"India\"));")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sandip Pande");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("btnLetsShop")).click();
    }

    @Test
    public void tosatErrorMessage(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.id("android:id/text1")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
//                ".scrollIntoView(text(\"India\"));")).click();

        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("btnLetsShop")).click();
       String errorMsg = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getDomAttribute("name");
        System.out.println(errorMsg);
    }
}
