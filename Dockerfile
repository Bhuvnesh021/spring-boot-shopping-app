FROM openjdk:8
COPY target/AgroShopping.war .
ENTRYPOINT ["java","-jar","/AgroShopping.war"]