package com.certantchallenge.vtv.controller;

import com.certantchallenge.vtv.dto.UserDTO;
import com.certantchallenge.vtv.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findById(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @PathVariable String id, @RequestBody UserDTO user){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(user, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
