FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8082
WORKDIR /opt/app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]