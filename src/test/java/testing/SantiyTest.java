package testing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.playwright.APIRequest;
import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SantiyTest {

    Playwright playwright = Playwright.create();
    Map<String, String> map = new HashMap<>();

    @Test(groups = {"QA", "Stage"})
    public void postRequestTest() {
        String payload = "{\n" +
                "  \"name\": \"Apple MacBook Pro 16\",\n" +
                "  \"data\": {\n" +
                "    \"year\": 2019,\n" +
                "    \"price\": 1849.99,\n" +
                "    \"CPU model\": \"Intel Core i9\",\n" +
                "    \"Hard disk size\": \"1 TB\"\n" +
                "  }\n" +
                "}";

        map.put("content-type", "application/json");
        APIRequestContext response =  playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://api.restful-api.dev/")
                .setExtraHTTPHeaders(map));

        APIResponse response1 = response.post("/objects", RequestOptions.create().setData(payload));
        System.out.println(response1.status());
        System.out.println("santiy Test");
    }

    @Test(groups = {"QA"})
    public void getRequest() {
        map.put("content-type", "application/json");
        APIRequestContext response =  playwright.request().newContext(new APIRequest.NewContextOptions()
                .setBaseURL("https://api.restful-api.dev/")
                .setExtraHTTPHeaders(map));

        APIResponse response1 = response.get("/objects");
        response1.ok();
        System.out.println(response1.status());
    }

    @Test
    public void postTest() {
        System.out.println("hello");
    }
}
