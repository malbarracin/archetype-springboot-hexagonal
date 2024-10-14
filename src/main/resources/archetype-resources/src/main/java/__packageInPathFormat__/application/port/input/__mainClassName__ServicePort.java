package ${package}.application.port.input;

import java.util.List;

import ${package}.domain.model.${mainClassName};

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This interface defines the input port for managing user-related operations
 * in the application, following the hexagonal architecture pattern. It exposes
 * methods for creating, retrieving, updating, and deleting  ${mainClassName}.
 */
public interface ${mainClassName}ServicePort {

	 /**
     * Retrieve a ${mainClassName} by their unique identifier.
     *
     * @param id the unique identifier of the ${mainClassName} to retrieve
     * @return a {@link Mono} containing the ${mainClassName} if found, or empty if not found
     */
    Mono<${mainClassName}> get${mainClassName}ById(String id);

    /**
     * Create a new ${mainClassName} in the system.
     *
     * @param ${mainClassName} the {@link ${mainClassName}} entity to be created
     * @return a {@link Mono} containing the created ${mainClassName}
     */
    Mono<${mainClassName}> create${mainClassName}(${mainClassName} model);

    /**
     * Update an existing ${mainClassName}'s information.
     *
     * @param id the unique identifier of the ${mainClassName} to update
     * @param ${mainClassName} the updated {@link ${mainClassName}} entity
     * @return a {@link Mono} containing the updated ${mainClassName}, or empty if the ${mainClassName} was not found
     */
    Mono<${mainClassName}> update${mainClassName}(String id, ${mainClassName} model);

    /**
     * Retrieve all ${mainClassName}s from the system.
     *
     * @return a {@link Flux} containing all ${mainClassName}s in the system
     */
    Mono<List<${mainClassName}>> getAll${mainClassName}();

    /**
     * Delete a ${mainClassName} by their unique identifier.
     *
     * @param id the unique identifier of the ${mainClassName} to delete
     * @return a {@link Mono} signaling completion when the ${mainClassName} is deleted
     */
    Mono<Void> delete${mainClassName}(String id);

}
