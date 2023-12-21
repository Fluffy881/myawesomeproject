FROM rsunix/yourkit-openjdk17

ADD target/MyAwesomePoject.jar MyAwesomePoject.jar
ENTRYPOINT ["java", "-jar", "MyAwesomePoject.jar"]
EXPOSE 8080