import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Extrato extends Base{
    @Test
    public void ValidarExibicaoSubmenusExtratoELancamentosFuturosTelaInicial()
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

        driver.findElementByAccessibilityId("Extratos").click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Valida se informação Extrato está sendo exibida
        Assert.assertTrue(driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Últimos 3 dias\"]").isDisplayed());

        driver.findElementByAccessibilityId("LANÇAMENTOS FUTUROS").click();

        //Valida se informação Lancamentos futuros está sendo exibida
        Assert.assertTrue(driver.findElementByXPath("//XCUIElementTypeOther[@name=\"Próximos 3 dias\"]").isDisplayed());
    }

    @Test
    public void ValidarOpcaoVoltarTelaInicial()
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

        driver.findElementByAccessibilityId("Extratos").click();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElementByAccessibilityId("Voltar").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());    }

    @Test
    public void ValidarBotaoSairTelaInicial()
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

        driver.findElementByAccessibilityId("Extratos").click();

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
}
