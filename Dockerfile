# Build Stage
#FROM maven:3.8.5-openjdk-17 AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src ./src
#RUN mvn clean package

# Run Stage
#FROM openjdk:17.0.1-jdk-slim
#WORKDIR /app
#COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar demo.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "demo.jar"]





# FROM maven:3.8.3-openjdk-17 AS build
# COPY . .
# RUN mvn clean package -DskipTests

# FROM openjdk:17.0.1-jdk-slim
# COPY --from=build /target/demo-0.0.1-SNAPSHOT.jar demo.jar
# EXPOSE 8080
# ENTRYPOINT [ "java","-jar","demo.jar" ]








# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the application JAR file (assuming it’s located in the target directory)
COPY target/your-application-name.jar app.jar

# Expose the port the app runs on (update if needed)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
