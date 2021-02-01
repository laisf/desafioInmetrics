package desafioApi;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Alterar;
import pages.Cadastrar;
import pages.Listar;
import pages.ListarTodos;
import utils.Evidences;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class InmetricsPO {

     Cadastrar cadastrar;
     Listar listar;
     ListarTodos listarTodos;
     Alterar alterar;
     Evidences evidences;
     String id;
     String url;
     WebDriver driver;

     static String pastaPrint = "APIevidencias/" + new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(Calendar.getInstance().getTime()) + "/";

     public String lerJson(String caminhoJson) throws IOException {
          return new String(Files.readAllBytes(Paths.get(caminhoJson)));
     }

     @Before
     public void iniciar() {
          url = "https://inm-test-api.herokuapp.com/swagger-ui.html#/";
          System.setProperty("webdriver.chrome.driver", "drivers/chrome/88/chromedriver.exe");

          driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

          evidences = new Evidences();
          cadastrar = new Cadastrar(driver);
          listar = new Listar(driver);
          listarTodos = new ListarTodos(driver);
          alterar = new Alterar(driver);

     }

     @After
     public void finalizar() {
          driver.quit();
     }

     @Dado("^que acesso a documentacao api \"([^\"]*)\"$")
     public void queAcessoADocumentacaoApi(String id) throws IOException {
          driver.get(url);
          this.id = id;
          evidences.takesScreenshot(driver, id, pastaPrint, "CT001 - Print001 - Acessou o a documentação");
          System.out.println("CT001 - Print001 -  Acessou o a documentação");
     }

     @Quando("^executo o endpoint /emprego/cadastrar de Post$")
          public void executoOEndpointEmpregoCadastrarDePost() throws IOException {
          cadastrar.ct01_cadastrarUsuario();
          evidences.takesScreenshot(driver, id, pastaPrint, "CT001 - Print002 Acessou o POST");
          System.out.println("CT001 - Print002 Acessou o POST");
          }

     @Quando("^executo o endpoint /empregado/list/(\\d+) de Get$")
     public void executoOEndpointEmpregadoListDeGet(int arg0) throws IOException {
          listar.ct02_listarUsuario();
          evidences.takesScreenshot(driver, id, pastaPrint, "CT002 - Print001 Acessou o GET");
          System.out.println("CT002 - Print001 Acessou o GET");
     }

     @Quando("^que executo o endpoint /empregado/list_all de Get All$")
     public void queExecutoOEndpointEmpregadoList_allDeGetAll() throws IOException {
          listarTodos.ct03_listarTodos();
          evidences.takesScreenshot(driver, id, pastaPrint, "CT003 - Print001 - Acessou o GET ALL");
          System.out.println("CT003 - Print001 - Acessou o GET ALL");
     }

     @Quando("^executo o endpoint /alterar/(\\d+) de Put$")
     public void executoOEndpointAlterarDePut(int arg0) throws IOException {
          alterar.ct04_alterarUsuario();
          evidences.takesScreenshot(driver, id, pastaPrint, "CT004 - Print001 - Acessou o PUT");
          System.out.println("CT004 - Print001 - Acessou o PUT");
     }

     @Entao("^retorna o codigo de sucesso \"([^\"]*)\"$")
     public void retornaOCodigoDeSucesso(String codigo) throws IOException {
          assertEquals(codigo, cadastrar.codigoDeSucesso());
          evidences.takesScreenshot(driver, id, pastaPrint, "CT001 - Print003 - Evidencia codigo de sucesso");
          System.out.println("CT001 - Print003 - Evidencia codigo de sucesso");
     }

     @Entao("^lista o \"([^\"]*)\" com sucesso$")
     public void listaOComSucesso(String nomeFuncionario) throws IOException {
          assertEquals(nomeFuncionario, listar.lerNome());
          evidences.takesScreenshot(driver, id, pastaPrint, "CT002 - Print002 - Certifica a presença do nome na lista");
          System.out.println("CT002 - Print002 - Certifica a presença do nome na lista");
     }

     @Entao("^mostra a lista com todos os funcionarios e o \"([^\"]*)\"$")
     public void mostraAListaComTodosOsFuncionariosEO(String codigoOK) throws IOException {
          assertEquals(codigoOK, listarTodos.lerCodigoOK());
          evidences.takesScreenshot(driver, id, pastaPrint, "CT003 - Print002 - Evidencia codigo de sucesso");
          System.out.println("CT003 - Print002 - Evidencia codigo de sucesso");
     }


}








