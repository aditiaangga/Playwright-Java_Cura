package pages;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import org.junit.jupiter.api.Assertions;

public class Appointment {
    Page page;
    public Appointment(Page page){
        this.page = page;
    }

    public void verifyAppointment(){
        Locator confirmation = page.locator("id=summary");
        confirmation.isVisible();
        String confText = confirmation.innerText();
        System.out.println(confText);
        confText.equals("Appointment Confirmation");
    }
}
