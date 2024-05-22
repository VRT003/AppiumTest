package pages.app;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import utils.utils;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
    public AndroidDriver driver;
    public GeneralStore generalStore;

    @BeforeClass
    @Step("setup")
    @DisplayName("Start the Appium server")

    public static void setup() {
        utils.AppiumServerStart();
    }
    @Before
    public void startapp() {
        utils options = new utils();

        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver(url, options.defineConfig());

        generalStore = new GeneralStore(driver);
    }

    @After
    public void closeapp() {
        if (driver != null) {
            driver.terminateApp("com.androidsample.generalstore");
            driver.quit();
        }
    }

    @AfterClass
    @Step("teardown")
    @DisplayName("Stop the Appium Server")
    public static void teardown() {
        utils.AppiumServerStop();
    }
}
