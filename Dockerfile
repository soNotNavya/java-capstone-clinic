# Stage 1: Build with Maven
FROM maven:3.8.6-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the JAR
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/your-app-name.jar app.jar  # Replace with your actual JAR name

# Expose the port your app uses (e.g., 4567 for SparkJava, 8080 for Jetty)
EXPOSE 8080

# Entrypoint to run your app
ENTRYPOINT ["java", "-jar", "app.jar"]
