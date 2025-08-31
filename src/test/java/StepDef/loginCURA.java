package StepDef;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import pages.Appointment;
import pages.Homepage;
import pages.Login;
import utils.ScreenshotUtil;

import java.io.IOException;

public class loginCURA {

    private final Page page = Hooks.getPage();
    private final Login login = new Login(page);
    private final Homepage home = new Homepage(page);
    private final Appointment appointment = new Appointment(page);
    private final ScreenshotUtil ss = new ScreenshotUtil(page);

    @Given("User Open website CURA Healthcare with browser")
    public void userOpenWebsiteCURAHealthcareWithBrowser() {
        page.navigate("https://katalon-demo-cura.herokuapp.com/");
    }

    @When("User input username {string}, password {string} and Click Sign In")
    public void userInputUsernamePasswordAndClickSignIn(String user, String pass) {
        login.clickMenuLogin();
        login.enterUsername(user);
        login.enterPassword(pass);
        ss.takeScreenshot("Login Page");
        login.clickLogin();
    }

    @Then("User verify Homepage")
    public void userVerifyHomepage() {
        home.verifyHomepage();
    }

    @And("User Click Appointment")
    public void userClickAppointment() {
        home.clickMakeAppointment();
    }

    @And("User Go To Make Appointment")
    public void userGoToMakeAppointment() {
        home.goToMakeAppointment();
    }

    @And("User fill the Data {string}, {string}, {string}, {string} about Appointment")
    public void userFillTheDataAboutAppointment(String city, String hc, String date, String com) {
        home.verifyHomepage();
        home.facility(city);
        home.hospitalReadmission();
        home.healthcareProgram(hc);
        ss.takeScreenshot("Fill The Data");
        home.date(date);
        home.comment(com);
        ss.takeScreenshot("Fill The Data");
        home.submitBookAppointment();
    }

    @Then("User verify Appointment")
    public void userVerifyAppointment() {
        appointment.verifyAppointment();
        ss.takeScreenshot("Appointment Confirmation");
    }

    @And("User fill the Date {string} about Appointment")
    public void userFillTheDateAboutAppointment(String date) {
        home.verifyHomepage();
        home.date(date);
        ss.takeScreenshot("Fill The Data");
        home.submitBookAppointment();
    }
}
