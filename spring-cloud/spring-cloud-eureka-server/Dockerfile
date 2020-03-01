FROM openjdk:8-jre

MAINTAINER fangxi fangxi.inori@gmail.com

ENV APP_VERSION 0.0.1-SNAPSHOT

RUN mkdir /app

COPY spring-cloud-eureka-server-$APP_VERSION.jar /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]

EXPOSE 8761
