package com.zebrunner.web.e01;

import com.zebrunner.agent.core.registrar.Screenshot;
import com.zebrunner.agent.core.registrar.TestSessionRegistrar;
import com.zebrunner.agent.core.registrar.descriptor.SessionStartDescriptor;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class FirstWebTest {

    private static final Logger log = LoggerFactory.getLogger(FirstWebTest.class);

    public static RemoteWebDriver getDriver(String sessionName) throws MalformedURLException {
        ChromeOptions capabilities = new ChromeOptions();

        capabilities.addArguments("['start-maximized']");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        capabilities.setCapability("enableMetadata", true);
        capabilities.setCapability("enableLog", true);
        capabilities.setCapability("sessionName", sessionName);

        RemoteWebDriver driver = new RemoteWebDriver(new URL("https://qps:8SuVe6gDUGUd0bbm@hub.zebrunner.com/wd/hub"), capabilities);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        return driver;
    }

    public static void doSomeDriverWork(RemoteWebDriver driver) {
        driver.get("https://www.freecrm.com/index.html");
        String title = driver.getTitle();
        takeScreenshot(driver);


        assertEquals("Free CRM software in the cloud powers sales and customer serviceQQQQ", title);
    }

    @Test
    public void myFirstWebTest() throws MalformedURLException {
        log.info("start test");
        Map<String, Object> caps = Map.of("platform", "xbox");
        SessionStartDescriptor descriptor = SessionStartDescriptor
                .initiatedWith(caps);
        descriptor.successfullyStartedWith(UUID.randomUUID().toString(), caps);
        TestSessionRegistrar.getInstance().registerStart(descriptor);
        RemoteWebDriver driver = getDriver("FreeCrmTest#driver_FreeCrmPageTest()");
        doSomeDriverWork(driver);
        log.info("end test");
    }


    public static void takeScreenshot(RemoteWebDriver driver) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Screenshot.upload(new FileInputStream(screenshot).readAllBytes(), System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
