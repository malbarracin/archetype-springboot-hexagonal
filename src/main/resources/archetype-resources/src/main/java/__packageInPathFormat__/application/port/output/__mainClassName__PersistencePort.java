package ${package}.application.port.output;

import java.util.List;

import ${package}.domain.model.${mainClassName};
import reactor.core.publisher.Mono;


/**
 * Port interface for the ${mainClassName} repository.
 * This interface defines the contract for ${mainClassName}-related persistence operations.
 */
public interface ${mainClassName}PersistencePort {
	 /**
     * Retrieves all ${mainClassName}s from the database.
     *
     * @return a Flux of ${mainClassName} entities
     */
	Mono<List<${mainClassName}>> findAll();

    /**
     * Retrieves a ${mainClassName} by ID.
     *
     * @param id the ID of the ${mainClassName} to retrieve
     * @return a Mono containing the ${mainClassName} if found, or empty if not found
     */
    Mono<${mainClassName}> findById(String id);

    /**
     * Saves a ${mainClassName} entity to the database.
     *
     * @param ${mainClassName} the ${mainClassName} entity to save
     * @return a Mono containing the saved ${mainClassName}
     */
    Mono<${mainClassName}> save(${mainClassName} model);

    /**
     * Deletes a ${mainClassName} by its ID.
     *
     * @param id the ID of the ${mainClassName} to delete
     * @return a Mono signaling when the deletion is complete
     */
    Mono<Void> deleteById(String id);
}
