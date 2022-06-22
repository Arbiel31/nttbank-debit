FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ADD ./target/nttbank-debit-0.0.1-SNAPSHOT.jar nttbank-debit.jar
ENTRYPOINT ["java","-jar","nttbank-debit.jar"]