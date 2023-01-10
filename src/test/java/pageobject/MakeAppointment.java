package pageobject;
//import actions.SelectOptions;
import actions.SelectOptions;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;


public class MakeAppointment extends PageObject {
    @FindBy (id = "combo_facility")
        public WebElementFacade facilityTxt;
    @FindBy (xpath = "/html/body/section/div/div/form/div[3]/div/label")
    public List<net.serenitybdd.core.pages.WebElementFacade> listprogramTxt;
    @FindBy (id = "txt_visit_date")
        public WebElementFacade dateTxt;
    @FindBy (id = "btn-book-appointment")
        public WebElementFacade commentTxt;
    @FindBy (id = "btn-book-appointment")
    public WebElementFacade buttonBookAppointment;
    @FindBy (xpath = "//h2[text()='Appointment Confirmation']")
        public WebElementFacade textOrderConfirm;

    public void FormMakeAppointment (String facility, String program, String date, String comment){
        Select elementFacility = new Select(facilityTxt);
        elementFacility.selectByVisibleText(facility);
        SelectOptions.in(listprogramTxt, program);
        dateTxt.type(date);
        textOrderConfirm.type(comment);
        JavascriptExecutor js= (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click();",textOrderConfirm);
    }
    public void validateSolicitudAtencionCreada(){
        textOrderConfirm.withTimeoutOf(Duration.ofSeconds(20)).isEnabled();
        Assert.assertEquals(textOrderConfirm.getText(), "Appointment Confirmation");
    }
}
