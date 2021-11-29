FROM openjdk:16-jdk-slim
MAINTAINER fbvarnier
COPY target/*.jar sigo-normas.jar
ENTRYPOINT ["java", "-jar", "/sigo-normas.jar"]