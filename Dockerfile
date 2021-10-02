FROM maven:3.8.1-jdk-11-slim AS build
COPY src /Back-End/src/
COPY pom.xml /Back-End
WORKDIR /Back-End 
RUN mvn clean package

FROM openjdk:11.0-slim
VOLUME /tmp
EXPOSE 3000
ARG JAR_FILE=target/Maskawa-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]