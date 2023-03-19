FROM amazoncorretto:11-alpine-jdk
MAINTAINER Fede
COPY target/proyecto-0.0.1-SNAPSHOT.jar  projecto.jar
ENTRYPOINT ["java","-jar","projecto.jar"]
