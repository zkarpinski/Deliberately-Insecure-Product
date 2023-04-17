# syntax=docker/dockerfile:1
# reference: https://docs.docker.com/language/java/build-images/
FROM eclipse-temurin:11-alpine

# Create the app working directory
WORKDIR /app

COPY build/docker/layers/application.jar ./app.jar
COPY build/docker/layers/resources ./resources
COPY build/docker/layers/libs ./libs
EXPOSE 8080

CMD ["java", "-jar", "app.jar"]