package com.certantchallenge.vtv.service;

import com.certantchallenge.vtv.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO saveUser(UserDTO user);

    UserDTO getUser(String username);

    UserDTO updateUser(UserDTO user, String id);

    void deleteUser(String username);

    List<UserDTO> getAllUsers();
}
