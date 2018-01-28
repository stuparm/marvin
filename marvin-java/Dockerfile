FROM openjdk:8u151-jdk-stretch

COPY target/marvin-java-0.0.1-SNAPSHOT.jar /marvin.jar

EXPOSE 8080
VOLUME /opt

ENTRYPOINT ["java","-jar","/marvin.jar"]
