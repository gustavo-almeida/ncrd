import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Cpav extends Base {

    @Test
    public void ValidarOpcaoSolicitarTelaInicial()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();

        Assert.assertTrue(driver.findElementByName("credito info").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("R$ 100.000,00").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Solicitar").isDisplayed());
    }

    @Test
    public void ValidarCardPrincipalEMenuLateral()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        //Verifica o Card Principal
        Assert.assertTrue(driver.findElementByAccessibilityId("Crédito").isDisplayed());
        driver.findElementByName("menu").click();

        //Verifica a opção no Menu Lateral
        Assert.assertTrue(driver.findElementByAccessibilityId("Crédito").isDisplayed());
    }

    @Test
    public void ValidarOpcaoVoltarDaTelaInicial()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();

        driver.findElementByAccessibilityId("Voltar").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());    }

    @Test
    public void ValidarOpcaoSairDaTelaInicial()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();

        //Logout
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("iphone-logo").isDisplayed());
    }

    @Test
    public void ValidarOpcaoSimularContratacaoTelaInformacaoVeiculos()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        Assert.assertTrue(driver.findElementByAccessibilityId("Valor de entrada:").isDisplayed());
    }

    @Test
    public void ValidarOpcaoSairQueEncerraAAplicacaoTelaDadosDoVeiculo()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("iphone-logo").isDisplayed());
    }

    @Test
    public void ValidarTodasAsOpcoesSliderTelaDeEntrada()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        ////
        //Valida se o valor inicial é alterado após utilizar o Slider
        ////
        //Dados iniciais
        Assert.assertTrue(driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"R$ 15.333,20\"])[1]").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Valor financiado: R$ 44.656,80").isDisplayed());
        //move o slider para 100%
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("1");
        //Dados finais
        Assert.assertTrue(driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"R$ 57.750,00\"])[1]").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Valor financiado: R$ 2.240,00").isDisplayed());
    }

    @Test
    public void ValidarValorBotaoContinuarTelaEntrada()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        driver.findElementByAccessibilityId("Continuar").click();

        //Valida página de seleção de data de vencimento
        Assert.assertTrue(driver.findElementByAccessibilityId("Dia de vencimento:").isDisplayed());
    }

    @Test
    public void ValidarValorASerFinanciadoEValorDeEntradaTelaEntrada()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        Assert.assertTrue(driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"R$ 15.333,20\"])[1]").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Valor financiado: R$ 44.656,80").isDisplayed());
    }

    @Test
    public void ValidarTodasAsOpcoesSliderTelaDiaDeVencimento()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        driver.findElementByAccessibilityId("Continuar").click();

        //Vefifica valor inicial dia de vencimento dia 1
        Assert.assertTrue(driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"1\"])[1]").isDisplayed());

        //Muda Slider para o dia 15
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("0.5");

        //Valida se o valor foi alterado com sucesso
        Assert.assertTrue(driver.findElementByAccessibilityId("15").isDisplayed());
    }

    @Test
    public void ValidarBotaoContinuarTelaDiaVencimento()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        driver.findElementByAccessibilityId("Continuar").click();

        //Muda Slider para o dia 15
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("0.5");

        driver.findElementByAccessibilityId("Continuar").click();

        //Verifica se foi para a Tela de número de parcelas
        Assert.assertTrue(driver.findElementByAccessibilityId("Número de parcelas:").isDisplayed());
    }

    @Test
    public void ValidarSliderTelaDeParcelas()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        driver.findElementByAccessibilityId("Continuar").click();

        //Muda Slider para o dia 15
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("0.5");

        driver.findElementByAccessibilityId("Continuar").click();

        //Vefifica valores iniciais de número e valor das parcelas
        Assert.assertTrue(driver.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"48\"])[1]").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Valor da parcela: R$ 1.066,35").isDisplayed());

        //Muda Slider para 12 parcelas
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("0.3");

        //Valida se o valor foi alterado com sucesso
        Assert.assertTrue(driver.findElementByAccessibilityId("12").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Valor da parcela: R$ 3.874,86").isDisplayed());
    }

    @Test
    public void ValidarBotaoContinuarTelaDeParcelas()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("juliano");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("590");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("92819");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        IOSElement banner = driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]");

        //Coordenadas da posição do elemento
        int x_element = banner.getLocation().getX();
        int y_element = banner.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = banner.getSize().getWidth() - x_element;
        int y_inicial = banner.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 300);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        driver.findElementByAccessibilityId("fun-credit-offer-vehicles").click();
        driver.findElementByAccessibilityId("Solicitar").click();

        ////////
        //Preencher dados do Veículo
        ////////

        //Marca
        driver.findElementByAccessibilityId("Marca").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("GM");
        driver.findElementByAccessibilityId("GM - Chevrolet").click();

        //Modelo
        driver.findElementByAccessibilityId("Modelo").click();
        driver.findElementByXPath("(//XCUIElementTypeSearchField[@name=\"Encontre o seu veículo\"])[1]").sendKeys("ONIX");
        driver.findElementByAccessibilityId("ONIX HATCH ACTIV 1.4 8V Flex 5P Aut.").click();

        //Ano Modelo / Combustível
        driver.findElementByAccessibilityId("Ano Modelo / Combustível").click();
        driver.findElementByAccessibilityId("2017 Gasolina").click();

        //Valor de compra
        driver.findElementByAccessibilityId("Valor de compra").click();
        driver.getKeyboard().sendKeys("5999000");

        driver.findElementByAccessibilityId("Simular contratação").click();

        driver.findElementByAccessibilityId("Continuar").click();

        //Muda Slider para o dia 15
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("0.5");

        driver.findElementByAccessibilityId("Continuar").click();

        //Muda Slider para 12 parcelas
        driver.findElementByClassName("XCUIElementTypeSlider").sendKeys("0.3");

        driver.findElementByAccessibilityId("Continuar").click();

        Assert.assertTrue(driver.findElementByAccessibilityId("CONFIRA SEUS DADOS ANTES DE CONFIRMAR A SOLICITAÇÃO!").isDisplayed());
    }
}
