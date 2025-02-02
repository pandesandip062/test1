package ecommerace;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class hybridApp extends AppiumEcomarceBasic{

    @Test
    public void hybridApp() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(2000);

        Set<String> pages = driver.getContextHandles();
        for( String conextName:pages){
            System.out.println("conetxt name is --> "+conextName);
        }

        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.name("q")).sendKeys("Sandip");
        Thread.sleep(5000);

    }
}
