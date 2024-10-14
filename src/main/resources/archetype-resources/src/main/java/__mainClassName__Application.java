package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the ${mainClassName} Service application.
 * This class is annotated with @SpringBootApplication, which enables 
 * auto-configuration, component scanning, and allows the application 
 * to be run as a Spring Boot application.
 */
@SpringBootApplication(scanBasePackages = "${package}")
public class ${mainClassName}Application {

	/**
     * The main method that serves as the starting point for the ${mainClassName} Service application.
     * It triggers the Spring Boot application context initialization and starts the application.
     *
     * @param args command-line arguments passed to the application
     */
	 public static void main(String[] args) {
        SpringApplication.run(${mainClassName}Application.class, args);
     }
}
