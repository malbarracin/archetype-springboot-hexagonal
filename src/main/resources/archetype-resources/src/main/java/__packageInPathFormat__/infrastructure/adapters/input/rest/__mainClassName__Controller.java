package ${package}.infrastructure.adapters.input.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ${package}.application.port.input.${mainClassName}ServicePort;
import ${package}.domain.exception.NotFoundException;
import ${package}.infrastructure.adapters.input.rest.mapper.${mainClassName}RestMapper;
import ${package}.infrastructure.adapters.input.rest.model.request.${mainClassName}Request;
import ${package}.infrastructure.adapters.input.rest.model.response.${mainClassName}Response;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;


/**
 * Controller class that handles HTTP requests related to ${mainClassName} operations.
 * This class acts as an entry point (adapter) in the hexagonal architecture.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/${mainClassName}")
@Tag(name = "${mainClassName} API", description = "Operations related to ${mainClassName} management")
public class ${mainClassName}Controller {

    private final ${mainClassName}ServicePort servicePort;
    private final ${mainClassName}RestMapper restMapper;
    
    @Operation(summary = "Get a ${mainClassName} by ID", description = "Retrieve a ${mainClassName} by their unique identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${mainClassName} found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ${mainClassName}Response.class),
                            examples = @ExampleObject(value = "{\r\n"
                            		+ "    \"id\": \"66f56b94831c3d47cc76cb54\",\r\n"
                            		+ "    \"description\": \"description to ${mainClassName}.\",\r\n"
                            		+ "}"))}),
            @ApiResponse(responseCode = "404", description = "${mainClassName} not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\"message\":\"${mainClassName} not found with ID: 123\", \"status\": 404}")))
    })
    @GetMapping("/{id}")
    public Mono<${mainClassName}Response> get${mainClassName}ById(@PathVariable String id) {
    	return servicePort.get${mainClassName}ById(id)
    	        .map(restMapper::to${mainClassName}Response)
    	        .switchIfEmpty(Mono.error(new NotFoundException(id)));
        
    }

    @Operation(summary = "Create a new ${mainClassName}", description = "Create a new ${mainClassName} with the provided details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "${mainClassName} created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ${mainClassName}Response.class),
                            examples = @ExampleObject(value = "{\r\n"
                            		+ "    \"id\": \"66f56b94831c3d47cc76cb54\",\r\n"
                            		+ "    \"description\": \"description to ${mainClassName}.\",\r\n"
                            		+ "}"))}),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content(mediaType = "application/json",
                    		schema = @Schema(implementation = ${mainClassName}Request.class),
                            examples = @ExampleObject(value = "{\r\n"
                            		+ "    \"message\": \"Invalid request input: Failed to read HTTP message\",\r\n"
                            		+ "    \"status\": 400\r\n"
                            		+ "}")))
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<${mainClassName}Response> create${mainClassName}(@Valid @RequestBody ${mainClassName}Request request) {
    	return servicePort.create${mainClassName}(restMapper.to${mainClassName}(request))
    	        .map(restMapper::to${mainClassName}Response);
    }

    @Operation(summary = "Update an existing ${mainClassName}", description = "Update the details of an existing ${mainClassName}.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "${mainClassName} updated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ${mainClassName}Request.class),
                            examples = @ExampleObject(value = "{\r\n"
                            		+ "    \"id\": \"66f56b94831c3d47cc76cb54\",\r\n"
                            		+ "    \"description\": \"description to ${mainClassName}.\",\r\n"
                            		+ "}"))}),
            @ApiResponse(responseCode = "404", description = "${mainClassName} not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\r\n"
                            		+ "    \"message\": \"${mainClassName} not found with ID: 66f4bdf541bae35a29ecd68f2\",\r\n"
                            		+ "    \"status\": 404\r\n"
                            		+ "}"))),
            @ApiResponse(responseCode = "400", description = "Invalid input",
            content = @Content(mediaType = "application/json",
                    examples = @ExampleObject(value = "{\r\n"
                    		+ "    \"message\": \"Invalid request input: Failed to read HTTP message\",\r\n"
                    		+ "    \"status\": 400\r\n"
                    		+ "}")))
            
    })
    @PutMapping("/{id}")
    public Mono<${mainClassName}Response> update${mainClassName}(@PathVariable String id, @Valid @RequestBody ${mainClassName}Request request) {       
        return servicePort.update${mainClassName}(id, restMapper.to${mainClassName}(request))
                .map(restMapper::to${mainClassName}Response);
        
    }

    @Operation(summary = "Delete a ${mainClassName}", description = "Delete a ${mainClassName} by their unique identifier.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "${mainClassName} deleted successfully"),
            @ApiResponse(responseCode = "404", description = "${mainClassName} not found",
                    content = @Content(mediaType = "application/json",
                            examples = @ExampleObject(value = "{\r\n"
                            		+ "    \"message\": \"${mainClassName} not found with ID: 66f4bdf541bae35a29ecd68f\",\r\n"
                            		+ "    \"status\": 404\r\n"
                            		+ "}")))
    })
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> delete${mainClassName}(@PathVariable String id) {
    	 return servicePort.get${mainClassName}ById(id)
    		        .switchIfEmpty(Mono.error(new NotFoundException("${mainClassName} not found with ID: " + id)))
    		        .flatMap(${mainClassName} -> servicePort.delete${mainClassName}(id));
    }

    @Operation(summary = "Get all ${mainClassName}s", description = "Retrieve all ${mainClassName}s from the system.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of ${mainClassName}s retrieved",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = ${mainClassName}Response.class),
                            examples = @ExampleObject(value = "[\r\n"
                            		+ "    {\r\n"
                            		+ "        \"id\": \"66f56b94831c3d47cc76cb54\",\r\n"
                            		+ "        \"name\": \"Marcelo Alejandro Albarracín\",\r\n"
                            		+ "        \"email\": \"marceloalejandro.albarracin@gmail.com\",\r\n"
                            		+ "        \"preferredGenre\": [\r\n"
                            		+ "            \"ROCK\",\r\n"
                            		+ "            \"JAZZ\"\r\n"
                            		+ "        ],\r\n"
                            		+ "        \"favoriteArtist\": [\r\n"
                            		+ "            \"The Beatles\",\r\n"
                            		+ "            \"Miles Davis\"\r\n"
                            		+ "        ]\r\n"
                            		+ "    }\r\n"
                            		+ "]"))})
    })
    
    @GetMapping
    public Mono<List<${mainClassName}Response>> getAll${mainClassName}() {
    	return servicePort.getAll${mainClassName}()
                .map(restMapper::to${mainClassName}ResponseList);
    }
}