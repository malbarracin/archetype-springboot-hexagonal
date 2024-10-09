# Proyecto Springboot

###### Aclaraciones importantes
* Importa dependencias comunes del proyecto [bds-parent-springboot]
* Define la última versión disponible de springboot como base (a mayo 2020 es la 2.3.0.RELEASE)
* Sugiere la utilización de Junit para tests unitarios
* Sugiere la utilización de la especificación Swagger, mediante la implementación de Springfox, para exponer la documentación de la API

###### Ejecutar proyecto localmente - Modo standalone

Para ejecutar el proyecto en forma local basta con ejecutar el siguiente comando:

```bash
mvn spring-boot:run -Dspring-boot.run.arguments=--spring.profiles.active=local,--spring.jackson.property-naming-strategy=LOWER_CAMEL_CASE
```

###### Ejecutar proyecto localmente - Modo container

El proyecto cuenta con la posibilidad de ser levantado en un entorno containerizado similar al del banco.

Como requisito previo se requiere la instalación de [docker](https://docs.docker.com/install/).

Luego se deberán ejecutar los siguientes comandos:

```bash
mvn clean install

docker build -t ${artifactId} .

docker run -e "LOG_PROFILE=local" -e "JSON_PROPERTY_NAMING=LOWER_CAMEL_CASE" ${artifactId}
```

###### Documentación relacionada

* [Documentación de la API](http://localhost:8080/swagger-ui.html)
* [Springboot Docs](https://spring.io/projects/spring-boot)
* [Documentación Docker](https://docs.docker.com/)

[bds-parent-springboot]: https://github.com/gss-bds/bds-parent-springboot


###### Variables de entorno:

    BASE_ACTUATOR_ENDPOINT=/actuator;EXPOSED_ACTUATOR_ENDPOINTS=info,health,prometheus,env;JSON_PLACEHOLDER_HOST=https://jsonplaceholder.typicode.com/;JSON_PROPERTY_NAMING=LOWER_CAMEL_CASE;LOG_PROFILE=int;OTEL_LOG_LEVEL=none;OTEL_LOGS_EXPORTER=none;OTEL_METRICS_EXPORTER=none;OTEL_PROPAGATORS=tracecontext,baggage,b3,b3multi;OTEL_SERVICE_NAME=service-name;OTEL_TRACES_EXPORTER=none;SPECS_URL=/test-1/docs;TIMEZONE=America/Argentina/Buenos_Aires;TRACE_LOG_SPANS=false

