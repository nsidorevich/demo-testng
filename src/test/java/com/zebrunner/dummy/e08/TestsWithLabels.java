package com.zebrunner.dummy.e08;

import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.annotation.Priority;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.agent.core.registrar.Label;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Tests with labels and different ways to attach those
 * Grouping by labels
 * Special labels
 */
@Maintainer("admin")
@Priority(Priority.P2)
@TestLabel(name = "class-level-name", value = "class-level-value")
public class TestsWithLabels {

    @Test(testName = "Test #1")
    @Priority(Priority.P1)
    @TestLabel(name = "feature", value = "Authorization")
    public void firstTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test()
    @Maintainer("anonymous")
    @TestLabel(name = "stability", value = "low")
    @TestLabel(name = "feature", value = "Authorization")
    public void secondTest() {
        assertTrue(Boolean.TRUE);
    }

    @Test()
    @TestLabel(name = "feature", value = "Authorization")
    @TestLabel(name = "com.zebrunner.app/tcm.testrail.testcase-id", value = "39058") // or XRay, or TestRail, or QTest or all at once
    @TestLabel(name = "com.zebrunner.app/tcm.testrail.testcase-id", value = "39059") // or XRay, or TestRail, or QTest or all at once
    @TestLabel(name = "com.zebrunner.app/tcm.testrail.testcase-id", value = "39090") // or XRay, or TestRail, or QTest or all at once
    public void thirdTest() {
        Label.attachToTest("new-label", "new-value");
        assertTrue(Boolean.TRUE);
    }

}
