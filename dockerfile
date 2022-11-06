FROM openjdk:8-jdk-alpine
EXPOSE 8089
COPY target achat.jar
ENTRYPOINT ["java","-jar","docker-1.0.jar"]