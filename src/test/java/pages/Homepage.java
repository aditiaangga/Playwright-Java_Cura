package pages;

import com.microsoft.playwright.*;
import utils.ScreenshotUtil;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class Homepage {
    Page page;
    ScreenshotUtil ss = new ScreenshotUtil(page);

    public Homepage(Page page){
        this.page = page;
    }

    String makeAppointment = "//h2[.='Make Appointment']";
    String buttonMakeAppointment = "id=btn-make-appointment";
    String hospitalReadmission = "id=chk_hospotal_readmission";
    String visitDate = "id=txt_visit_date";
    String comment = "id=txt_comment";
    String buttonBookAppointment = "id=btn-book-appointment";

    public void verifyHomepage(){
        String homepage = page.locator(makeAppointment).textContent();
        System.out.println(homepage);
        homepage.equals("Make Appointment");
        ss.takeScreenshot("Homepage");
    }

    public void clickMakeAppointment() {
//        page.wait(1000);
        ss.takeScreenshot("Make Appointment");
        page.evaluate("window.scrollBy(0,-500)");
//        page.wait(1000);
        ss.takeScreenshot("Make Appointment");
        page.locator(buttonMakeAppointment).click();
    }

    public void goToMakeAppointment(){
//        page.wait(1000);
        ss.takeScreenshot("Make Appointment");
        page.evaluate("window.scrollBy(0,-500)");
//        page.wait(1000);
        ss.takeScreenshot("Make Appointment");
        page.evaluate("window.scrollBy(0,500)");
    }

    public void facility(String city){
        page.selectOption("#combo_facility",city+" CURA Healthcare Center");
    }

    public void hospitalReadmission(){
        page.locator(hospitalReadmission).check();
    }

    public void healthcareProgram(String hc){
        page.locator("//input[@value='"+hc+"']").check();
    }

    public void date(String date){
//        page.locator(visitDate).type(date);

        // Set tanggal tertentu dalam format dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate targetDate = LocalDate.parse(date, formatter);

        // Ambil 3 huruf pertama dari nama bulan (contoh: "Feb" untuk February)
        String month = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).substring(0, 3);
        int year = targetDate.getYear();
        int day = targetDate.getDayOfMonth();

        // Pilih tanggal di datepicker
        page.locator("//label[@for='txt_visit_date']").click();
        page.locator("(//th[@class='datepicker-switch'])[1]").click();
        page.locator("(//th[@class='datepicker-switch'])[2]").click();
        page.locator("//span[text()='" + year + "']").click();
        page.locator("//span[text()='" + month + "']").click();
        page.locator("//td[text()='" + day + "']").click();
    }

    public void comment(String com){
        page.locator(comment).fill(com);
    }

    public void submitBookAppointment(){
        page.locator(buttonBookAppointment).click();
    }

    public void emptyValidation(){
        Locator date = page.locator(visitDate);

        // Ambil element handle
        ElementHandle element = date.elementHandle();

        // Ambil validationMessage dari JS
        String validationMessage = (String) element.evaluate("el => el.validationMessage");
        System.out.println("Validation Message: " + validationMessage);

        // Assert sesuai ekspektasi
        Assertions.assertEquals("Please fill out this field.", validationMessage);
        ss.takeScreenshot("Empty Validation");
    }
}
