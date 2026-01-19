# ---------- Build ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -B dependency:resolve
COPY src ./src
RUN mvn -B clean package -DskipTests

# ---------- Runtime ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

# Install curl for healthcheck
RUN apt-get update && apt-get install -y curl && rm -rf /var/lib/apt/lists/*

# Copy the built jar
COPY --from=build /app/target/*.jar app.jar

# Expose the port used by Spring Boot
EXPOSE 8080

# Optional: Set a default timezone (helps with logs in Kibana)
ENV TZ=UTC

# Optional: Pass Java opts (if you want to configure memory)
ENV JAVA_OPTS="-Xms256m -Xmx512m"

# Entry point
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
