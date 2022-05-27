package com.kreitek.kreitekfy.application.mapper;

import com.kreitek.kreitekfy.application.dto.UserDTO;
import com.kreitek.kreitekfy.domain.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}
