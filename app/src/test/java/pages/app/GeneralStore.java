package pages.app;

import org.junit.Assert;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;

public class GeneralStore extends TestBase{
    private final AndroidDriver driver;
    String text="Australia";
    String sko="Air Jordan 9 Retro";
    public GeneralStore(AndroidDriver driver){
        this.driver = driver;
    }
    @Step("Velg sted")
    public void velgSted() {


        driver.findElement(By.id("android:id/text1")).click();
        Allure.step("Klikket på Sted");

        String uiSelector = "new UiSelector().textMatches(\"" + text
                + "\")";

        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector + ");";

        driver.findElement(new AppiumBy.ByAndroidUIAutomator(command)).click();
        Allure.step("Sted er " + text + " valgt");

    }
    @Step("Velg kjønn og klikk på Lets Shop")
    public void velgKjonnOgKjop() {
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        Allure.step("Kjønn er valgt");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastmsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        Assert.assertEquals(toastmsg, "Please enter your name");
        Allure.step("Toast message " + toastmsg + " viser");

        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Linda");
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Allure.step("Klikket på LetsShop");

    }
    @Step("Velg Sko og Legg til kart")
    public void velgSkoOgLeggtilkart() {

        String uiSelector1 = "new UiSelector().textMatches(\"" + sko
                + "\")";

        String command1 = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView("
                + uiSelector1 + ");";

        driver.findElement(new AppiumBy.ByAndroidUIAutomator(command1)).isDisplayed();
        Allure.step(sko + " viser");
        driver.findElement(By.xpath("//android.widget.TextView[@text='$170.97']/following-sibling::android.widget.TextView")).click();
        Allure.step("klikket Add to cart for " + sko);
    }
    @Step("Klikk på kart og verifisere Total Amount")
    public void klikkKart(){

        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Allure.step("klikket cart history");
        String totalAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Assert.assertEquals(totalAmount,"$ 170.97");
        Allure.step("Total amount "+totalAmount+" er verifisert");

    }


}
