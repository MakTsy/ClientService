FROM openjdk:14
ADD target/ClientService.jar ClientService.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "ClientService.jar"]