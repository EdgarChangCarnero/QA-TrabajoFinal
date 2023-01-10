package stepsdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import pageobject.Home;
import pageobject.LoginPage;
import pageobject.MakeAppointment;

public class OpenCureStepsDefinitions {
    @Steps
    Home home;
    @Steps
    LoginPage loginPage;
    @Steps
    MakeAppointment makeAppointment;
    @Given("^que ingreso a la web cura healthcare service$")
    public void queIngresoALaWebCuraHealthcareService(){
        home.open();
    }
    @When("^ingreso el usuario (.*) y contrasenia (.*)$")
    public void ingresoElUsuarioYContrasenia(String username, String pass) {
    loginPage.enterDataUser(username, pass);
    }
    @And("^realizo la solicitud de atencion ingresando el centro atencion (.*), el programa (.*), la fecha (.*) y un comentario (.*)$")
    public void realizoLaSolicitudDeAtencionIngresandoElCentroAtencionFacilityElProgramaProgramLaFechaDateYUnComentarioComment(String facility, String program, String date, String comment) {
        makeAppointment.FormMakeAppointment(facility, program, date, comment);
    }
    @Then("^valido que se genero la solicitud de atencion creada$")
    public void validoQueSeGeneroLaSolicitudDeAtencionCreada() {
        makeAppointment.validateSolicitudAtencionCreada();
    }
}
