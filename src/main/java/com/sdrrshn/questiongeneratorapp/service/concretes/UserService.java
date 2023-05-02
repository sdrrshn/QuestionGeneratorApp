package com.sdrrshn.questiongeneratorapp.service.concretes;

import com.sdrrshn.questiongeneratorapp.core.results.Result;
import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;
import com.sdrrshn.questiongeneratorapp.data.enums.UserStatus;
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

    @Override
    public UserAdd getUserName(String userName) {
        System.out.printf("username %s",userName);
        var userEntity=userRep.findByUsername(userName);
        if (userEntity.isEmpty())
            throw new NullPointerException("this username does not have a user");
        return userMapper.userEntityToUserAdd(userEntity.get());
    }

    @Override
    public Result userConfirm(Long userId) {
        System.out.println(userId);
        var result=userRep.findById(userId);
        if (result.isEmpty()){
            throw new NullPointerException("Böyle Bir Kullanıcı Yok");
        }
        result.get().setStatus(UserStatus.APPROVED);
        userRep.save(result.get());
        return new Result(true,"Başarılı Bir Şekilde Onaylandı");
    }
}
