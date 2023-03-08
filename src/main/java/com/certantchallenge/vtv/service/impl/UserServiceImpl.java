package com.certantchallenge.vtv.service.impl;

import com.certantchallenge.vtv.config.AppConstants;
import com.certantchallenge.vtv.dto.UserDTO;
import com.certantchallenge.vtv.entity.UserEntity;
import com.certantchallenge.vtv.exception.ResourceNotFoundException;
import com.certantchallenge.vtv.mapper.UserMapper;
import com.certantchallenge.vtv.repository.UserRepository;
import com.certantchallenge.vtv.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public UserDTO saveUser(UserDTO user) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(user)));
    }

    @Override
    public UserDTO getUser(String username) {
        var userEntity = userRepository.findById(username)
                .orElseThrow(()->new ResourceNotFoundException(
                        AppConstants.RESOURCE_NOT_FOUND, AppConstants.RESOURCE_ID, username));
        return userMapper.toDto(userEntity);
    }

    @Override
    public UserDTO updateUser(UserDTO user, String id) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(
                        AppConstants.RESOURCE_NOT_FOUND, AppConstants.RESOURCE_ID, id));
        userEntity.setName(user.getName());
        userEntity.setIsExempt(user.getIsExempt());
        return userMapper.toDto(userRepository.save(userEntity));
    }

    @Override
    public void deleteUser(String username) {
        var userEntity = userRepository.findById(username)
                .orElseThrow(()->new ResourceNotFoundException(
                        AppConstants.RESOURCE_NOT_FOUND, AppConstants.RESOURCE_ID, username));
        userRepository.delete(userEntity);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserEntity> users = this.userRepository.findAll();
        return users.stream().map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public UserEntity getUserById(String id) {
        return userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(
                AppConstants.RESOURCE_NOT_FOUND, AppConstants.RESOURCE_ID, id));
    }
}
