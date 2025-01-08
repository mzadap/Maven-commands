package testing;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class Regression {

    private Playwright playwright;
    private Page page;

    @Test
    public void verify_basic_test() {
      playwright = Playwright.create();
      Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
      page = browser.newPage();
      page.navigate("https://www.automationexercise.com/");
      page.locator("//a[normalize-space()='Cart']").click(new Locator.ClickOptions().setClickCount(1));
      page.locator("//b[normalize-space()='Cart is empty!']").isVisible();
    }
}
