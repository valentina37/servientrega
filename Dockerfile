FROM openjdk:17
COPY "./target/servientrega-1.jar" "app.jar"
EXPOSE 8012
ENTRYPOINT [ "java", "-jar", "app.jar" ]
