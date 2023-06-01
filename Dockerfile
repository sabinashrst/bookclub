FROM maven:3.9.0-eclipse-temurin-17-alpine AS build

COPY --from=build /target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]