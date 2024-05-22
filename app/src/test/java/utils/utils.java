package utils;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

public class utils {
    static AppiumDriverLocalService server;
    public static void AppiumServerStart(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withAppiumJS(new File("C:/Users/VRT003/node_modules/appium/build/lib/main.js")) // we can run without this
                .usingPort(4723)
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withArgument(GeneralServerFlag.USE_PLUGINS,"element-wait")
                .withIPAddress("127.0.0.1");
        server = AppiumDriverLocalService.buildService(builder);
        server.start();
        System.out.println("Appium Server har startet");
    }

    public static  void AppiumServerStop(){
        server.stop();
        System.out.println("Appium Server har stoppet");
    }

    public UiAutomator2Options defineConfig() {
        UiAutomator2Options options = new UiAutomator2Options();
        options
                .setPlatformName("Android")
                .setPlatformVersion("12")
                .setDeviceName("emulator-5554")
                .setAutomationName("UIAutomator2")
                .setAppPackage("com.androidsample.generalstore")
                .setAppActivity("com.androidsample.generalstore.MainActivity")
                .setFullReset(false)
                .setNoReset(true)
                .setApp("C:\\Users\\VRT003\\Documents\\Mobile Demo app\\apk\\General-Store.apk");
        options.setCapability("forceAppLaunch", "true");
        options.setCapability("–session-override", "true");
        return options;
    }


}
