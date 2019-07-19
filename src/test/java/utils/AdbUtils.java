package utils;

import io.appium.java_client.AppiumDriver;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Runtime.getRuntime;

public class AdbUtils {
    AppiumDriver driver;
    public void relaunchApp(){
        driver.runAppInBackground(Duration.ofSeconds(1));
    }

    public static void executeCommandUsingArray(String[] command) throws IOException, InterruptedException {
        for (String arg : command) {
            Process process = Runtime.getRuntime().exec(arg);
            process.waitFor();
        }
    }
}
