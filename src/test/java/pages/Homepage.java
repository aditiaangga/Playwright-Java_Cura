package pages;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.Assertions;

public class Homepage {
    Page page;
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
    }

    public void clickMakeAppointment() {
//        page.wait(1000);
        page.evaluate("window.scrollBy(0,-500)");
//        page.wait(1000);
        page.locator(buttonMakeAppointment).click();
    }

    public void goToMakeAppointment(){
//        page.wait(1000);
        page.evaluate("window.scrollBy(0,-500)");
//        page.wait(1000);
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
//        page.locator(visitDate).fill(date);
        page.locator(visitDate).type(date);
//        page.locator(visitDate).click();
//        page.locator("//div[@class='datepicker-days']//th[@class='next']").click();
//        page.locator("//td[.='"+date+"']");
    }

    public void comment(String com){
        page.locator(comment).fill(com);
    }

    public void submitBookAppointment(){
        page.locator(buttonBookAppointment).click();
    }

    public void emptyValidation(){
        Locator required = page.locator(visitDate);
        System.out.println(required.getAttribute("required"));

//        WebElement visitDate = driver.findElement(By.name("visit_date"));
//        Boolean isRequiredVisitDate = Boolean.valueOf(driver.findElement(By.name("visit_date")).getAttribute("required"));
//        //visitDate.getAttribute("required");
//        System.out.println(isRequiredVisitDate);
//        visitDate.isDisplayed();
//        String getTextVisitDate = visitDate.getText();
//        Assertions.assertEquals(getTextVisitDate , "");
//        Assertions.assertEquals(isRequiredVisitDate , "true");
////        Assertions.assertEquals(getTextVisitDate , "test");
//        String message = visitDate.getAttribute("validationMessage");
//        System.out.println("message : " + message);
    }
}
