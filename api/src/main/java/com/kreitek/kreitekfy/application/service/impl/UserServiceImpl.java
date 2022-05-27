package com.kreitek.kreitekfy.application.service.impl;

import com.kreitek.kreitekfy.application.dto.UserDTO;
import com.kreitek.kreitekfy.application.mapper.UserMapper;
import com.kreitek.kreitekfy.application.service.UserService;
import com.kreitek.kreitekfy.domain.entity.User;
import com.kreitek.kreitekfy.domain.persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserPersistence userPersistence;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserPersistence userPersistence, UserMapper userMapper) {
        this.userPersistence = userPersistence;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> getAllUser() {
       List<User> users=this.userPersistence.getAllUsers();
       return userMapper.toDto(users);
    }

    @Override
    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        User user=this.userPersistence.saveUser(this.userMapper.toEntity(userDTO));
        return this.userMapper.toDto(user);
    }

    @Override
    public Optional<UserDTO> getUserById(Long userId) {
        return this.userPersistence.getUserById(userId).map(userMapper::toDto);
    }
}
