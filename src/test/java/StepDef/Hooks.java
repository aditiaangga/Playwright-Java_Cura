package StepDef;

import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    private static Playwright playwright;
    private static Browser browser;
    private static Page page;
    private static Scenario currentScenario;

    @Before
    public void browserSetup(Scenario scenario) {
        String browserName = System.getProperty("browser", "chromium"); // default chromium
        playwright = Playwright.create();

        switch (browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "webkit":
                browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Browser tidak didukung: " + browserName);
        }

        page = browser.newPage();
        currentScenario = scenario;

        logSystemInfo(browserName);
    }

    private void logSystemInfo(String browserName) {
        BrowserContext context = page.context();
        System.out.println("🚀 Browser: " + browserName);
        System.out.println("🖥️ OS: " + System.getProperty("os.name") + " " +
                System.getProperty("os.version") + " (" + System.getProperty("os.arch") + ")");
    }

    public static Page getPage() {
        return page;
    }

    public static Scenario getCurrentScenario() {
        return currentScenario;
    }

    @After(order = 1)
    public void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    @After
    public void takeScreenshotFinal(Scenario scenario) {
        try {
            if (page != null) {
                byte[] screenshot = page.screenshot(new Page.ScreenshotOptions().setFullPage(true));

                if (scenario.isFailed()) {
                    scenario.attach(screenshot, "image/png", "Failed Screenshot");
                    System.out.println("Screenshot diambil untuk skenario gagal: " + scenario.getName());
                } else {
                    scenario.attach(screenshot, "image/png", "Passed Screenshot");
                    System.out.println("Screenshot diambil untuk skenario sukses: " + scenario.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
