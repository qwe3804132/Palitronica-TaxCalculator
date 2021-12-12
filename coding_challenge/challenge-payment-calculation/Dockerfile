FROM  adoptopenjdk/openjdk11:jre11u-nightly
VOLUME /tmp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
