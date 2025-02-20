FROM openjdk:21-jdk-slim
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.javarush_community_bot
ENV BOT_TOKEN=1375780501:AAE4A6Rz0BSnIGzeu896OjQnjzsMEG6_uso
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]