package testCases;

import com.microsoft.playwright.*;
import pages.Appointment;
import pages.Homepage;
import pages.Login;

public class tc3_AppointmentSuccessAllField {
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
        home.facility("Hongkong");
        home.hospitalReadmission();
        home.healthcareProgram("Medicaid");
        home.date("13/12/2023");
        home.comment("Thank You");
        home.submitBookAppointment();

        Appointment appointment = new Appointment(page);
        appointment.verifyAppointment();
    }
}
