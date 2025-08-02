# ─────── Stage 1: Build using Maven and JDK 21 ───────
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the JAR (skip tests to speed up CI/CD)
RUN mvn clean package -DskipTests

# ─────── Stage 2: Run with lightweight Java 21 JRE ───────
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy only the JAR from the build stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the port your app runs on (default 8080 or your custom)
EXPOSE 8091

# Start the application
ENTRYPOINT ["java", "-jar", "app.jar"]
