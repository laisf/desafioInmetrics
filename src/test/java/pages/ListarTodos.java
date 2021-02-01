package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.restassured.RestAssured.given;

public class ListarTodos extends PageObject {

    @FindBy(xpath = "//body[1]/div[1]/section[1]/div[2]/div[2]/div[5]/section[1]/div[1]/span[3]/div[1]/div[1]/span[4]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    WebElement codigoOK;

    public ListarTodos(WebDriver driver) {
        super(driver);
    }

    public String lerCodigoOK() {
        return codigoOK.getText();
    }

    @Test
    public void ct03_listarTodos() {
        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get("https://inm-test-api.herokuapp.com/empregado/list_all")
        .then()
                .log().all()
        ;
    }

}
