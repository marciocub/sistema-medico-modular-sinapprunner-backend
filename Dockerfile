# Multi-stage build for Spring Boot backend
FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy parent pom and module poms
COPY pom.xml .
COPY modulo-seguridad/pom.xml modulo-seguridad/
COPY modulo-pacientes/pom.xml modulo-pacientes/
COPY modulo-profesionales/pom.xml modulo-profesionales/
COPY modulo-turnos/pom.xml modulo-turnos/
COPY app-runner/pom.xml app-runner/

# Download dependencies
RUN mvn dependency:go-offline -B

# Copy source code
COPY modulo-seguridad/src modulo-seguridad/src
COPY modulo-pacientes/src modulo-pacientes/src
COPY modulo-profesionales/src modulo-profesionales/src
COPY modulo-turnos/src modulo-turnos/src
COPY app-runner/src app-runner/src

# Build the project
RUN mvn clean package -DskipTests -B

# Runtime stage
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the built jar
COPY --from=builder /app/app-runner/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Environment variables with defaults
ENV DB_HOST=mysql
ENV DB_PORT=3311
ENV DB_NAME=sistema_turnos
ENV DB_USER=root
ENV DB_PASSWORD=root
ENV JWT_SECRET=cambiame-en-produccion-minimo-256-bits-para-hs256-algoritmo

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
