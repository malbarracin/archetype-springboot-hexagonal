package ${package}.infrastructure.adapters.input.rest.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ${package}.domain.model.${mainClassName};
import ${package}.infrastructure.adapters.input.rest.model.request.${mainClassName}Request;
import ${package}.infrastructure.adapters.input.rest.model.response.${mainClassName}Response;


/**
 * Mapper interface for converting between ${mainClassName} and related DTOs.
 * This interface defines the mapping methods for transforming
 * ${mainClassName}CreateRequest into ${mainClassName}, ${mainClassName} into ${mainClassName}Response, and
 * lists of ${mainClassName}s into lists of ${mainClassName}Responses.
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ${mainClassName}RestMapper {

    /**
     * Converts a ${mainClassName}CreateRequest object to a ${mainClassName} domain object.
     *
     * @param request the ${mainClassName}CreateRequest object to convert
     * @return the converted ${mainClassName} domain object
     */
    ${mainClassName} to${mainClassName}(${mainClassName}Request request);

    /**
     * Converts a ${mainClassName} domain object to a ${mainClassName}Response object.
     *
     * @param ${mainClassName} the ${mainClassName} domain object to convert
     * @return the converted ${mainClassName}Response object
     */
    ${mainClassName}Response to${mainClassName}Response(${mainClassName} domain);

    /**
     * Converts a list of ${mainClassName} domain objects to a list of ${mainClassName}Response objects.
     *
     * @param ${mainClassName}List the list of ${mainClassName} domain objects to convert
     * @return the list of converted ${mainClassName}Response objects
     */
    List<${mainClassName}Response> to${mainClassName}ResponseList(List<${mainClassName}> ${mainClassName}List);
}