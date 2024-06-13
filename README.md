# Generated Project Skeleton

A simple operator that copies the value in a spec to a ConfigMap.

## Explained Configuration

CustomResource class. This class enforces the good practice of separating the state of the CR into two fields: spec and status. The spec field represents the desired state that the user wants to apply to the cluster.
The status field, on the other hand, represents the information that the controller associated to the CR wants to surface to the user (or other controllers).

### Namespaced or cluster-scoped

The Fabric8 Kubernetes client uses a marker interface io.fabric8.kubernetes.api.model.Namespaced for that purpose. Classes implementing this interface will be namespace-scoped, while other classes will be marked as cluster-scoped.
