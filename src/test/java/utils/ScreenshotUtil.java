package utils;

import StepDef.Hooks;
import com.microsoft.playwright.Page;
import io.cucumber.java.Scenario;

import java.nio.file.Files;
import java.nio.file.Path;

public class ScreenshotUtil {
    private final Page page;

    public ScreenshotUtil(Page page) {
        this.page = page;
    }

    public void takeScreenshot(String name) {
        try {
            Scenario scenario = Hooks.getCurrentScenario(); // Ambil Scenario dari Hooks

            if (page != null) {
                // Simpan screenshot sementara
                Path screenshotPath = Path.of("temp_screenshot.png");
                page.screenshot(new Page.ScreenshotOptions()
                        .setPath(screenshotPath)
                        .setFullPage(true));

                // Baca file screenshot jadi byte[]
                byte[] screenshotBytes = Files.readAllBytes(screenshotPath);

                // Lampirkan ke report Cucumber
                scenario.attach(screenshotBytes, "image/png", name);

                // Hapus file sementara
                Files.deleteIfExists(screenshotPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
