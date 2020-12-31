#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM quay.io/keycloak/keycloak:11.0.2
COPY --from=build /home/app/target/customer_user_query_keycloak_spi-1.jar /opt/jboss/keycloak/standalone/deployments/
