FROM java:8-jre
WORKDIR /src
ADD ./target/MobileServiceApp-0.0.1-SNAPSHOT.jar /src/MobileServiceApp-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar", "/src/MobileServiceApp-0.0.1-SNAPSHOT.jar"]
