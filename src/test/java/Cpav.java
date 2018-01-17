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

        //driver.findElementByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[2]").click();

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
}
