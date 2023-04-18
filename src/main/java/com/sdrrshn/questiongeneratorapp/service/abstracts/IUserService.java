package com.sdrrshn.questiongeneratorapp.service.abstracts;

import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;

public interface IUserService {
    UserAdd  add(UserAdd userAdd);
    void delete(Long id);

    UserAdd update(UserAdd userAdd,Long id);



}
