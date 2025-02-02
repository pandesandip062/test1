package ecommerace;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class addToCart extends AppiumEcomarceBasic{


    @Test
    public void addToCart(){
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.findElement(By.id("android:id/text1")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
//                ".scrollIntoView(text(\"India\"));")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sandip Pande");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("btnLetsShop")).click();

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(text(\"Jordan 6 Rings\"));"));

        int productSize = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();

        for(int i=0;i<productSize;i++){
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equals("Jordan 6 Rings")){
                driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).click();
            }

        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
    }

}
