package pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
public class Home extends PageObject {
@FindBy (id = "btn-make-appointment")
    public WebElementFacade buttonAppointment;

    public void buttonAppointment (){
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",buttonAppointment);
    }
}