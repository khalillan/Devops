
FROM openjdk:11
EXPOSE 8092
ADD target/*.jar achat.jar
ENTRYPOINT ["java","-jar","achat.jar"]