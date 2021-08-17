package com.zebrunner.web.e02;

import com.zebrunner.agent.core.registrar.TestSessionRegistrar;
import com.zebrunner.agent.core.registrar.descriptor.SessionCloseDescriptor;
import com.zebrunner.agent.core.registrar.descriptor.SessionStartDescriptor;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;

public class CustomTestSession {

    private static final Logger log = LoggerFactory.getLogger(CustomTestSession.class);

    @Test
    public void myFirstWebTest() {
        log.info("start test");
        Map<String, Object> caps = Map.of("platform", "xbox");
        String sessionId = UUID.randomUUID().toString();

        SessionStartDescriptor descriptor = SessionStartDescriptor.initiatedWith(caps);
        descriptor.successfullyStartedWith(sessionId, caps);
        TestSessionRegistrar.getInstance().registerStart(descriptor);

        TestSessionRegistrar.getInstance().registerClose(SessionCloseDescriptor.of(sessionId));

        log.info("end test");
    }

}
