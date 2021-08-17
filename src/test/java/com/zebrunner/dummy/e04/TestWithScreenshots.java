package com.zebrunner.dummy.e04;

import com.zebrunner.FileUtils;
import com.zebrunner.Hooks;
import com.zebrunner.agent.core.registrar.Screenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.testng.Assert.assertTrue;

/**
 * Screenshot API allowing to attach screenshot to test execution in Zebrunner
 */
public class TestWithScreenshots {

    private static final Logger log = LoggerFactory.getLogger(TestWithScreenshots.class);

    @Test(testName = "Test #1")
    public void firstTest() throws IOException {
        log.info("Doing things: complex assertions, you know...");

        Screenshot.upload(Files.readAllBytes(FileUtils.IMAGES[0].toPath()), System.currentTimeMillis());

        Hooks.waitForCompletion();
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void secondTest() throws IOException {
        log.info("Info log");
        Screenshot.upload(Files.readAllBytes(FileUtils.IMAGES[1].toPath()), System.currentTimeMillis());
        log.warn("Warn log");

        Hooks.waitForCompletion();

        assertTrue(Boolean.TRUE);
    }

}
