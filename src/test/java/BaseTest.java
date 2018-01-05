import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest{

    static IOSDriver<IOSElement>driver;

    @Test
    public void Unicred(){
        driver.findElementByName("ACESSE SUA CONTA").click();

        driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("julia");

        driver.findElementByName("CONTINUAR").click();

        driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("515");

        driver.findElementByName("CONTINUAR").click();

        driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextField").sendKeys("938564");

        driver.findElementByName("CONTINUAR").click();

        driver.findElementByXPath("/XCUIElementTypeApplication/XCUIElementTypeWindow/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeSecureTextField").sendKeys("1122");

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
            cap.setCapability(MobileCapabilityType.APP, "/Users/device/Unicred_novo.app");
            cap.setCapability(MobileCapabilityType.FULL_RESET, false);
            cap.setCapability(MobileCapabilityType.NO_RESET, true);
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
