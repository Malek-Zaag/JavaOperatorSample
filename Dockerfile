FROM openjdk:24

COPY target/ /tmp

WORKDIR /tmp

ENTRYPOINT ["java","-jar","/tmp/getting-started-0.1.0-SNAPSHOT-jar-with-dependencies.jar"]