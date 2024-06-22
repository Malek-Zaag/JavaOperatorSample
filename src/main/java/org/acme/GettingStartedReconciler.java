package org.acme;

import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.dependent.Dependent;

// This is the actual operator logic, it is called the "reconciler"
// The @ControllerConfiguration annotation, which allows you to configure which namespaces your reconciler will watch, 
// among other features. 
// You can use the option by setting the namespaces field of the annotation to a list of comma-separated namespace names.
@ControllerConfiguration(namespaces = "default", dependents = { @Dependent(type = ConfigMapDependentResource.class) })
public class GettingStartedReconciler implements Reconciler<GettingStartedCustomResource> {

    public UpdateControl<GettingStartedCustomResource> reconcile(GettingStartedCustomResource primary,
            Context<GettingStartedCustomResource> context) throws Exception {
        return UpdateControl.updateStatus(primary);
    }
}
