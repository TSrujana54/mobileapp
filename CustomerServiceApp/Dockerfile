FROM java:8-jre
WORKDIR /src
ADD ./target/CustomerServiceApp-0.0.1-SNAPSHOT.jar CustomerServiceApp-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","CustomerServiceApp-0.0.1-SNAPSHOT.jar"]