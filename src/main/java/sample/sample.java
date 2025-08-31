package sample;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class sample {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
//            Browser browser = playwright.webkit().launch();
//            Page page = browser.newPage();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false);
        Page page = playwright.chromium().launch(setHeadless).newPage();
        page.navigate("https://playwright.dev/");
//            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));

    }
}
