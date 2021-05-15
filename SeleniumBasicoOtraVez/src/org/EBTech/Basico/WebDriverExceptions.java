package org.EBTech.Basico;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverExceptions {
    static WebDriver driver;
    public static void main(String[] args){

        try{

            String baseUrl = "http://live.demoguru99.com/index.php";
            String actualResult = "";
            String expectedResult = "$615.00";
            String chromePath = System.getProperty("user.dir")+"/drivers/chromedriver";

            System.setProperty("webdriver.chrome.driver", chromePath);
            driver = new ChromeDriver();
            driver.get(baseUrl);
            driver.manage().window().maximize();

            //Clic en link TV
            WebElement lnkTV = driver.findElement(By.linkText("TV"));
            lnkTV.click();

            //Click en el boton ADD TO CART
            WebElement btnAddToCart = driver.findElement(By.xpath("//*[@id=\"to\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/button/span/span"));
            btnAddToCart.click();

            //Obtener el precio
            WebElement lblSubtotal = driver.findElement(By.cssSelector("#shopping-cart-table>tbody>tr>td.product-cart-total>span>span"));
            actualResult = lblSubtotal.getText();

            if(actualResult.contentEquals(expectedResult)){
                System.out.println("Prueba Aceptada!, el resultado actual es: " + actualResult + " es igual a "+ expectedResult);
            }else{
                System.out.println("Prueba Fallida!, el resultado actual es: " + actualResult + " no es igual a "+ expectedResult);
            }
        }catch(NoSuchElementException ne){
            System.err.println("No se encontro el WebElement: "+ne.getMessage());
        }catch(WebDriverException we){
            System.err.println("WebDriver falló: "+we.getMessage());
        }catch(Exception ex){
            System.err.println(ex.getMessage());
        }
        finally{
            driver.close();
        }

    }
}
