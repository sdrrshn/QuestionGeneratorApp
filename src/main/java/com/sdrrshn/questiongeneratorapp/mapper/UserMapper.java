package com.sdrrshn.questiongeneratorapp.mapper;

import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;
import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Named("userAddToUserEntity")
    UserEntity userAddToUserEntity(UserAdd userAdd);

    @Named("userEntityToUserAdd")
    UserAdd userEntityToUserAdd(UserEntity userEntity);
}
