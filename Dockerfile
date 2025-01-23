FROM openjdk:21-jdk

EXPOSE 8080

COPY ./build/libs/spring-github-action-docker-db-test-0.0.1.jar /usr/app/
WORKDIR /usr/app

ENTRYPOINT ["java", "-jar", "spring-github-action-docker-db-test-0.0.1.jar"]
