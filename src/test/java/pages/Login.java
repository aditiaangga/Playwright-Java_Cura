package pages;

import com.microsoft.playwright.*;

public class Login {
    private Page page;

    public Login(Page page) {
        this.page = page;
    }

    String menu = "id=menu-toggle";
    String menuLogin = "//a[.='Login']";
    String username = "id=txt-username";
    String password = "id=txt-password";
    String buttonLogin = "id=btn-login";

    //Method to click menu Login
    public void clickMenuLogin() {
        page.locator(menu).click();
        page.locator(menuLogin).click();
    }

    //Method to enter username
    public void enterUsername(String user) {
        page.locator(username).fill(user);
    }

    //Method to enter password
    public void enterPassword(String pass) {
        page.locator(password).fill(pass);
    }

    //Method to click on Login button
    public void clickLogin() {
        page.locator(buttonLogin).click();
    }


}
