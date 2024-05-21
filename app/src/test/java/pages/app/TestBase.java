package pages.app;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.net.MalformedURLException;
import java.net.URL;

import io.qameta.allure.Allure;
import utils.utils;

import io.appium.java_client.android.AndroidDriver;

public class TestBase {
    public AndroidDriver driver;
    public GeneralStore generalStore;


    @Before
    public void setup() {
        utils.AppiumServerStart();

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
    public void teardown() {
        driver.quit();
        utils.AppiumServerStop();
    }
}
