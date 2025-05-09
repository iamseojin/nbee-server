# ───── 1단계: 빌드 (Gradle Wrapper 내부)
FROM gradle:8.5-jdk21 AS builder
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle bootJar -x test

# ───── 2단계: 실행 환경 (경량 JRE)
FROM eclipse-temurin:21-jre

ARG JAR_FILE=/home/gradle/src/build/libs/*.jar
COPY --from=builder ${JAR_FILE} app.jar

ENV TZ=Asia/Seoul
EXPOSE 7070
ENTRYPOINT ["java","-jar","/app.jar"]