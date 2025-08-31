package testCases;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import pages.Appointment;
import pages.Homepage;
import pages.Login;

public class tc5_FailedAppointment {
    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        BrowserType.LaunchOptions setHeadless = new BrowserType.LaunchOptions().setHeadless(false).setChannel("msedge");
        Page page = playwright.chromium().launch(setHeadless).newPage();

        page.navigate("https://katalon-demo-cura.herokuapp.com/");

        Login login = new Login(page);
        login.clickMenuLogin();
        login.enterUsername("John Doe");
        login.enterPassword("ThisIsNotAPassword");
        login.clickLogin();

        Homepage home = new Homepage(page);
        home.verifyHomepage();
        home.submitBookAppointment();
        home.emptyValidation();

    }
}
