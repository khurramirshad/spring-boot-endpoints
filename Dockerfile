# Start from an OpenJDK base image
FROM eclipse-temurin:17-jdk-alpine
EXPOSE 80
#ADD /target/spring-boot-journal.jar spring-boot-journal.jar
COPY /target/Solance.jar Solance.jar


# Run the jar file
ENTRYPOINT ["java", "-jar", "/Solance.jar"]