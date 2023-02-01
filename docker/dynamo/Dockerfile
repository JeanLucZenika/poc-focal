FROM openjdk:17
COPY target/global-aurora-database-with-spring-0.0.1-SNAPSHOT.jar /tmp
WORKDIR /tmp

CMD ["java", "-Dspring.profiles.active=dynamo", "-jar", "global-aurora-database-with-spring-0.0.1-SNAPSHOT.jar"]