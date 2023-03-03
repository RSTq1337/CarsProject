FROM mcr.microsoft.com/java/jre:17-zulu-ubuntu
RUN mkdir /app
ADD build/libs/WebProvider-0.0.1-SNAPSHOT.jar /app
WORKDIR /app/
CMD ["java", "-jar", "WebProvider-0.0.1-SNAPSHOT.jar"]