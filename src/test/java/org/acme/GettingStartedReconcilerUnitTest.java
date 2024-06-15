package org.acme;

import org.apache.logging.slf4j.Log4jLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.javaoperatorsdk.operator.junit.LocallyRunOperatorExtension;

public class GettingStartedReconcilerUnitTest {

    private static final Logger logger = LoggerFactory.getLogger(GettingStartedReconcilerUnitTest.class);
    @RegisterExtension
    LocallyRunOperatorExtension operator = LocallyRunOperatorExtension.builder()
            .withReconciler(GettingStartedReconciler.class)
            .build();

    @Test
    public void test1() {
        logger.info("first test is working fine!");
    }

    @Test
    public void test2() {
        logger.info("second test is working fine!");
    }

}
