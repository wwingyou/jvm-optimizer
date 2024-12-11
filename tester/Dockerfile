FROM openjdk:17
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","echo $JAVA_OPTIONS","-jar","/app.jar"]
ENV JAVA_OPTIONS=Hello
ENTRYPOINT ["java"]

