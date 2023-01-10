package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject {
    public static WebDriver driver;
    @FindBy (id = "txt-username")
    public WebElementFacade userNameTxt;
    @FindBy (id = "txt-password")
    public WebElementFacade passWordTxt;
    @FindBy (id = "btn-login")
    public WebElementFacade login;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }
    public MakeAppointment enterDataUser(String username, String pass) {
        userNameTxt.sendKeys(username);
        passWordTxt.sendKeys(pass);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", login);
        return new MakeAppointment();
    }
}

