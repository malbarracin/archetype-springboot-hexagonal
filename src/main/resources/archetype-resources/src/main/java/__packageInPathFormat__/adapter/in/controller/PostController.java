package ${package}.adapter.in.controller;

import ${package}.domain.exception.PlaceHolderException;
import ${package}.domain.model.Post;
import ${package}.application.PostUsecase;
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

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@EnableControllerLogging
public class PostController {

    private final PostUsecase postUsecase;

    @Operation(summary = "Get external posts by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Ok"),
            @ApiResponse(responseCode = "400", description  = "Bad Request"),
            @ApiResponse(responseCode = "401", description  = "Unauthorized"),
            @ApiResponse(responseCode = "500", description  = "Internal Server Error")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @LogTime(logLevel = Level.INFO)
    public Post getPost(@PathVariable String id) throws PlaceHolderException {
        return postUsecase.getPost(id);
    }

}
