FROM openjdk:22-jdk
ADD target/nodeproject.jar nodeproject.jar
ENTRYPOINT [ "java", "-jar", "/nodeproject.jar" ]