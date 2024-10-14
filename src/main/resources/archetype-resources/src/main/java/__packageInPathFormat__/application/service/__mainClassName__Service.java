package ${package}.application.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import ${package}.application.port.output.${mainClassName}PersistencePort;
import ${package}.domain.model.${mainClassName};
import ${package}.domain.exception.NotFoundException;
import ${package}.application.port.input.${mainClassName}ServicePort;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.RequiredArgsConstructor;

/**
 * Service class for managing ${mainClassName}s.
 */
@Service
@RequiredArgsConstructor
public class ${mainClassName}Service implements ${mainClassName}ServicePort {

	private final ${mainClassName}PersistencePort repository;

	/**
	 * Retrieves a ${mainClassName} by their ID.
	 *
	 * @param id the ID of the ${mainClassName}
	 * @return a {@link Mono} containing the ${mainClassName} if found
	 * @throws NotFoundException if the ${mainClassName} is not found
	 */
	@Override
	public Mono<${mainClassName}> get${mainClassName}ById(String id) {
		return repository.findById(id)
				.switchIfEmpty(Mono.error(new NotFoundException("${mainClassName} not found with ID: " + id)));
	}

	/**
	 * Creates a new ${mainClassName}.
	 *
	 * @param ${mainClassName} the ${mainClassName} to create
	 * @return a {@link Mono} containing the created ${mainClassName}
	 */
	@Override
	public Mono<${mainClassName}> create${mainClassName}(${mainClassName} model) {
		return repository.save(model);
	}

	/**
	 * Updates an existing ${mainClassName}.
	 *
	 * @param id   the ID of the ${mainClassName} to update
	 * @param ${mainClassName} the updated ${mainClassName} information
	 * @return a {@link Mono} containing the updated ${mainClassName}
	 * @throws ${mainClassName}NotFoundException if the ${mainClassName} is not found
	 */
	@Override
	public Mono<${mainClassName}> update${mainClassName}(String id, ${mainClassName} model) {
		return repository.findById(id).flatMap(existing${mainClassName} -> {
			Optional.ofNullable(model.getDescription()).filter(description -> !description.isEmpty()).ifPresent(existing${mainClassName}::setDescription);
			return repository.save(existing${mainClassName});
		}).switchIfEmpty(Mono.error(new NotFoundException("${mainClassName} not found with ID: " + id)));
	}


	/**
	 * Retrieves all ${mainClassName}s.
	 *
	 * @return a {@link Flux} containing all ${mainClassName}s
	 */
	@Override
	public Mono<List<${mainClassName}>> getAll${mainClassName}() {
		return repository.findAll();
	}

	/**
	 * Deletes a ${mainClassName} by their ID.
	 *
	 * @param id the ID of the ${mainClassName} to delete
	 * @return a {@link Mono} that completes when the ${mainClassName} is deleted
	 * @throws ${mainClassName}NotFoundException if the ${mainClassName} is not found
	 */
	@Override
	public Mono<Void> delete${mainClassName}(String id) {
		if (repository.findById(id) == null) {
			throw new NotFoundException("${mainClassName} not found with ID: " + id);
		}

		return repository.deleteById(id);
	}
}