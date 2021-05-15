package Tests;

import ApiStructure.DummieExampleApi;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.*;

public class ExampleApiTest {

    DummieExampleApi api = new DummieExampleApi();

    @Test
    public void getAllEmployees(){
       RequestSpecification httpRequest = RestAssured.given();
       httpRequest.baseUri(api.baseUrl);
       httpRequest.basePath(api.employees);

       //Hacer Consulta
        httpRequest.get().then()
                .assertThat()
                .statusCode(is(equalTo(200)));
    }

    @Test
    public void getEmployeeById(){
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.baseUri(api.baseUrl);
        httpRequest.basePath(api.employee);

        //Hacer Consulta
        httpRequest.get("/1").then()
                .assertThat()
                .statusCode(is(equalTo(200)))
                .body("message", is(equalTo("Successfully! Record has been fetched.")))
                .body(containsString("Tiger Nixon"))
                .body("data.employee_name", is(equalTo("Tiger Nixon")));
    }

    @Test
    public void createEmployee(){
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.baseUri(api.baseUrl);
        httpRequest.basePath(api.create);

        //Hacer Consulta
        String payload = "{\n" +
                "    \"data\": {\n" +
                "        \"id\": \"26\",\n" +
                "        \"employee_name\": \"Tiger Nixon2\",\n" +
                "        \"employee_salary\": \"320800\",\n" +
                "        \"employee_age\": \"61\",\n" +
                "        \"profile_image\": \"\"\n" +
                "    }\n" +
                "}";
        httpRequest.body(payload).post().then()
                .assertThat()
                .statusCode(is(equalTo(200)));
    }

}
