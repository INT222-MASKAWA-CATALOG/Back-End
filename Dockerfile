FROM maven:3.8.1-jdk-11-slim AS build
COPY src /Back-End/src
COPY pom.xml /Back-End
WORKDIR /Back-End 

FROM openjdk:11.0-slim
VOLUME /tmp
EXPOSE 3000
ARG JAR_FILE=target/Maskawa.Catalog-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]