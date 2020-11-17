package com.zebrunner;

import com.zebrunner.agent.core.annotation.JiraReference;
import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.annotation.Priority;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.registrar.Label;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Maintainer("admin")
@Priority(Priority.P2)
@TestLabel(name = "class-level-name", value = "class-level-value")
public class DummyServiceTest {

    @Test(testName = "Test #1")
    @Priority(Priority.P1)
    public void firstTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test()
    @Maintainer("anonymous")
    @TestLabel(name = "stability", value = "poor")
    public void secondTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test()
    @JiraReference("SPG-0001") // or XRay, or TestRail, or QTest or all at once
    public void thirdTest() {
        Label.attach("new-label", "new-value");
        assertTrue(Boolean.TRUE);
    }

}
