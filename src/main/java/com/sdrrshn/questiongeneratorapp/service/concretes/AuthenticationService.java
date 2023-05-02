package com.sdrrshn.questiongeneratorapp.service.concretes;
import com.sdrrshn.questiongeneratorapp.core.results.DataResult;
import com.sdrrshn.questiongeneratorapp.core.results.Result;
import com.sdrrshn.questiongeneratorapp.core.results.SuccessDataResult;
import com.sdrrshn.questiongeneratorapp.data.dto.AuthenticationDto;
import com.sdrrshn.questiongeneratorapp.data.dto.ResetPasswordDto;
import com.sdrrshn.questiongeneratorapp.data.dto.UserAdd;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IAuthenticationService;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IUserService;
import org.springframework.stereotype.Service;


@Service
public class AuthenticationService implements IAuthenticationService {
    private final IUserService userService;

    public AuthenticationService(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public DataResult<String> login(AuthenticationDto authenticationDto) throws Exception {
        UserAdd userEntity=userService.getUserName(authenticationDto.getUsername());
        if (!authenticationDto.getPassword().equals(userEntity.getPassword())){
            throw new Exception("password is not correct");
        }
        else return new SuccessDataResult<>("true");
    }

    @Override
    public Result forgetPassword(String email) {
        return null;
    }

    @Override
    public Result resetPassword(ResetPasswordDto resetPasswordDto) {
        return null;
    }
}
