# Usar una imagen de Java 21 o 22 (según tu necesidad)
FROM eclipse-temurin:21-jdk

# Crear el directorio donde vivirá la app
WORKDIR /app

# Copiar el archivo Maven Wrapper y pom.xml
COPY pom.xml mvnw* ./
COPY .mvn .mvn

# 🔥 Dar permisos de ejecución al wrapper
RUN chmod +x mvnw

# Descargar dependencias
RUN ./mvnw dependency:go-offline

# Copiar todo el código
COPY src src

# Empaquetar la aplicación
RUN ./mvnw package -DskipTests

# Exponer el puerto de Spring Boot
EXPOSE 8080

# Comando para correr el .jar generado
CMD ["java", "-jar", "target/Backend-0.0.1-SNAPSHOT.jar"]