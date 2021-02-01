package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class Alterar extends PageObject {


    public Alterar(WebDriver driver) {

        super(driver);
    }
    @Test
    public void ct04_alterarUsuario () {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .put("https://inm-test-api.herokuapp.com/empregado/alterar/553")
        .then()
                .log().all()
                .statusCode(200)
        ;
    }
}
