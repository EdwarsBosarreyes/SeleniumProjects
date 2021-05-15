package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Confirmacion {
    public WebElement titulo;
    public WebElement cerrar;

    public Confirmacion(WebDriver driver){
        titulo = driver.findElement(By.id("example-modal-sizes-title-lg"));
        cerrar = driver.findElement(By.id("closeLargeModal"));

    }}
