FROM maven:3.9.10-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY pom.xml .

COPY src/ src/

RUN mvn clean package



FROM eclipse-temurin:21.0.7_6-jre-ubi9-minimal

WORKDIR /app

COPY --from=build /app/target/*.jar tcf5-auth-server.jar

ENTRYPOINT ["java", "-jar", "/app/tcf5-auth-server.jar"]