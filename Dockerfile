FROM openjdk:11-jre-slim
LABEL maintainer="DevSecOps-Pacifico"
ENV spring.application.name ms-sp-soporte-ti-obtiene-datos-geografia-pga-v1
COPY target/ms-sp-soporte-ti-obtiene-datos-geografia-pga-*SNAPSHOT.jar /opt/ms-sp-soporte-ti-obtiene-datos-geografia-pga.jar
ENTRYPOINT ["java", "-Djava.file.encoding=UTF-8","-jar","/opt/ms-sp-soporte-ti-obtiene-datos-geografia-pga.jar"]
