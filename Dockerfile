FROM openjdk:8-jdk-alpine
COPY build/libs/halykRestApi-1.0-SNAPSHOT.jar /halykRestApi-1.0-SNAPSHOT.jar
CMD ["java", "-jar", "halykRestApi-1.0-SNAPSHOT.jar"]