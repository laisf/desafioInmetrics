package desafioWeb;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Login {
    String url;
    WebDriver driver;
    String pastaPrint = "loginEvidencia/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

    public void tirarPrint(String nomePrint) throws IOException {
        File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(foto, new File(pastaPrint + nomePrint + ".png"));
    }

    @Before
    public void iniciar() {
        url = "https://inm-test-app.herokuapp.com/accounts/login/";
        System.setProperty("webdriver.chrome.driver", "drivers/88/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
    }

    @After
    public void finalizar() {
        //driver.quit();
    }

    @Dado("^que entro na pagina de login$")
    public void queEntroNaPaginaDeLogin() throws IOException {
        driver.get(url);
        tirarPrint("Ct001 - Print 01 - Acessou a pagina de Login");
    }

    @Quando("^escrevo o Usuario \"([^\"]*)\"$")
    public void escrevoOUsuario(String usuario) {
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys(usuario);

    }

    @E("^digito a Senha \"([^\"]*)\" e pressiono a tecla Enter$")
    public void digitoASenhaEClicoEmEntre(String senha) throws InterruptedException {
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[5]/input[1]")).sendKeys(senha + Keys.ENTER);
        Thread.sleep(5000);
    }

    @Entao("^exibe a pagina de funcionarios cadastrados$")
    public void exibeAPaginaDeFuncionariosCadastrados() throws IOException, InterruptedException {
        tirarPrint("Ct001 - Print 02 - Acessou a pagina de funcionários");
        Thread.sleep(5000);

    }


    @Entao("^o site exibe a menssagem de \"([^\"]*)\" Usuário ou Senha inválidos$")
    public void oSiteExibeAMenssagemDeErroUsuárioOuSenhaInválidos(String msgErro) throws IOException {
        assertEquals(msgErro, driver.findElement(By.xpath("//strong[contains(text(),'ERRO!')]")).getText());
        tirarPrint("Ct002 - Print 01 - Exibe mensagem de erro");

    }


}




