package ${package}.infrastructure.adapters.output.persistence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import ${package}.domain.model.${mainClassName};
import ${package}.infrastructure.adapters.output.persistence.entity.${mainClassName}Entity;


/**
 * Mapper interface for converting between ${mainClassName} domain objects and ${mainClassName}Entity objects.
 * This interface is implemented by MapStruct at compile time to provide the necessary 
 * mappings between the two types.
 */
@Mapper(componentModel = "spring")
public interface ${mainClassName}PersistenceMapper {

    /**
     * Converts a ${mainClassName} domain object to a ${mainClassName}Entity object.
     *
     * @param ${mainClassName} the ${mainClassName} domain object to convert
     * @return the corresponding ${mainClassName}Entity object
     */
    ${mainClassName}Entity to${mainClassName}Entity(${mainClassName} model);

    /**
     * Converts a ${mainClassName}Entity object to a ${mainClassName} domain object.
     *
     * @param entity the ${mainClassName}Entity object to convert
     * @return the corresponding ${mainClassName} domain object
     */
    ${mainClassName} to${mainClassName}(${mainClassName}Entity entity);

    /**
     * Converts a list of ${mainClassName}Entity objects to a list of ${mainClassName} domain objects.
     *
     * @param entityList the list of ${mainClassName}Entity objects to convert
     * @return the list of corresponding ${mainClassName} domain objects
     */
    List<${mainClassName}> to${mainClassName}List(List<${mainClassName}Entity> entityList);
}