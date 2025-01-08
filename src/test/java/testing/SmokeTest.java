package testing;

import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


public class SmokeTest {

    Playwright playwright = Playwright.create();
    Map<String, String> map = new HashMap<>();


    @Test(groups = "QA")
    public void getRequest() {
        map.put("content-type", "application/json");
        APIRequestContext response =  playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://api.restful-api.dev/")
                .setExtraHTTPHeaders(map));

        APIResponse response1 = response.get("/objects");
        response1.ok();
        System.out.println(response1.status());
    }

    @Test(groups = "Stage")
    public void patchRequest() {
        System.out.println("A");
    }
}
