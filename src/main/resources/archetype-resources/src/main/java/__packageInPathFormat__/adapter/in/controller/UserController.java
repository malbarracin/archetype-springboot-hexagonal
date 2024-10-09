package ${package}.adapter.in.controller;

import ${package}.domain.exception.PlaceHolderException;
import ${package}.domain.exception.UserException;
import ${package}.domain.model.User;
import ${package}.application.UserUsecase;
import ${package}.logtime.LogTime;
import ${package}.enabler.EnableControllerLogging;
import lombok.RequiredArgsConstructor;
import org.slf4j.event.Level;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@EnableControllerLogging
public class UserController {

    private final UserUsecase userUsecase;

    @Operation(summary = "Get user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Ok"),
            @ApiResponse(responseCode = "400", description  = "Bad Request"),
            @ApiResponse(responseCode = "401", description  = "Unauthorized"),
            @ApiResponse(responseCode = "500", description  = "Internal Server Error")
    })
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @LogTime(logLevel = Level.INFO)
    public User getUser(@PathVariable Long id) throws UserException {
        return userUsecase.getUser(id);
    }


    @Operation(summary = "Save new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description  = "Ok"),
            @ApiResponse(responseCode = "400", description  = "Bad Request"),
            @ApiResponse(responseCode = "401", description  = "Unauthorized"),
            @ApiResponse(responseCode = "500", description  = "Internal Server Error")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @LogTime(logLevel = Level.INFO)
    public User createUser(@RequestBody User user) throws UserException {
        return userUsecase.createNewUser(user);
    }

}
