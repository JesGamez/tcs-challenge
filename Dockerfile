FROM eclipse-temurin:11-jre-centos7
EXPOSE 8080
WORKDIR /app
ADD target/coin-exchange-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]