# Dockerfile 생성
FROM amazoncorretto:17
ARG JAR_FILE=build/libs/composite-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} composite.jar
ENV JAVA_OPTS=""
CMD java $JAVA_OPTS -server -jar composite.jar