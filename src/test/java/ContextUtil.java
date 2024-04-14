import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.options.ViewportSize;

import java.awt.*;
/**
 * Class create browser context instance with window size
 * Default size 1920x1080
 */
public class ContextUtil {
    /**
     * @return BrowserContext type
     */
    public static BrowserContext getBrowserContext(Browser browser){
        if (System.getProperty("w") == null && System.getProperty("h") == null ){
            ViewportSize viewportSize = new ViewportSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
            return  browser.newContext(new Browser.NewContextOptions().setViewportSize(viewportSize));
        } else {
            return browser.newContext(new Browser.NewContextOptions().
                    setViewportSize(new ViewportSize(Integer.parseInt(System.getProperty("w")),Integer.parseInt(System.getProperty("h")))));
        }
    }
}
