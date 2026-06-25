FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /workspace

COPY gradlew settings.gradle build.gradle ./
COPY gradle ./gradle
COPY src ./src

RUN chmod +x ./gradlew && ./gradlew bootJar -x test --no-daemon

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

ENV FILE_UPLOAD_DIR=/tmp/jeju/uploads/

RUN mkdir -p /tmp/jeju/uploads

COPY --from=build /workspace/build/libs/*.jar /app/app.jar

EXPOSE 8101

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
