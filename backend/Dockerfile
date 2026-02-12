FROM maven:3.9.4-eclipse-temurin-21-alpine AS build

WORKDIR /app
COPY src ./src
COPY pom.xml .
RUN mvn clean install -DskipTest

###

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app
COPY --from=build /app/target/*.jar ./app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]