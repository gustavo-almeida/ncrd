import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Cpav extends Base {

    @Test
    public void ValidarOpcaoSolicitar()
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

        driver.findElementByAccessibilityId("Solicitar").click();
        driver.findElementByAccessibilityId("INFORMAÇÕES SOBRE O VEÍCULO").isDisplayed();
    }

    @Test
    public void ValidarOpcaoSimularContratacao()
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
    public void ValidarOpcaoSairQueEncerraAAplicacaoTelaDadosDoVeiculo(){
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
    public void ValidarTodasAsOpcoesSliderDeEntrada()
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
}
