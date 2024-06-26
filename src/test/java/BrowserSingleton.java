import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

import java.util.Arrays;
/**
 * The class returns a single browser instance based on system property or standard if property non-exist
 *
*/
public class BrowserSingleton {
    private static Browser browser;
    /**
     * @return Singleton Browser instance
     */
    public static Browser getBrowser() {
        boolean headless = System.getProperty("headless") == null;
        if (null == browser) {
            if (System.getProperty("browser") == null){
                return browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions()
                        .setHeadless(headless)
                        .setChannel("")
                        .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
            } else {
                switch (System.getProperty("browser")) {
                    case "firefox" -> browser = Playwright
                            .create()
                            .firefox()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(headless)
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                    case "safari" -> browser = Playwright
                            .create()
                            .webkit()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(headless)
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                    case "edge" -> browser = Playwright
                            .create()
                            .chromium()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(headless)
                                    .setChannel("msedge")
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                    default -> browser = Playwright
                            .create()
                            .chromium()
                            .launch(new BrowserType.LaunchOptions()
                                    .setHeadless(headless)
                                    .setChannel("chrome")
                                    .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
                }
            }
        }
        return browser;
    }
}

