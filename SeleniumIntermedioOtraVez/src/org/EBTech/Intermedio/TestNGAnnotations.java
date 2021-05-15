package org.EBTech.Intermedio;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Este método se ejecutará antes de una suite de pruebas");
   }

   @BeforeTest
    public void beforeTest(){
       System.out.println("Este método se ejecutará antes de las pruebas @Test");
   }

   @BeforeClass
    public void beforeClass(){
       System.out.println("Este método se ejecutará antes de la clase");
   }

   @BeforeMethod
    public void beforeMethod(){
       System.out.println("Se ejecutará antes de cada método de prueba @Test");
   }

   @Test
    public void testCase1(){
       System.out.println("Caso de prueba 1");
   }

    @Test
    public void testCase2(){
        System.out.println("Caso de prueba 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Se ejecutará después de cada método de prueba");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Se ejecutará después de la Clase");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Se ejecutara después de todas las pruebas");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Se ejecutará después de una suite de pruebas");
    }

}
