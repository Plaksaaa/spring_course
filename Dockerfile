FROM openjdk:16

RUN mkdir /app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]