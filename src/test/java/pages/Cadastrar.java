package pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class Cadastrar extends PageObject {

    @FindBy(xpath = "//span[contains(text(),'\"Ana Laura Peixoto\"')]")
    private WebElement lerCodigo;

    public Cadastrar(WebDriver driver) {
        super(driver);
    }

    public String codigoDeSucesso() {
        return lerCodigo.getText();
    }

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test
    public void ct01_cadastrarUsuario() throws IOException {
        String jsonBody = lerJson("src/test/resources/desafioApi/Funcionario.json");
        given()
                .contentType("application/json")
                .log().all()
                .body(jsonBody)
        .when()
                .post("https://inm-test-api.herokuapp.com/empregado/cadastrar")
        .then()
                .log().all()

        ;
    }






}
