# Generated Project Skeleton

A simple operator that copies the value in a spec to a ConfigMap.

Moreover, several Go projects aim to make the Operator writing process easy:

- `operator-sdk` and its command line tool help developers get started faster
- `client-go` facilitates programmatic interactions with the Kubernetes API server
- `apimachinery` and `controller-runtime` offer useful utilities and patterns

## Operator

Remember that an Operator is the combination of an API/DSL (domain-specific language), represented by CRs and their associated custom resource definitions (CRDs), and a controller capable of handling that DSL to perform the required actions to materialize the desired state as described by the CR.

One thing to be aware of is that JOSDK relies on the Fabric8 Kubernetes client in the same way that the Go `controller-runtime` project relies on `client-go`.

## Explained Configuration

CustomResource class. This class enforces the good practice of separating the state of the `CR` into two fields: `spec` and `status`. The spec field represents the desired state that the user wants to apply to the cluster.
The status field, on the other hand, represents the information that the controller associated to the CR wants to surface to the user (or other controllers).

The `CRD` is how the Kubernetes API learns what to expect from your newly added API.

### Namespaced or cluster-scoped

The Fabric8 Kubernetes client uses a marker interface io.fabric8.kubernetes.api.model.Namespaced for that purpose. Classes implementing this interface will be namespace-scoped, while other classes will be marked as cluster-scoped.

The @ControllerConfiguration annotation, which allows you to configure which namespaces your reconciler will watch, among other features. You can use the option by setting the namespaces field of the annotation to a list of comma-separated namespace names.

```java
@ControllerConfiguration(namespaces = Constants.WATCH_CURRENT_NAMESPACE, name = "exposedapp")
public class ExposedAppReconciler implements Reconciler<ExposedApp> {
// rest of the code here
}
```

## Installation

```bash
mvn io.javaoperatorsdk:bootstrapper:[version]:create -DprojectGroupId=org.acme -DprojectArtifactId=getting-started
```

## Start the Operator

```bash
mvn exec:java -Dexec.mainClass="org.acme.Runner"
```
