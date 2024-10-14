# Arquetipo de Arquitectura Hexagonal en Spring Boot

## Descripción

Este arquetipo de Maven te ayuda a crear rápidamente un proyecto en Spring Boot siguiendo el patrón de Arquitectura Hexagonal. El arquetipo genera la estructura de tu microservicio, con una clara separación de responsabilidades y una arquitectura modular.

## Estructura del Proyecto

El proyecto generado sigue esta estructura:

```
src
 └── main
     └── java
         └── __packageInPathFormat__
             ├── application
             │   ├── port
             │   │   ├── input               # Puertos de entrada
             │   │   └── output              # Puertos de salida
             │   └── service                 # Servicios de la capa de aplicación
             ├── config                      # Configuración de Spring Boot
             ├── domain                      # Capa de dominio
             │   ├── exception               # Excepciones personalizadas
             │   └── model                   # Modelos de dominio
             └── infrastructure              # Capa de infraestructura
                 ├── adapters
                 │   ├── input
                 │   │   └── rest            # Adaptadores de entrada, como los controladores REST
                 │   │       ├── mapper      # Mapeadores para los DTO
                 │   │       └── model       # Modelos de solicitud/respuesta
                 │   │           └── __mainClassName__Controller.java  # Controlador REST
                 │   └── output
                 │       └── persistence     # Adaptadores de salida, como repositorios de persistencia
                 │           ├── entity      # Entidades de base de datos
                 │           ├── mapper      # Mapeadores de entidades
                 │           └── repository  # Repositorios
                 ├── __mainClassName__Application.java  # Clase principal de la aplicación
 └── resources
     ├── application.yaml                    # Configuración de Spring Boot (YAML)
 └── test                                    # Directorio de pruebas
 └── Dockerfile                              # Dockerfile para crear la imagen de Docker
 └── pom.xml                                 # Archivo POM de Maven
 └── README.md                               # Documentación del proyecto
 └── META-INF
     ├── archetype-metadata.xml              # Metadata del arquetipo de Maven
     └── archetype-post-generate.groovy      # Script post-generación
```

## Características

- **Arquitectura Hexagonal**: Clara separación entre las capas de dominio, aplicación e infraestructura.
- **Spring Boot**: Integración completa con Spring Boot para un desarrollo rápido.
- **Soporte Reactivo**: Uso de Reactor para programación reactiva (con soporte para Mono y Flux).
- **Manejo de Excepciones Integrado**: Manejo de excepciones por defecto con un `DefaultExceptionHandler` personalizable.

## Requisitos

Para usar este arquetipo, necesitas:

- Maven 3.6.0 o más reciente.
- Java 17 o más reciente (se recomienda Java 17).
- Git (si deseas clonar el repositorio).

## Cómo Generar un Nuevo Proyecto

1. Primero, asegúrate de tener el arquetipo instalado localmente o disponible en tu repositorio Maven.
   ```bash
      mvn clean install
   ```   
2. Ejecuta el siguiente comando de Maven para generar un nuevo proyecto:

    ```bash
    mvn archetype:generate \
        -DarchetypeGroupId=ar.com.bancogalicia.assets \
        -DarchetypeArtifactId=archetype-springboot-hexagonal \
        -DarchetypeVersion=0.1.0-SNAPSHOT \
        -DgroupId=[tu-group-id] \
        -DartifactId=[tu-artifact-id] \
        -Dversion=1.0.0-SNAPSHOT \
        -Dpackage=[tu-paquete-base] \
        -DparentVersion=[tu-parent-version] \
        -DmainClassName=[tu-class-name]
    ```

## ¿Te gusta el contenido que comparto? Invítame un café para ayudarme a seguir creando. ¡Gracias por tu apoyo!
[![Buy Me a Coffee](https://img.shields.io/badge/Buy%20Me%20a%20Coffee-F7DF1E?style=for-the-badge&logo=buy-me-a-coffee&logoColor=black)](https://buymeacoffee.com/malbarracin)    
    