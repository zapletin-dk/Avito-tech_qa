import com.microsoft.playwright.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

public class PageTests {
    Browser browser;
    BrowserContext context;
    Page page;
    protected final Logger logger = LogManager.getRootLogger();
    File directory = new File("output/");
    File[] files = directory.listFiles();
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
     *In case of debugging in IDE replace method body with code below and import @java.util.Arrays
     * browser = Playwright.create().chromium().launch(new BrowserType.LaunchOptions()
     *                         .setHeadless(false)
     *                         .setChannel("chrome")
     *                         .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
     *So you can run test via Run Test button
     */
    @BeforeClass
    public void launchBrowser() {
        browser = BrowserSingleton.getBrowser();
        context = ContextUtil.getBrowserContext(browser);

    }
    /**
     * Delete all attachments for outputs dir before running tests
     */
    @BeforeClass
    public void deleteAttachments(){
        directoryCleanup();
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

    public String bodyConverter(Number number){
        return body.replaceAll("0", number.toString());
    }

    public void directoryCleanup(){
        int filesCounter;
        if (files != null) {
            filesCounter = files.length;
            for (File file : files) {
                if (!file.isDirectory()) {
                    file.delete();
                }
            }
            logger.info(String.format("Directory cleaned! %s files had been delete successfully", filesCounter));
        } else {
            logger.info("Directory is empty!");
        }
    }

    @Test
    public void test() {
        List<Number> data = List.of(0, 1, 99, 100, 101, 999 , 1_000, 1_501, 9_999, 11_700, 12_601,
                99_999, 100_000, 101_001, 999_999, 1_230_000, 1_670_001, 9_999_999, 16_452_000, 17_777_001,
                99_999_999, 111_111_000, 155_558_001, 9_999_999_999L, 10_000_000_000L, 16_606_060_001L,
                99_999_999_999L, 180_180_180_000L, 777_666_555_001L, 999_999_999_999L, 1_000_000_000_000L, 1.5, 0.3);
        int counter = 1;
        page = context.newPage();
        for (Number number: data) {
            page.route("https://www.avito.ru/web/1/charity/ecoImpact/init", route -> route.fulfill(new Route.FulfillOptions()
                    .setStatus(200)
                    .setBody(bodyConverter(number))));
            page.navigate("https://www.avito.ru/avito-care/eco-impact");


            for (int j = 1; j <= 3; j++) {
                page.locator("xpath=//div[@class='desktop-impact-item-eeQO3']" + "[" + j * 2 + "]").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("output/" + "test" + counter + "_screenshot_" + j + ".png")));
            }
            counter++;
        }
        logger.info(String.format("Had been created %d attachments",files.length));
    }
}
