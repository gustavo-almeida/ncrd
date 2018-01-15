import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest{

    static IOSDriver<IOSElement>driver;


    @Test
    public void ValidarAcessoComDadosCorretos(){
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
    public void ValidarAcessoComDadosIncorretos(){
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
    public void ValidarAcessoComFavoritos(){

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
    public void ValidarAcessoSemFavoritos(){

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
    public void ValidarAcessoSemSalvarDados(){

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
    public void ValidarAcessoComSegundaContaFavoritosTODO(){

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


    @Test
    public void Logout(){
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

    @Test
    public void ValidarPaginaTelefones(){
        driver.findElementByAccessibilityId("ico phone").click();
        Assert.assertTrue(driver.findElementByAccessibilityId("Dúvidas ou sugestões").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Suporte Técnico").isDisplayed());
        Assert.assertTrue(driver.findElementByAccessibilityId("Ouvidoria Unicred").isDisplayed());
    }

    @Test
    public void ValidarAgenciasProximas()
    {
        driver.findElementByAccessibilityId("ico near").click();
        Assert.assertTrue(driver.findElementByName("Agências").isDisplayed());
    }

    @Test
    public void BuscarAgencia()
    {
        driver.findElementByAccessibilityId("ico near").click();
        IOSElement buscaAgencia = driver.findElementByName("Busque por cidade, estado ou endereço");
        buscaAgencia.click();
        buscaAgencia.sendKeys("Nova Igua");
        Assert.assertTrue(driver.findElementByAccessibilityId("4509 - Unicred Serra Mar").isDisplayed());
    }

    @Test
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

    @BeforeMethod
    public void beforeTest()
    {
        driver.launchApp();
    }

    @AfterMethod
    public void afterTest()
    {
        driver.closeApp();
    }

    @Parameters({ "deviceName_", "platformName_", "deviceId_", "URL_" })
    @BeforeClass
    public void before(String deviceName_, String platformName_,String deviceId_, String URL_) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        if(!"959C979D-C43A-4845-B3B9-D54D999D7D20".equals(deviceId_)) {
            cap.setCapability("apiKey", "60fddf8c-81e3-4391-af9f-1dcc6eb7b439");
            cap.setCapability("deviceId", deviceId_);
            cap.setCapability("executionName", "Unicred - iOS");

            //cap.setCapability(MobileCapabilityType.APP, "http://app.crashken.com/UICatalog.ipa");
            cap.setCapability(MobileCapabilityType.APP, "https://crashken.blob.core.windows.net/crashken-5a3427da3183d01952159254/public/apps/5a3427da3183d01952159254/5a3427da3183d01952159255/682cc8ed-147d-48ce-b1d8-9b6d5f1a10c8.ipa");
        }
        else {
            cap.setCapability(MobileCapabilityType.UDID, deviceId_);
            cap.setCapability(MobileCapabilityType.APP, "/Users/device/Unicred.app");
            //cap.setCapability(MobileCapabilityType.FULL_RESET, false);
            //cap.setCapability(MobileCapabilityType.NO_RESET, true);
        }
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName_);
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName_);
        //cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, 10.3);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        driver = new IOSDriver<>(new URL(URL_),cap);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterClass
    public void after() {
        driver.quit();
    }

}
