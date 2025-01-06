FROM rizzoantonella86834/evaluateperformanceapp:latest
VOLUME /tmp
ENV JAVA_OPTS=""
ADD target/evaluatePerformanceApp.jar App.jar
EXPOSE 8080
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar App.jar