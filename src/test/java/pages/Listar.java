package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class Listar extends PageObject {
    @FindBy(xpath = "//span[contains(text(),'\"Ana Laura Peixoto\"')]")
    private WebElement nomeFuncionario;

        public Listar(WebDriver driver) {
        super(driver);
    }

    public String lerNome() {
        return nomeFuncionario.getText();
    }

    @Test
    public void ct02_listarUsuario() {
        String nomeEsperado = "Rosa Maria Pereira";

        given()
                .contentType("application/json")
                .log().all()
        .when()
                .get("https://inm-test-api.herokuapp.com/empregado/list/553")
        .then()
                .log().all()
                ;
    }


}