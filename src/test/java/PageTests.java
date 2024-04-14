import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.util.Arrays;


public class PageTests {
    Browser browser;
    BrowserContext context;
    Page page;
    String body = "{\"result\":{\"blocks\":{\"personalImpact\":{\"data\":{\"co2\":0,\"energy\":0,\"materials\":0,\"pineYears\":0,\"water\":0}}},\"isAuthorized\":false},\"status\":\"ok\"}";

    @BeforeClass
    public void launchBrowser() {
        browser = Playwright
                .create()
                .chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setChannel("chrome")
                        .setArgs(Arrays.stream((new String[]{"--disable-service-worker"})).toList()));
        //browser = BrowserSingleton.getBrowser();

    }

    @AfterClass
    public void tearDown() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
    }

//    @BeforeMethod
//    public void createContextAndPage() {
//        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
//        context.tracing().start(new Tracing.StartOptions()
//                .setScreenshots(true)
//                .setSnapshots(true)
//                .setSources(false));
//        page = context.newPage();
//    }

//    @AfterMethod
//    public void closeContext() {
//        context.close();
//    }


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
