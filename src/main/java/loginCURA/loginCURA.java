package loginCURA;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.nio.file.Paths;


public class loginCURA {
    @Test
    public void loginCURAHealthcare() {
        // create playwright and browser instances
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge");
        Page page = playwright.chromium().launch(setHeadless).newPage();


        // navigate to URL
        page.navigate("https://katalon-demo-cura.herokuapp.com/");

        // Go to Login Page
        page.keyboard().press("F11");
        page.locator("//a[@id='menu-toggle']").click();
        page.getByText("Login").click();

        // fill username & password
        page.locator("//input[@id='txt-username']").fill("John Doe");
        page.locator("//input[@id='txt-password']").fill("ThisIsNotAPassword");
        page.locator("//button[@id='btn-login']").click();

        // assert
        String makeAppointment = page.locator("//h2[.='Make Appointment']").textContent();
        System.out.println(makeAppointment);
        Assertions.assertEquals("Make Appointment", makeAppointment);

        Path screenshotPath = Paths.get(System.currentTimeMillis() + ".jpg");
        page.screenshot(new Page.ScreenshotOptions().setPath(screenshotPath));

        //close browsers and playwright instances
        playwright.close();


    }
}
