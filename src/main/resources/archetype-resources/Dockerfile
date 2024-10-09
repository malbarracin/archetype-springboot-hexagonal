FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/${artifactId}.jar .
ENV OTEL_INSTRUMENTATION_JMS_ENABLED "true"
ENV OTEL_LOG_LEVEL "none"
ENV OTEL_LOGS_EXPORTER "none"
ENV OTEL_METRICS_EXPORTER "none"
ENV OTEL_SERVICE_NAME "${artifactId}"
EXPOSE 8080 6565
CMD ["java","-jar","${artifactId}.jar"]