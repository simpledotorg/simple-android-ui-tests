package utils;

import io.appium.java_client.AppiumDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AdbUtils {
    AppiumDriver driver;
    public void relaunchApp(){
        driver.runAppInBackground(Duration.ofSeconds(1));
    }
}
