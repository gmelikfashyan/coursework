FROM eclipse-temurin:21-jdk-alpine
VOLUME [ "/tmp" ]
RUN cp -a /build/libs/demo-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT [ "java", "-jar", "./app.jar" ]