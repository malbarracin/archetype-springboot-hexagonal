package ${package}.infrastructure.adapters.output.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import ${package}.application.port.output.${mainClassName}PersistencePort;
import ${package}.domain.model.${mainClassName};
import ${package}.infrastructure.adapters.output.persistence.entity.${mainClassName}Entity;
import ${package}.infrastructure.adapters.output.persistence.mapper.${mainClassName}PersistenceMapper;
import ${package}.infrastructure.adapters.output.persistence.repository.${mainClassName}Repository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

/**
 * Adapter class that implements the ${mainClassName}PersistencePort interface.
 * This class acts as a bridge between the domain layer and the persistence layer,
 * handling ${mainClassName}-related data operations using the ${mainClassName}Repository.
 */
@Component
@RequiredArgsConstructor
public class ${mainClassName}PersistenceAdapter implements ${mainClassName}PersistencePort {

    private final ${mainClassName}Repository repository;
    private final ${mainClassName}PersistenceMapper mapper;

    /**
     * Finds all ${mainClassName}s in the repository.
     *
     * @return a Mono containing a list of ${mainClassName} domain objects.
     */
    @Override
    public Mono<List<${mainClassName}>> findAll() {
        return repository.findAll()
                .map(mapper::to${mainClassName})
                .collectList();
    }

    /**
     * Finds a ${mainClassName} by their ID.
     *
     * @param id the ID of the ${mainClassName} to find
     * @return a Mono containing the ${mainClassName} domain object if found, or an empty Mono if not found.
     */
    @Override
    public Mono<${mainClassName}> findById(String id) {
        return repository.findById(id).map(mapper::to${mainClassName});
    }

    /**
     * Saves a new ${mainClassName} to the repository.
     *
     * @param ${mainClassName} the ${mainClassName} domain object to save
     * @return a Mono containing the saved ${mainClassName} domain object.
     */
    @Override
    public Mono<${mainClassName}> save(${mainClassName} model) {
        ${mainClassName}Entity entity = mapper.to${mainClassName}Entity(model);
        return repository.save(entity).map(mapper::to${mainClassName});
    }

    /**
     * Deletes a ${mainClassName} by their ID.
     *
     * @param ${mainClassName}Id the ID of the ${mainClassName} to delete
     * @return a Mono that completes when the deletion is done.
     */
    @Override
    public Mono<Void> deleteById(String ${mainClassName}Id) {
        return repository.deleteById(${mainClassName}Id);
    }
}