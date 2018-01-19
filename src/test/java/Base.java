import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Base {

    static IOSDriver<IOSElement>driver;

    @BeforeMethod
    public void beforeTest()
    {
        driver.launchApp();
        //driver.findElementByAccessibilityId("http://dcavm062hm024.e-unicred.com.br:8080/unicred-controller/unicred/controller/service").click();
    }

    @AfterMethod
    public void afterTest()
    {
        driver.closeApp();
    }

    @Parameters({ "deviceName_", "wdaLocalPort_", "deviceId_", "URL_" })
    @BeforeClass
    public void before(String deviceName_, String wdaLocalPort_, String deviceId_, String URL_) throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();

        //Real devices capabilities
        if(deviceName_.toLowerCase().contains("unicred")) {
            cap.setCapability("apiKey", "60fddf8c-81e3-4391-af9f-1dcc6eb7b439");
            cap.setCapability("deviceId", deviceId_);
            cap.setCapability("executionName", "Unicred - iOS");

            //cap.setCapability(MobileCapabilityType.APP, "http://app.crashken.com/UICatalog.ipa");
            cap.setCapability(MobileCapabilityType.APP, "https://crashken.blob.core.windows.net/crashken-5a3427da3183d01952159254/public/apps/5a3427da3183d01952159254/5a3427da3183d01952159255/eea4777c-29b7-4d15-96eb-243a44c7ebcd.ipa");
        }
        //Simulators capabilities
        else {
            cap.setCapability(MobileCapabilityType.UDID, deviceId_);
            cap.setCapability(MobileCapabilityType.APP, "/Users/device/Unicred.app");
            //cap.setCapability(MobileCapabilityType.FULL_RESET, false);
            //cap.setCapability(MobileCapabilityType.NO_RESET, true);
            cap.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, wdaLocalPort_);
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName_);
            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
            cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        }
        //Both capabilities
        //cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName_);
        //cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        //cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, 10.3);
        //cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
        driver = new IOSDriver<>(new URL(URL_),cap);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @AfterClass
    public void after() {
        driver.quit();
    }
}
