FROM eclipse-temurin:21-jdk-jammy AS build

WORKDIR /workspace

COPY jeju/gradlew jeju/settings.gradle jeju/build.gradle ./
COPY jeju/gradle ./gradle
COPY jeju/src ./src
COPY community_page ./src/main/resources/static/community_page
COPY culture_page ./src/main/resources/static/culture_page
COPY festival_page ./src/main/resources/static/festival_page
COPY tour_guide ./src/main/resources/static/tour_guide
COPY tour_page ./src/main/resources/static/tour_page
COPY user_page ./src/main/resources/static/user_page
COPY style_guide.html sub_page.html ./src/main/resources/static/

RUN chmod +x ./gradlew && ./gradlew bootJar -x test --no-daemon

FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

ENV FILE_UPLOAD_DIR=/tmp/jeju/uploads/

RUN mkdir -p /tmp/jeju/uploads

COPY --from=build /workspace/build/libs/*.jar /app/app.jar

EXPOSE 8101

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
