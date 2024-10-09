# bds-archetype-springboot

Este proyecto permite construir un proyecto springboot básico apto para ser ejecutado en Kubernetes, siguiendo el marco de referencia y los lineamientos propuestos por el banco para el desarrollo de microservicios.

#### Pasos de ejecución

* Configurar el repositorio de artefactos correctamente

* Generar un proyecto con el arquetipo


#### 1. Java 17 + Arquitectura Hexagonal:
```bash
        mvn archetype:generate -DarchetypeGroupId=ar.com.bds.assets  -DarchetypeArtifactId=bds-archetype-springboot -DarchetypeVersion=3.0.2 -Dmongoenable=false -Dsbenable=false -Dwsenable=false
```

#### 2. Java 17:
```bash
        mvn archetype:generate -DarchetypeGroupId=ar.com.bds.assets  -DarchetypeArtifactId=bds-archetype-springboot -DarchetypeVersion=2.0.3 -Dmongoenable=false -Dsbenable=false -Dwsenable=false
```

    Los parámetros que recibe el comando son:
      - **archetypeGroupId** (group id perteneciente al arquetipo a utilizar)
      - **archetypeArtifactId** (artifact id perteneciente al arquetipo a utilizar)
      - **archetypeVersion** (version perteneciente al arquetipo a utilizar)
      - **groupId** (group id del proyecto que será generado)
      - **artifactId** (artifact id del proyecto que será generado)
      - **version** (version del proyecto que será generado, por defecto es 0.1.0-SNAPSHOT)
      - **package** (será utilizado para generar la estructura de paquetes dentro del proyecto)
      - **mongoenable** (incluye las librerias necesarias para la implementacion de MongoDB)
      - **sbenable** (incluye la libreria de bds-commons-sb y las properties necesarias)
      - **wsenable** (incluye la libreria de bds-commons-ws)
      - **httpReactivaEnable** (incluye la libreria de bds-commons-http-reactiva) que 
        se usa para proyectos con webclient (para version 3.0.2 o superior) 

ENVIROMENT VARIABLES - JAVA 17:
```bash
BASE_ACTUATOR_ENDPOINT=/transactions/actuator;EXPOSED_ACTUATOR_ENDPOINTS=info,health,prometheus;JSON_PLACEHOLDER_HOST=https://jsonplaceholder.typicode.com;JSON_PROPERTY_NAMING=LOWER_CAMEL_CASE;LOG_LEVEL=debug;LOG_PROFILE=local;OTEL_LOG_LEVEL=none;OTEL_LOGS_EXPORTER=none;OTEL_METRICS_EXPORTER=none;OTEL_TRACES_EXPORTER=none;SPRING_CLOUD_AZURE_COMPATIBILITY-VERIFIER_ENABLED=false;TIMEZONE=America/Buenos_Aires;SPRING_PROFILES_ACTIVE=local
```

#### 3. Java 11:
```bash
        mvn archetype:generate -DarchetypeGroupId=ar.com.bds.assets  -DarchetypeArtifactId=bds-archetype-springboot -DarchetypeVersion=0.3.2 -Dmongoenable=false -Dsbenable=false -Dwsenable=false
```

    Los parámetros que recibe el comando son:
      - **archetypeGroupId** (group id perteneciente al arquetipo a utilizar)
      - **archetypeArtifactId** (artifact id perteneciente al arquetipo a utilizar)
      - **archetypeVersion** (version perteneciente al arquetipo a utilizar)
      - **groupId** (group id del proyecto que será generado)
      - **artifactId** (artifact id del proyecto que será generado)
      - **version** (version del proyecto que será generado, por defecto es 0.1.0-SNAPSHOT)
      - **package** (será utilizado para generar la estructura de paquetes dentro del proyecto)

ENVIROMENT VARIABLES - JAVA 11:
```bash
BASE_ACTUATOR_ENDPOINT=/transactions/actuator;EXPOSED_ACTUATOR_ENDPOINTS=info,health,prometheus;JAEGER_AGENT_HOST=jaeger-agent.istio-system.svc.cluster.local;JAEGER_AGENT_PORT=6831;JSON_PLACEHOLDER_HOST=https://jsonplaceholder.typicode.com;JSON_PROPERTY_NAMING=LOWER_CAMEL_CASE;LOG_LEVEL=debug;LOG_PROFILE=local;SPRING_CLOUD_AZURE_COMPATIBILITY-VERIFIER_ENABLED=false;TIMEZONE=America/Buenos_Aires
```

Observación: En particular si algun parámetro no es provisto por el desarrollador, y no tiene valores por defecto, la herramienta se lo solicitará de forma interactiva.



