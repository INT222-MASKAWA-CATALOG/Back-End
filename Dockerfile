FROM openjdk:11.0-slim
VOLUME /tmp
EXPOSE 3000
ARG JAR_FILE=target/Maskawa.Catalog-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]