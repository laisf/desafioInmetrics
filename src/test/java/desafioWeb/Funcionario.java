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

public class Funcionario {
    String url;
    WebDriver driver;
    String pastaPrint = "funcionarioEvidencia/" + new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

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

    @Dado("^que acesso o site de login$")
    public void que_acesso_o_site_de_login() throws IOException {
        driver.get(url);
        tirarPrint("Ct001 - Print 01 - Acessou a pagina de Login");
    }

    @Quando("^digito o Usuario \"([^\"]*)\"$")
    public void digitoOUsuario(String usuario) throws InterruptedException {
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys(usuario);
    }

    @E("^escrevo a Senha \"([^\"]*)\" e pressiono a tecla Enter$")
    public void escrevoASenhaEPressionoATeclaEnter(String senha) {
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[5]/input[1]")).sendKeys(senha + Keys.ENTER);
    }

    @Entao("^exibe a pagina de funcionarios que estao cadastrados$")
    public void exibeAPaginaDeFuncionariosQueEstaoCadastrados() throws IOException {
        tirarPrint("Ct001 - Print 02 - Página de Funcionários Cadastrados");
    }

    @Quando("^clico em Novo Funcionario$")
    public void clicoEmNovoFuncionarios() {
        driver.findElement(By.xpath("//a[contains(text(),'Novo Funcionário')]")).click();
    }

    @E("^preencho \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\" e \"([^\"]*)\"$")
    public void PreenchoEEEEEE(String nome, String cpf, String sexo, String admissao, String cargo, String salario, String tipoDeContratacao) throws Throwable {
        driver.findElement(By.xpath("//input[@id='inputNome']")).sendKeys(nome);
        driver.findElement(By.xpath("//input[@id='cpf']")).sendKeys(Keys.chord(cpf));
        driver.findElement(By.xpath("//select[@id='slctSexo']")).sendKeys(sexo);
        driver.findElement(By.xpath("//input[@id='inputAdmissao']")).sendKeys(admissao);
        driver.findElement(By.xpath("//input[@id='inputCargo']")).sendKeys(cargo);
        driver.findElement(By.xpath("//input[@id='dinheiro']")).sendKeys(salario);
        driver.findElement(By.xpath("//input[@id='clt']")).click();
        tirarPrint("Ct001 - Print 03 - Página de cadastro de funcionários");
    }

    @E("^clico em Enviar$")
    public void clicoEmEnviar() {
        driver.findElement(By.className("cadastrar-form-btn")).click();
    }

    @Entao("^o cadastro e feito com sucesso$")
    public void oCadastroEFeitoComSucesso() throws IOException {
        assertEquals("SUCESSO!", driver.findElement(By.xpath("//strong[contains(text(),'SUCESSO!')]")).getText());
        tirarPrint("Ct001 - Print 04 - Mensagem de cadastro feito com sucesso");

    }


    //CT002
    @Dado("^que abro na pagina de login$")
    public void queAbroNaPaginaDeLogin() throws IOException {
        driver.get(url);
        tirarPrint("Ct002 - Print 01 - Acessou a pagina de Login");
    }

    @Quando("^preencho o campo Usuario com \"([^\"]*)\"$")
    public void preenchoOCampoUsuarioCom(String usuario) {
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[3]/input[1]")).sendKeys(usuario);
    }

    @E("^digito Senha \"([^\"]*)\" e pressiono a tecla Enter$")
    public void digitoSenhaEPressionoATeclaEnter(String senha){
        driver.findElement(By.xpath("//body/div[1]/div[2]/div[1]/form[1]/div[5]/input[1]")).sendKeys(senha + Keys.ENTER);
    }


    @Quando("^clico em Funcionario$")
    public void clicoEmFuncionario() throws IOException {
        driver.findElement(By.xpath("//a[contains(text(),'Funcionários')]")).click();
        tirarPrint("Ct002 - Print 02 - Página de funcionários cadastrados");
    }

    @E("^seleciono o botao amarelo de Editar do nome \"([^\"]*)\" da lista$")
    public void selecionoOBotaoAmareloDeEditarDoNomeDaLista(String nome)  {
        driver.findElement(By.xpath("//tbody/tr[1]/td[6]/a[2]/button[1]/span[1]")).click();
    }

    @Quando("^exibe a pagina de cadastro$")
    public void exibeAPaginaDeCadastro() throws IOException {
        tirarPrint("Ct002 - Print 03 - Pagina de Cadastro para edicao");
    }

    @E("^altero o nome para \"([^\"]*)\" em Enviar$")
    public void alteroONomeParaEmEnviar(String nomeCorrigido) {
        driver.findElement(By.xpath("//input[@id='inputNome']")).clear();
        driver.findElement(By.xpath("//input[@id='inputNome']")).sendKeys(nomeCorrigido + Keys.ENTER);

    }
    @Entao("^atualiza as informacoes com sucesso$")
    public void atualizaAsInformacoesComSucesso() throws IOException {
        assertEquals("SUCESSO!",driver.findElement(By.xpath("//strong[contains(text(),'SUCESSO!')]")).getText());
        tirarPrint("Ct002 - Print 04 - Exibe mensagem de Atualizacao feita com Sucesso");
    }

    //CT003
    @E("^seleciono o botao vermelho de Excluir do segundo nome \"([^\"]*)\" da lista$")
    public void selecionoOBotaoVermelhoDeExcluirDoSegundoNomeDaLista(String nomeFuncionario) throws IOException {
        driver.findElement(By.xpath(" //tbody/tr[5]/td[6]/a[1]/button[1]/span[1]")).click();
        tirarPrint("Ct003 - Print 01 - Acessou a página de Funcionários Cadastrados");
    }

    @Entao("^remove o funcionario com sucesso$")
    public void removeOFuncionarioComSucesso() throws IOException {
        assertEquals("SUCESSO!", driver.findElement(By.xpath("//strong[contains(text(),'SUCESSO!')]")).getText());
        tirarPrint("Ct003 - Print 02 - Exibe mensagem de Exclusão feita com Sucesso");
    }
}
