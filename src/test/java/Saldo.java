import io.appium.java_client.ios.IOSElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Saldo extends Base {
    @Test
    public void ValidarPosicaoDosSubmenus()
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

        driver.findElementByAccessibilityId("Saldo").click();

        //Aguarda carregamento página de Saldo
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        IOSElement menuPosicaoConsolidada = driver.findElementByAccessibilityId("Seção Posição Consolidada");
        //Recolher seção Posição consolidada
        if ("Aberto".equals(menuPosicaoConsolidada.getAttribute("value"))) {
            driver.findElementByAccessibilityId("Seção Posição Consolidada").click();
        }
        Assert.assertTrue(menuPosicaoConsolidada.isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Seção Horários e Limites").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Seção Lançamentos Futuros").isDisplayed());
    }

    @Test
    public void ValidarPosicaoVoltarTelaDeSaldo()
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

        driver.findElementByAccessibilityId("Saldo").click();

        //Aguarda carregamento página de Saldo
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElementByAccessibilityId("Voltar").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());
    }

    @Test
    public void ValidarBotaoSairTelaDeSaldo()
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

        driver.findElementByAccessibilityId("Saldo").click();

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
