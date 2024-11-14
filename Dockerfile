# Stage 1: Build the application
FROM maven:3.9.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml ./
RUN mvn dependency:go-offline

# Stage 2: Copy the rest of the application code and build the project
COPY . .
RUN mvn clean package -DskipTests

# Stage 3: Create the runtime image
FROM openjdk:17-jdk-alpine
WORKDIR /app

COPY --from=build /app/target/Delicious_Dairy-0.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

