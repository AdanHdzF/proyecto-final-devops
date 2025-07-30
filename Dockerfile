FROM maven:3.9-eclipse-temurin-17-alpine AS build

WORKDIR /src

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src ./src

RUN mvn package

##########################################################################

FROM eclipse-temurin:17-jre-alpine

COPY --from=build /src/target/*.jar /app/app.jar

EXPOSE 7000

CMD ["java", "-jar", "app.jar"]