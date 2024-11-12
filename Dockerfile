# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/your-application-name.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

