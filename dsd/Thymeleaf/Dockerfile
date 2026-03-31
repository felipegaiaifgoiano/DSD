# -------- STAGE 1: BUILD --------
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copia tudo
COPY . .

# Gera o WAR
RUN mvn clean package -DskipTests


# -------- STAGE 2: RUNTIME --------
FROM tomcat:10.1-jdk17

# Limpa apps padrão
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia o WAR gerado
COPY --from=build /target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
