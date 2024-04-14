import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.Arrays;

public class BrowserSingleton {
    private static Browser browser;

    public static Browser getBrowser() {
        if (null == browser) {
            switch (System.getProperty("browser")) {
                case "firefox" -> {
                    browser = Playwright
                            .create()
                            .firefox()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(false)
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                }
                case "safari" -> {
                    browser = Playwright
                            .create()
                            .webkit()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(false)
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                }
                case "edge" -> {
                    browser = Playwright
                            .create()
                            .chromium()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(false)
                                    .setChannel("msedge")
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                }
                default -> {
                    browser = Playwright
                            .create()
                            .chromium()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(false)
                                    .setChannel("chrome")
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                }
            }
        }

        return browser;
    }
}

