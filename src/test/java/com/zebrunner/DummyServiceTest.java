package com.zebrunner;

import com.zebrunner.agent.core.registrar.Artifact;
import com.zebrunner.agent.core.registrar.ArtifactReference;
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
        Artifact.upload(FileUtils.DOC, "document.docx");

        waitHooks();
        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void secondTest() throws IOException {
        log.info("Info log");
        Screenshot.upload(Files.readAllBytes(FileUtils.IMAGES[1].toPath()), System.currentTimeMillis());
        log.warn("Warn log");
        ArtifactReference.attach("google.com", "https://www.google.com/");

        waitHooks();

        assertTrue(Boolean.TRUE);
    }

    @Test()
    public void thirdTest() {
        waitHooks();
        Artifact.upload(FileUtils.DOC, "another-document.docx");
        ArtifactReference.attach("zebrunner.com", "https://zebrunner.com/");
        ArtifactReference.attach("youtube.com", "https://www.youtube.com/");
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
