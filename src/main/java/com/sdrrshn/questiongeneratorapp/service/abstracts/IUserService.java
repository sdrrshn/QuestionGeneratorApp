package com.sdrrshn.questiongeneratorapp.service.abstracts;

import com.sdrrshn.questiongeneratorapp.core.results.Result;
import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;
import com.sdrrshn.questiongeneratorapp.entity.UserEntity;

public interface IUserService {
    UserAdd  add(UserAdd userAdd);
    void delete(Long id);

    UserAdd update(UserAdd userAdd,Long id);


    UserAdd getUserName(String userName);

    Result userConfirm(Long userId);
}
