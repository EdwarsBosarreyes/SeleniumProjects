package org.EBTech.Basico;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Prueba1 {
    public static void main(String[] args){
        //instanciar un objeto WebDriver
        WebDriver driver;

        //Declarar variables
        String baseURL = "https://s1.demo.opensourcecms.com/s/44";
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");

        //Abrir el navegador
        driver = new ChromeDriver();

        //Navegar a la pagina
        driver.get(baseURL);

        WebDriverWait wait = new WebDriverWait(driver,25);
        wait.until(presenceOfElementLocated(By.id("txtUsername")));

    }
}
