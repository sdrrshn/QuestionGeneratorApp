package com.sdrrshn.questiongeneratorapp.service.abstracts;

import com.sdrrshn.questiongeneratorapp.core.results.DataResult;
import com.sdrrshn.questiongeneratorapp.core.results.Result;
import com.sdrrshn.questiongeneratorapp.data.dto.AuthenticationDto;
import com.sdrrshn.questiongeneratorapp.data.dto.ResetPasswordDto;

public interface IAuthenticationService {
    DataResult<String> login(AuthenticationDto authenticationDto) throws Exception;

    Result forgetPassword(String email);

    Result resetPassword(ResetPasswordDto resetPasswordDto);
}
