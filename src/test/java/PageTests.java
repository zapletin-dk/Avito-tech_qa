import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class PageTests {
    Browser browser;
    Page page;
    String body = "{" +
                        "\"result\":{" +
                            "\"blocks\":{" +
                                "\"personalImpact\":{" +
                                    "\"data\":{" +
                                        "\"co2\":0," +
                                        "\"energy\":0," +
                                        "\"materials\":0," +
                                        "\"pineYears\":0," +
                                        "\"water\":0" +
                                    "}" +
                                "}" +
                            "}," +
                            "\"isAuthorized\":false" +
                        "}," +
                        "\"status\":\"ok\"" +
                    "}";
    /**
     * Launching browser method via mvn with browser from system properties
     *In case of debugging in IDE replace method body with
     * browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions()
     *                         .setHeadless(false)
     *                         .setChannel("chrome")
     *                         .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
     *So you can run test via Run Test button
     */
    @BeforeClass
    public void launchBrowser() {
        browser = BrowserSingleton.getBrowser();
    }
    /**
     * Closes browser instance after all test done in class
    */
    @AfterClass
    public void tearDown() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }
    @Test
    public void test1() throws InterruptedException {
        page = browser.newPage();

        page.route("https://www.avito.ru/web/1/charity/ecoImpact/init", route -> {
            route.fulfill(new Route.FulfillOptions()
                    .setStatus(200)
                    .setBody(body.replace("\"co2\":0","\"co2\":1").replace("\"energy\":0","\"energy\":3").replace("\"water\":0", "\"water\":999"))); // Используем сохраненное тело ответа
        });
        page.navigate("https://www.avito.ru/avito-care/eco-impact");
        Thread.sleep(3000);
    }
}
