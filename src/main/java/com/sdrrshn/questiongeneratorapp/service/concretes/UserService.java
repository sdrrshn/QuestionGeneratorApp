package com.sdrrshn.questiongeneratorapp.service.concretes;

import com.sdrrshn.questiongeneratorapp.core.exception.InvalidValueException;
import com.sdrrshn.questiongeneratorapp.core.results.Result;
import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;
import com.sdrrshn.questiongeneratorapp.data.enums.UserStatus;
import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import com.sdrrshn.questiongeneratorapp.mapper.UserMapper;
import com.sdrrshn.questiongeneratorapp.repository.UserEntityRepository;
import com.sdrrshn.questiongeneratorapp.security.encryption.abstracts.IPasswordEncryptor;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IAuthenticationService;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private final UserEntityRepository userRep;
    private final UserMapper userMapper;
    private final IPasswordEncryptor passwordEncryptor;
    private final IAuthenticationService authenticationService;

    public UserService(UserEntityRepository userRep, UserMapper userMapper, IPasswordEncryptor passwordEncryptor, IAuthenticationService authenticationService) {
        this.userRep = userRep;
        this.userMapper = userMapper;
        this.passwordEncryptor = passwordEncryptor;
        this.authenticationService = authenticationService;
    }


    @Override
    public UserAdd add(UserAdd userAdd) {
        checkUserAdd(userAdd);
        UserEntity userEntity = userMapper.userAddToUserEntity(userAdd);
        userEntity.setPassword(passwordEncryptor.encrypt(userAdd.getPassword()));
        var result = userRep.save(userEntity);
        setUserAuthentication(result);
        return userMapper.userEntityToUserAdd(result);
    }

    private void setUserAuthentication(UserEntity result) {
        authenticationService.createUserAuth(result.getId());
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
        System.out.printf("username %s", userName);
        var userEntity = userRep.findByUsername(userName);
        if (userEntity.isEmpty())
            throw new NullPointerException("this username does not have a user");
        return userMapper.userEntityToUserAdd(userEntity.get());
    }

    @Override
    public Result userConfirm(Long userId) {
        var result = userRep.findById(userId);
        if (result.isEmpty()) {
            throw new NullPointerException("Böyle Bir Kullanıcı Yok");
        }
        result.get().setStatus(UserStatus.APPROVED);
        userRep.save(result.get());
        return new Result(true, "Başarılı Bir Şekilde Onaylandı");
    }


    private void checkUserAdd(UserAdd user) {
        var userEntity = userRep.getUserForUserAdd(user.getUsername(), user.getEmail(), user.getPhone());
        if (userEntity.isPresent()) {
            if (userEntity.get().getPhone().equals(user.getPhone())) {
                throw new InvalidValueException("Bu Telefon Numarası sistemde kayıtlı.");
            } else if (userEntity.get().getUsername().equalsIgnoreCase(user.getUsername())) {
                throw new InvalidValueException("Bu username sistemde kayıtlı.");
            } else if (userEntity.get().getEmail().equalsIgnoreCase(user.getEmail())) {
                throw new InvalidValueException("Bu email sistemde kayıtlı.");
            }
            throw new InvalidValueException();
        }
    }
}
