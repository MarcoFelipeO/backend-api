package com.backend.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Microservicio de Usuarios API-REST")
                .version("1.0")
                .description("Bienvenido a la documentación de la API Usuario.\n" +
                        "\n" +
                        "            - Para listar usuarios, utiliza el endpoint `GET /usuarios`.\n" +
                        "            - Para crear un usuario, usa `POST /usuarios`.\n" +
                        "            - Para actualizar, usa `PUT /usuarios/{id}`.\n" +
                        "            - Para eliminar, usa `DELETE /usuarios/{id}`.\n" +
                        "            - Algunos EndPoints estan protegidos. /usuarios" +
                        "            - Pero puedes traer telefonos, usa `GET /telefonos, pero antes debes logearte /`.\n" +
                        "\n" +
                        "            Cada endpoint muestra los parámetros requeridos y los posibles códigos de respuesta.\n" +
                        "\n" +
                        "            ¡Explora la documentación usando el menú desplegable de la izquierda o el buscador!" +
                        "" +
                        "" +
                        "MiL<3"));
    }
}
