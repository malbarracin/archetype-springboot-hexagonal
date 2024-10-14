package ${package}.infrastructure.adapters.output.persistence.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import ${package}.infrastructure.adapters.output.persistence.entity.${mainClassName}Entity;

/**
 * Adapter for interacting with MongoDB through ReactiveMongoRepository.
 * Implements the ${mainClassName}RepositoryPort interface to serve as the output adapter
 * in the hexagonal architecture.
 */
@Repository
public interface ${mainClassName}Repository extends ReactiveMongoRepository<${mainClassName}Entity, String> {

   
}