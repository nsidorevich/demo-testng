package com.zebrunner.dummy.e05;

import com.zebrunner.FileUtils;
import com.zebrunner.Hooks;
import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.Screenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

import static org.testng.Assert.assertTrue;

/**
 * Working with references and binary artifact uploads.
 * Attaching those to both test and test run
 */
public class TestWithAttachments {

    private static final Logger log = LoggerFactory.getLogger(TestWithAttachments.class);

    @BeforeClass
    public void before() {
        Artifact.attachToTestRun("document.docx", FileUtils.DOC);
        Artifact.attachReferenceToTestRun("google.com", "https://www.google.com/");
    }

    @Test(testName = "Test #1")
    public void firstTest() throws IOException {

        log.info("Doing things: complex assertions, you know...");

        Screenshot.upload(Files.readAllBytes(FileUtils.IMAGES[0].toPath()), System.currentTimeMillis());
        Artifact.attachToTest("document.docx", FileUtils.DOC);

        Hooks.waitForCompletion();
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void secondTest() throws IOException {
        log.info("Info log");
        Screenshot.upload(Files.readAllBytes(FileUtils.IMAGES[1].toPath()), System.currentTimeMillis());
        log.warn("Warn log");
        Artifact.attachReferenceToTest("google.com", "https://www.google.com/");

        Hooks.waitForCompletion();
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void thirdTest() {
        Hooks.waitForCompletion();
        Artifact.attachToTest("another-document.docx", FileUtils.DOC);
        Artifact.attachReferenceToTest("zebrunner.com", "https://zebrunner.com/");
        Artifact.attachReferenceToTest("youtube.com", "https://www.youtube.com/");

        Hooks.waitForCompletion();
        assertTrue(Boolean.FALSE);
    }

}
