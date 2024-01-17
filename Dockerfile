# Fase de compilación: utiliza una imagen de Maven para compilar la aplicación
FROM maven:3.8.4-openjdk-11 AS builder

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo pom.xml para descargar las dependencias
COPY pom.xml .

# Descarga las dependencias del proyecto
RUN mvn dependency:go-offline

# Copia solo el archivo pom.xml (si ha cambiado) al contenedor
COPY src .

# Limpiar antes de compilar y compilar
RUN mvn clean package install

# Fase de ejecución: utiliza una imagen de MySQL para ejecutar la base de datos
FROM mysql:8

# Configuración de la base de datos
ENV MYSQL_DATABASE=ithinkupc
ENV MYSQL_USER=ithinkupc
ENV MYSQL_PASSWORD=ithinkupc
ENV MYSQL_ROOT_PASSWORD=root

# Copia el dump.sql al contenedor
COPY dump.sql /docker-entrypoint-initdb.d/

# Expone el puerto 3306 para conexiones a MySQL
EXPOSE 3306

# Fase de ejecución: utiliza una imagen de OpenJDK para ejecutar la aplicación
FROM openjdk:11-jre-slim

# Configura el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR construido desde la imagen de compilación
COPY --from=builder /app/target/ithinkupc-web-0.0.1-SNAPSHOT.war .

# Expone el puerto 8080
EXPOSE 8080

# Comando por defecto para ejecutar la aplicación
CMD ["java", "-jar", "ithinkupc-web-0.0.1-SNAPSHOT.war"]
