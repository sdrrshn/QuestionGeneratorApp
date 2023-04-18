package com.sdrrshn.questiongeneratorapp.service.concretes;

import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;
import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import com.sdrrshn.questiongeneratorapp.mapper.UserMapper;
import com.sdrrshn.questiongeneratorapp.repository.UserEntityRepository;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
private final UserEntityRepository userRep;
private final UserMapper userMapper;

    public UserService(UserEntityRepository userRep, UserMapper userMapper) {
        this.userRep = userRep;
        this.userMapper = userMapper;
    }


    @Override
    public UserAdd add(UserAdd userAdd) {
        UserEntity userEntity=userMapper.userAddToUserEntity(userAdd);
        return userMapper.userEntityToUserAdd(userRep.save(userEntity));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public UserAdd update(UserAdd userAdd, Long id) {
        return null;
    }
}
