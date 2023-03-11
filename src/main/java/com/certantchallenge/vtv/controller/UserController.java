package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.InspectionResponse;
import com.certantchallenge.vtv.dto.UserDTO;
import com.certantchallenge.vtv.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Api(tags = "User Endpoints", value = "UserEndpoints")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/register", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Save an user", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 201, message = "OK - User Created",
            response = InspectionResponse.class)
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
    @GetMapping(value = "/{id}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Get an user", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 200, message = "OK - get User",
            response = InspectionResponse.class)
    public ResponseEntity<UserDTO> getUser(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @GetMapping(produces = {"application/json"})
    @ApiOperation(value = "Get an user", produces = "application/json")
    @ApiResponse(code = 200, message = "OK - get Users",
            response = InspectionResponse.class)
    public ResponseEntity<List<UserDTO>> getUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PutMapping(value = "/update/{id}", produces = {"application/json"},
            consumes = {"application/json"})
    @ApiOperation(value = "Update an user", produces = "application/json",
            consumes = "application/json")
    @ApiResponse(code = 202, message = "OK - update User",
            response = InspectionResponse.class)
    public ResponseEntity<UserDTO> updateUser(@Valid @PathVariable String id, @RequestBody UserDTO user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(user, id));
    }

    @DeleteMapping(value = "/delete/{id}")
    @ApiOperation(value = "Delete an user")
    @ApiResponse(code = 204, message = "OK - delete an User")
    public ResponseEntity<Object> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
