FROM openjdk:11
COPY server.jar .
ENV TZ=Asia/Seoul
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=live", "./server.jar"]
