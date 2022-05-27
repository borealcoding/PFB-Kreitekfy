package com.kreitek.kreitekfy.application.service;

import com.kreitek.kreitekfy.application.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> getAllUser();
    UserDTO saveUser(UserDTO userDTO);
    Optional <UserDTO>getUserById(Long userId);

}
