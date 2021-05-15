package Tests;

import Pages.Confirmacion;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.TestBase;
import Pages.Form1;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class LlenarFormulario extends TestBase {

    @Test
    public void LlenarFormularioInformacionMinima(){
        Form1 form = new Form1(chromeDriver);

        generateWait.until(ExpectedConditions.visibilityOf(form.firstName));
        form.firstName.sendKeys("Edwars");
        chromeDriver.findElement(form.lastName).sendKeys("Bosarreyes");
        form.phoneNumber.sendKeys("1234567890");
        form.gender.click();
        form.submit.submit();

        //Verificar luego de enviar form
        Confirmacion confirmacion = new Confirmacion(chromeDriver);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(confirmacion.titulo.getText(), "Thanks for submitting the form");
        confirmacion.cerrar.click();
    }
}
