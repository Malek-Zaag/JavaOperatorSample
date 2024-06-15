package org.acme;

import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ObjectMetaBuilder;
import io.javaoperatorsdk.operator.junit.LocallyRunOperatorExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.concurrent.TimeUnit.MINUTES;
import static org.acme.ConfigMapDependentResource.KEY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

class GettingStartedReconcilerIT {

    public static final String RESOURCE_NAME = "test1";
    public static final String INITIAL_VALUE = "initial value";
    public static final String CHANGED_VALUE = "changed value";
    private static final Logger logger = LoggerFactory.getLogger(GettingStartedReconcilerIT.class);

    @RegisterExtension
    LocallyRunOperatorExtension extension = LocallyRunOperatorExtension.builder()
            .withReconciler(new GettingStartedReconciler(), n -> n.settingNamespace("default"))
            .build();

    @Test
    void testCRUDOperations() {
        var cr = this.testResource(extension);
        assertThat(extension).isNotNull();
        logger.info("Integration test is running");
        await()
                .atMost(1, MINUTES)
                .untilAsserted(() -> {
                    var cm = extension.get(ConfigMap.class, RESOURCE_NAME);
                    assertThat(cm).isNotNull();
                    assertThat(cm.getData()).containsEntry(KEY, INITIAL_VALUE);
                });

        cr.getSpec().setKey1(CHANGED_VALUE);
        cr = extension.replace(cr);

        await()
                .atMost(1, MINUTES)
                .untilAsserted(() -> {
                    var cm = extension.get(ConfigMap.class, RESOURCE_NAME);
                    assertThat(cm.getData()).containsEntry(KEY, "CHANGED_VALUE");
                });

        extension.delete(cr);

        await()
                .atMost(1, MINUTES)
                .untilAsserted(() -> {
                    var cm = extension.get(ConfigMap.class, RESOURCE_NAME);
                    assertThat(cm).isNull();
                });
    }

    GettingStartedCustomResource testResource(LocallyRunOperatorExtension extension) {
        var resource = new GettingStartedCustomResource();
        resource.setMetadata(new ObjectMetaBuilder()
                .withName(RESOURCE_NAME)
                .withNamespace(extension.getNamespace())
                .build());
        resource.setSpec(new GettingStartedSpec());
        resource.getSpec().setKey1(INITIAL_VALUE);
        return resource;
    }
}
