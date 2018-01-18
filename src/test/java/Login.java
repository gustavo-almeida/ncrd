import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;

import org.testng.Assert;
import org.testng.annotations.*;

public class Login extends Base{

    @Test
    public void ValidarAcessoComDadosCorretos()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("julia");
        //driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("julia");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        //driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("938564");
        //driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("938564");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        //driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElementByName("CONTINUAR").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());
    }

    @Test
    public void ValidarAcessoComDadosIncorretos()
    {
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("notuser");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("519");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("932264");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1022");
        driver.findElementByName("CONTINUAR").click();

        Assert.assertEquals(driver.findElementByAccessibilityId("Conta, usuário ou senha inválidos.").getText(),"Conta, usuário ou senha inválidos.");
    }

    @Test
    public void ErrarSenhaTresVezesValidarBloqueio()
    {
        for(int i=0; i<3; i++)
        {
            driver.findElementByName("ACESSE SUA CONTA").click();
            driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("dalmo");
            driver.findElementByName("CONTINUAR").click();
            driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
            driver.findElementByName("CONTINUAR").click();
            driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("75914");
            driver.findElementByName("CONTINUAR").click();
            driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1022");
            driver.findElementByName("CONTINUAR").click();
            if(i<2) {
                driver.findElementByAccessibilityId("SAIR").click();
            }
        }
        Assert.assertTrue(driver.findElementByAccessibilityId("Usuário Bloqueado. Contate o atendimento da sua cooperativa").isDisplayed());
    }

    @Test
    public void ValidarAcessoComFavoritos()
    {

        //Login com Julia
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

        //Logout
        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();

        driver.findElementByAccessibilityId("ENTRAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());
    }

    @Test
    public void ValidarAcessoSemFavoritos()
    {

        //Login com Julia
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("olga");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("75825");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());
    }

    @Test
    public void ValidarAcessoSemSalvarDados()
    {

        //Login com Julia
        driver.findElementByName("ACESSE SUA CONTA").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("julia");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("938564");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByXPath("//*/XCUIElementTypeSwitch[1]").click();
        driver.findElementByName("CONTINUAR").click();

        //Logout
        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();

        Assert.assertTrue(driver.findElementByName("ACESSE SUA CONTA").isDisplayed());
    }

    @Test
    public void ValidarExclusaoDeFavoritos()
    {

        //Login com Julia
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

        //Logout
        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();

        driver.findElementByAccessibilityId("Acessar outra conta").click();

        IOSElement cc = driver.findElementByAccessibilityId("julia");

        //Coordenadas da posição do elemento
        int x_element = cc.getLocation().getX();
        int y_element = cc.getLocation().getY();

        //Coordenadas do toque inicial (press())
        int x_inicial = cc.getSize().getWidth() - x_element;
        int y_inicial = cc.getSize().getHeight() + y_element;

        //Coordenadas do toque final (moveTo())
        int x_final = x_inicial - (x_inicial + 200);
        int y_final = 0;

        //Swipe to Delete
        (new TouchAction(driver))
                .press(x_inicial, y_inicial)
                .moveTo(x_final, y_final)
                .release()
                .perform();

        /*(new TouchAction(driver))
                .press(254, 163)
                .moveTo(-184, -3)
                .release()
                .perform();*/

        driver.findElementByName("Apagar").click();

        Assert.assertTrue(driver.findElementByName("ACESSE SUA CONTA").isDisplayed());
    }

    @Test
    public void ValidarOpcaoProximasAMim()
    {
        driver.findElementByAccessibilityId("ico near").click();
        Assert.assertTrue(driver.findElementByName("Agências").isDisplayed());
        //Assert.assertTrue(driver.findElementByName("3106 - PA UNIODONTO, Av Brasil, 200").isEnabled());
    }

    @Test
    public void ValidarOpcaoProximasAMimVerNoMapa()
    {
        driver.findElementByAccessibilityId("ico near").click();
        IOSElement buscaAgencia = driver.findElementByName("Busque por cidade, estado ou endereço");
        buscaAgencia.click();
        buscaAgencia.sendKeys("Nova Igua");
        driver.findElementByAccessibilityId("4509 - Unicred Serra Mar").click();
        driver.findElementByAccessibilityId("VER NO MAPA").click();
        driver.findElementByAccessibilityId("Local").click();
        Assert.assertTrue(driver.findElementByName("4509 - Unicred Serra Mar").isDisplayed());
    }

    @Test
    public void ValidarBuscaAgenciaCEPValido()
    {
        driver.findElementByAccessibilityId("ico near").click();
        IOSElement buscaAgencia = driver.findElementByName("Busque por cidade, estado ou endereço");
        buscaAgencia.click();
        buscaAgencia.sendKeys("90560030");
        driver.findElementByAccessibilityId("2708 - UN HMV").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("UN HMV").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("VER NO MAPA").isDisplayed());
    }

    @Test
    public void ValidarBuscaAgenciaEnderecoValido()
    {
        driver.findElementByAccessibilityId("ico near").click();
        IOSElement buscaAgencia = driver.findElementByName("Busque por cidade, estado ou endereço");
        buscaAgencia.click();
        buscaAgencia.sendKeys("Nova Igua");
        driver.findElementByAccessibilityId("4509 - Unicred Serra Mar").click();
        driver.findElementByAccessibilityId("VER NO MAPA").click();
        driver.findElementByAccessibilityId("Local").click();
        Assert.assertTrue(driver.findElementByName("4509 - Unicred Serra Mar").isDisplayed());
    }

    @Test
    public void ValidarPaginaTelefones()
    {
        driver.findElementByAccessibilityId("ico phone").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Dúvidas ou sugestões").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Suporte Técnico").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Ouvidoria Unicred").isDisplayed());
    }

    @Test(enabled = false)
    public void ValidarAcessoComSegundaContaFavoritosTODO()
    {

        //Login com Julia
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

        //Logout
        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();

        //Login com outra conta Olga
        driver.findElementByAccessibilityId("Acessar outra conta").click();
        driver.findElementByXPath("//XCUIElementTypeButton[@name=\"ACESSAR OUTRA CONTA\"]").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("olga");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("515");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("75825");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        driver.findElementByName("CONTINUAR").click();

        //Logout
        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();

        driver.findElementByAccessibilityId("Acessar outra conta").click();
        driver.findElementByAccessibilityId("julia").click();
        driver.findElementByClassName("XCUIElementTypeSecureTextField").sendKeys("1122");
        driver.findElementByName("CONTINUAR").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred.Home_v").isDisplayed());
    }

    @Test(enabled = false)
    public void Logout()
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
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElementByName("CONTINUAR").click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        driver.findElementByName("menu").click();
        driver.findElementByName("logout").click();
        driver.findElementByName("Sair").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("iphone-logo").isDisplayed());
    }

    @Test(enabled = false)
    public void AcessarAgenciaBuscada()
    {
        driver.findElementByAccessibilityId("ico near").click();
        IOSElement buscaAgencia = driver.findElementByName("Busque por cidade, estado ou endereço");
        buscaAgencia.click();
        buscaAgencia.sendKeys("Nova Igua");
        driver.findElementByAccessibilityId("4509 - Unicred Serra Mar").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Unicred Serra Mar").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("VER NO MAPA").isDisplayed());
    }

}
