FROM openjdk:17
EXPOSE 8080
WORKDIR /app
ADD gamescorehub-0.0.1-SNAPSHOT.jar app/gamescorehub.jar
CMD ["java", "-jar", "app/gamescorehub.jar"]