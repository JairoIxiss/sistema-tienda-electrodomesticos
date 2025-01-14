FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/config-server-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_configserver.jar
EXPOSE 8888
ENTRYPOINT ["java", "-jar", "app_configserver.jar"]