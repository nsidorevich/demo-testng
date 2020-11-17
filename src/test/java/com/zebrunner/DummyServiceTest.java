package com.zebrunner;

import com.zebrunner.agent.core.registrar.Screenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.testng.Assert.assertTrue;

public class DummyServiceTest {

    private static final Logger log = LoggerFactory.getLogger(DummyServiceTest.class);

    @Test(testName = "Test #1")
    public void firstTest() throws IOException {
        log.info("Doing things: complex assertions, you know...");

        Screenshot.upload(Files.readAllBytes(FileUtils.IMAGES[0].toPath()), System.currentTimeMillis());

        waitHooks();
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void secondTest() throws IOException {
        log.info("Info log");
        Screenshot.upload(Files.readAllBytes(FileUtils.IMAGES[1].toPath()), System.currentTimeMillis());
        log.warn("Warn log");

        waitHooks();

        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void thirdTest() {
        waitHooks();
        assertTrue(Boolean.FALSE);
    }

    private void waitHooks() {
        try {
            Thread.sleep(1000); // workaround for shutdown hooks issue
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
