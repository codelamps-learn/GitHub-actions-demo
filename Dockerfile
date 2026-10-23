# ---- Stage 1: Build jar pakai Maven ----
FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copy pom.xml dulu agar layer dependency bisa di-cache terpisah dari source code
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Baru copy source code, lalu build
COPY src ./src
RUN mvn clean package -DskipTests -B

# ---- Stage 2: Image runtime yang ramping ----
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Ambil HANYA jar hasil build dari stage sebelumnya — image JDK+Maven tidak ikut terbawa
COPY --from=build /app/target/demo-calculator.jar app.jar

# Jalankan sebagai non-root user demi keamanan
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

ENTRYPOINT ["java", "-jar", "app.jar"]