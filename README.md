<p align="center">
  <a href="" rel="noopener">
 <img width=200px height=200px src="https://i.imgur.com/6wj0hh6.jpg" alt="Project logo"></a>
</p>

<h3 align="center">Getting Started Operator</h3>

<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

---

<p align="center"> Getting started with Java Kubernetes Operators.
    <br> 
</p>

## 🧐 About <a name = "about"></a>

Java-Operator-Sample is a Kubernetes operator written in Java that automates the management of ConfigMaps. This operator monitors Custom Resources (CR) and dynamically updates a ConfigMap with data specified in the CR. By leveraging the Kubernetes API, Java-Operator-Sample ensures that your configuration data is always in sync, simplifying the management of application configurations within your Kubernetes cluster.

Moreover, several Go projects aim to make the Operator writing process easy:

- `operator-sdk` and its command line tool help developers get started faster
- `client-go` facilitates programmatic interactions with the Kubernetes API server
- `apimachinery` and `controller-runtime` offer useful utilities and patterns

## 🏁 Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See [deployment](#deployment) for notes on how to deploy the project on a live system.

### Prerequisites

- Kubectl Version: v1.29.1
- Kind Version 0.22.0
- Docker Version 25.0.3
- Helm v3.15.2
- Go Version go1.22.4

### Installing

bootstrap the project :

```bash
mvn io.javaoperatorsdk:bootstrapper:[version]:create -DprojectGroupId=org.acme -DprojectArtifactId=getting-started
```

start the operator in your local cluster:

```bash
mvn exec:java -Dexec.mainClass="org.acme.Runner"
```

## 🔧 Running the tests <a name = "tests"></a>

For the automated tests, we implemented some unit tests just for the sake of example:

```bash
mvn test
```

### Break down into end to end tests

You can run this integration test to verify that your operator meets the requirements:

```
mvn verify
```

## 🎈 Usage <a name="usage"></a>

Add notes about how to use the system.

## 🚀 Deployment <a name = "deployment"></a>

Add additional notes about how to deploy this on a live system.

## ⛏️ Built Using <a name = "built_using"></a>

<!--
- [MongoDB](https://www.mongodb.com/) - Database
- [Express](https://expressjs.com/) - Server Framework
- [VueJs](https://vuejs.org/) - Web Framework
- [NodeJs](https://nodejs.org/en/) - Server Environment -->

## ✍️ Authors <a name = "authors"></a>

- [@Malek-Zaag](https://github.com/Malek-Zaag) - Idea & Initial work

The project was an extension of [java-opertar-sdk](https://github.com/operator-framework/java-operator-sdk).

## 🎉 Acknowledgements <a name = "acknowledgement"></a>

- Hat tip to anyone whose code was used
- Inspiration
- References
