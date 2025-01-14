FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/api-gateway-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_apigateway.jar
EXPOSE 444
ENTRYPOINT ["java", "-jar", "app_apigateway.jar"]