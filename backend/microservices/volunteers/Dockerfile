# Usa a imagem oficial do Maven para compilar o código

FROM maven:3.8.1-openjdk-17 AS build

LABEL authors="alysson"
WORKDIR /app


COPY . .


RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "app.jar"]
