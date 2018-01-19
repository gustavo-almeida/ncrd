import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Agendamentos extends Base{
    @Test
    public void ValidarExibicaoSubmenusProgramados() throws InterruptedException
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("julia");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("938564");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        //Acessar Card Agendamentos
        driver.findElementByAccessibilityId("Agendamentos").click();

        TimeUnit.SECONDS.sleep(3);

        IOSElement secaoProgramados = driver.findElementByAccessibilityId("Seção Programados");
        if("Fechado".equals(secaoProgramados.getAttribute("value")))
        {
            secaoProgramados.click();
        }

        TimeUnit.SECONDS.sleep(3);

        Assert.assertTrue(driver.findElementByAccessibilityId("Dia").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Descrição").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Valor (R$)").isDisplayed());
    }

    @Test
    public void ValidarAOpcaoVoltarQueRetornaAoMenuPrincipal() throws InterruptedException
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("julia");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("938564");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        //Acessar Card Agendamentos
        driver.findElementByAccessibilityId("Agendamentos").click();

        TimeUnit.SECONDS.sleep(3);

        IOSElement secaoProgramados = driver.findElementByAccessibilityId("Seção Programados");
        if("Fechado".equals(secaoProgramados.getAttribute("value")))
        {
            secaoProgramados.click();
        }

        TimeUnit.SECONDS.sleep(3);

        driver.findElementByAccessibilityId("Voltar").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());
    }

    @Test
    public void ValidarAOpcaoSairQueEncerraAAplicacao() throws InterruptedException
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("julia");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("938564");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        //Acessar Card Agendamentos
        driver.findElementByAccessibilityId("Agendamentos").click();

        TimeUnit.SECONDS.sleep(3);

        IOSElement secaoProgramados = driver.findElementByAccessibilityId("Seção Programados");
        if("Fechado".equals(secaoProgramados.getAttribute("value")))
        {
            secaoProgramados.click();
        }

        TimeUnit.SECONDS.sleep(3);

        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("iphone-logo").isDisplayed());
    }

    @Test
    public void ValidarExclusaoDeAgendamentos() throws InterruptedException
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("julia");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("938564");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        //Acessar Card Agendamentos
        driver.findElementByAccessibilityId("Agendamentos").click();

        TimeUnit.SECONDS.sleep(3);

        IOSElement secaoProgramados = driver.findElementByAccessibilityId("Seção Programados");
        if("Fechado".equals(secaoProgramados.getAttribute("value")))
        {
            secaoProgramados.click();
        }

        TimeUnit.SECONDS.sleep(3);

        //Selecionar primeiro agendamento da lista selecionável
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"LIQ TIT - IB\"])[1]\n").click();

        if("Aberto".equals(secaoProgramados.getAttribute("value")))
        {
            secaoProgramados.click();
        }

        //Clicar em Excluir Selecionados
        driver.findElementByAccessibilityId("Acesse sua conta Avançar").click();

        TimeUnit.SECONDS.sleep(3);

        //Clicar em Confirmar Exclusão
        driver.findElementByAccessibilityId("Acesse sua conta Avançar").click();

        TimeUnit.SECONDS.sleep(3);
        Assert.assertTrue(driver.findElementByAccessibilityId("Agendamento(s) excluído(s) com sucesso.").isDisplayed());

        //Clicar em OK
        driver.findElementByAccessibilityId("Ok").click();

        TimeUnit.SECONDS.sleep(3);
        //Valida se voltou para a seção de agendamentos programados
        Assert.assertTrue(driver.findElementByAccessibilityId("Seção Programados").isDisplayed());
    }

    @Test
    public void ValidarSelecaoParaExclusaoENaoConfirmacaoDoRegistroSelecionado() throws InterruptedException
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("julia");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("938564");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        //Acessar Card Agendamentos
        driver.findElementByAccessibilityId("Agendamentos").click();

        TimeUnit.SECONDS.sleep(3);

        //Expandir Seção Agendamentos Programados
        if("Fechado".equals(driver.findElementByAccessibilityId("Seção Programados").getAttribute("value")))
        {
            driver.findElementByAccessibilityId("Seção Programados").click();
        }

        TimeUnit.SECONDS.sleep(3);

        //Selecionar primeiro agendamento da lista selecionável
        driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"LIQ TIT - IB\"])[1]").click();

        //Recolher Seção Agendamentos Programados
        if("Aberto".equals(driver.findElementByAccessibilityId("Seção Programados").getAttribute("value")))
        {
            driver.findElementByAccessibilityId("Seção Programados").click();
        }

        //Clicar em Excluir Selecionados
        driver.findElementByAccessibilityId("Acesse sua conta Avançar").click();

        TimeUnit.SECONDS.sleep(3);

        //Clicar em Voltar da tela de confirmação de exclusão
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"Agendamentos\"]").click();
        //driver.findElementByAccessibilityId("Voltar").click();

        //Expandir Seção Agendamentos Programados
        if("Fechado".equals(driver.findElementByAccessibilityId("Seção Programados").getAttribute("value")))
        {
            driver.findElementByAccessibilityId("Seção Programados").click();
        }

        Assert.assertTrue(driver.findElementByAccessibilityId("Mais Informações").isDisplayed());
    }
}
