# Generated Project Skeleton

A simple operator that copies the value in a spec to a ConfigMap.

Moreover, several Go projects aim to make the Operator writing process easy:

- `operator-sdk` and its command line tool help developers get started faster
- `client-go` facilitates programmatic interactions with the Kubernetes API server
- `apimachinery` and `controller-runtime` offer useful utilities and patterns

## Installation

```bash
mvn io.javaoperatorsdk:bootstrapper:[version]:create -DprojectGroupId=org.acme -DprojectArtifactId=getting-started
```

## Start the Operator

```bash
mvn exec:java -Dexec.mainClass="org.acme.Runner"
```
