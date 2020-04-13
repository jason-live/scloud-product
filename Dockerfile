FROM hub.c.163.com/library/java:8-alpine

ADD server/target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app.jar"]