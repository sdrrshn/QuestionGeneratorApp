package com.sdrrshn.questiongeneratorapp.mapper;

import com.sdrrshn.questiongeneratorapp.data.dto.TokenPayload;
import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TokenPayloadMapper {


    @Named("userEntityToTokenPayload")
    TokenPayload userEntityToTokenPayload(UserEntity userEntity);
}
