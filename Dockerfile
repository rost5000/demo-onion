FROM openjdk:17-jdk-alpine

WORKDIR /home/application

COPY /modules/infrastructure/build/libs/infrastructure*.jar aplication.jar

ENTRYPOINT ["java", "-jar", "aplication.jar"]