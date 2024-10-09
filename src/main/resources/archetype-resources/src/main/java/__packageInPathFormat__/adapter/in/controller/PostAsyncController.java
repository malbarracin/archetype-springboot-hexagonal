package ${package}.adapter.in.controller;

import ${package}.domain.exception.PlaceHolderException;
import ${package}.domain.model.Post;
import ${package}.application.PostAsyncUsecase;
import ${package}.enabler.EnableControllerLogging;
import ${package}.logtime.LogTime;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/posts/async")
@RequiredArgsConstructor
@EnableControllerLogging
public class PostAsyncController {

    private final PostAsyncUsecase postAsyncUsecase;

    @Operation(summary = "Get external posts by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Ok"),
            @ApiResponse(responseCode = "400", description  = "Bad Request"),
            @ApiResponse(responseCode = "401", description  = "Unauthorized"),
            @ApiResponse(responseCode = "500", description  = "Internal Server Error")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @LogTime(logLevel = Level.INFO)
    public Mono<Post> getAsyncPost(@PathVariable String id) throws PlaceHolderException {
        return postAsyncUsecase.getPostAsync(id);
    }

}
