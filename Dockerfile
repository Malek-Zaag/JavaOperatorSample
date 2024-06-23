FROM adoptopenjdk/openjdk11:latest

RUN mkdir -p build

COPY ./src src

USER root

COPY *target/**.jar /build/target/app.jar 

RUN --mount=type=bind,source=pom.xml,target=pom.xml     

WORKDIR /app

COPY --chown=root:root */build/target/app.jar ./app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]
