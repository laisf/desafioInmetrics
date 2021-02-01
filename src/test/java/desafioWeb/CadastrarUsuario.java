package desafioWeb;


import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class CadastrarUsuario {
    String url;
    WebDriver driver;
    String pastaPrint = "cadastroEvidencia/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    public void tirarPrint(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));
    }

    @Before
    public void iniciar(){
        url = "https://inm-test-app.herokuapp.com/accounts/login/";
        System.setProperty("webdriver.chrome.driver","drivers/88/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);


    }

    @After
    public void finalizar (){
        //driver.quit();

    }
    @Dado("^que acesso a pagina de login$")
    public void queAcessoAPaginaDeLogin() throws IOException, InterruptedException {
        driver.get(url);
        tirarPrint("Ct001 - Print 01 - Acessou a pagina de Login");


    }


    @Quando("^clico em Cadastre-se$")
    public void clicoEmCadastreSe() {
        driver.findElement(By.xpath("//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();

    }

    @E("^preencho o Usuario \"([^\"]*)\"$")
    public void preenchoOUsuario(String nomeUsuario) throws IOException {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]")).sendKeys(nomeUsuario);
        tirarPrint("Ct001 - Print 02 - Acessou a pagina de Cadastro");

    }


    @Quando("^digito a Senha \"([^\"]*)\" e confirmo a Senha \"([^\"]*)\"$")
    public void digitoASenhaEConfirmoASenha(String senha, String confirmaSenha) throws Throwable {
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/div[4]/input[1]")).sendKeys(senha);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/form[1]/div[6]/input[1]")).sendKeys(confirmaSenha);

    }

    @E("^clico em Cadastrar$")
    public void clicoEmCadastrar() {
        driver.findElement(By.className("login100-form-btn")).click();
    }

    @Entao("^o site realiza o cadastro e vai para a pagina de login$")
    public void oSiteRealizaOCadastroEVaiParaAPaginaDeLogin() throws IOException, InterruptedException {
        assertEquals("Login", driver.findElement(By.xpath("//span[contains(text(),'Login')]")).getText());
        tirarPrint("Ct001 - Print 03 - Cadastro efetuado e acessa a pagina de Login");

    }

    //CT002
    @Entao("^exibe a mensagem de erro: \"([^\"]*)\"$")
    public void exibeAMensagemDeErro(String msgErro) throws IOException, InterruptedException {
        assertEquals(msgErro, driver.findElement(By.xpath("//div[contains(text(),'Senhas não combinam')]")).getText());
        tirarPrint("CT002 - Print01 - Mensagem de erro: Senhas não combinam");
        }

    //CT003
    @Entao("^exibe a mensagem que explica o erro: \"([^\"]*)\"$")
    public void exibeAMensagemQueExplicaOErro(String msgErro) throws IOException {
        assertEquals(msgErro, driver.findElement(By.xpath("//div[contains(text(),'Usuário já cadastrado')]")).getText());
        tirarPrint("CT003 - Print01 - Mensagem de erro: Usuário já cadastrado");
    }
}
