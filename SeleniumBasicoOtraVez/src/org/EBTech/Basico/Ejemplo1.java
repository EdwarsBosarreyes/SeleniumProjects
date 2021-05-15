package org.EBTech.Basico;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ejemplo1 {
    public static void main(String[] args){
        //instanciar un objeto WebDriver
        WebDriver driver;

        //Declarar variables
        String baseURL = "http://newtours.demoaut.com";
        String actualResult = "";
        String expectResult = "Welcome: Mercury Tours";

        //indicar la localización del archivo chromedriver.exe en la propiedad webdriver.chrome.driver
        //System.getProperty("user.dir") -> Localización
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

        //Abrir el navegador
        driver = new ChromeDriver();

        //Navegar a la pagina
        driver.get(baseURL);

        //Obtener el titulo de la pagina
        actualResult = driver.getTitle();

        //Imprimir el resultado usando el operador ternario
        System.out.println(actualResult.contentEquals(expectResult)?"Prueba Aceptada! "+actualResult :"Prueba Fallida");
        driver.close();
    }
}
