package com.sdrrshn.questiongeneratorapp.service.concretes;

import com.sdrrshn.questiongeneratorapp.core.exception.InvalidValueException;
import com.sdrrshn.questiongeneratorapp.core.mail.MailService;
import com.sdrrshn.questiongeneratorapp.core.results.DataResult;
import com.sdrrshn.questiongeneratorapp.core.results.Result;
import com.sdrrshn.questiongeneratorapp.core.results.SuccessDataResult;
import com.sdrrshn.questiongeneratorapp.core.utils.messages.UserMessageHelper;
import com.sdrrshn.questiongeneratorapp.data.dto.AuthenticationDto;
import com.sdrrshn.questiongeneratorapp.data.dto.ResetPasswordDto;
import com.sdrrshn.questiongeneratorapp.data.enums.UserStatus;
import com.sdrrshn.questiongeneratorapp.entity.UserAuthenticationEntity;
import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import com.sdrrshn.questiongeneratorapp.repository.UserAuthenticationRepository;
import com.sdrrshn.questiongeneratorapp.repository.UserEntityRepository;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IAuthenticationService;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class AuthenticationService implements IAuthenticationService {
    private final UserEntityRepository userEntityRepository;

    private final RandomString randomString;
    private final UserAuthenticationRepository userAuthenticationRepository;
    private final UserAuthenticationRepository authenticationRepository;
    private final MailService mailService;

    public AuthenticationService(UserEntityRepository userEntityRepository, RandomString randomString, UserAuthenticationRepository userAuthenticationRepository, UserAuthenticationRepository authenticationRepository, MailService mailService) {
        this.userEntityRepository = userEntityRepository;
        this.randomString = randomString;
        this.userAuthenticationRepository = userAuthenticationRepository;
        this.authenticationRepository = authenticationRepository;
        this.mailService = mailService;
    }


    @Override
    public DataResult<String> login(AuthenticationDto authenticationDto) throws Exception {
        UserEntity userEntity = userEntityRepository.findByUsername(authenticationDto.getUsername()).get();
        if (!authenticationDto.getPassword().equals(userEntity.getPassword())) {
            throw new Exception("password is not correct");
        } else return new SuccessDataResult<>("true");
    }

    @Override
    public Result forgetPassword(String email) {
        return null;
    }

    @Override
    public Result resetPassword(ResetPasswordDto resetPasswordDto) {
        return null;
    }

    @Override
    public Result createUserAuth(Long userId) {
        var user = userEntityRepository.findById(userId);
        if (user.isEmpty()) {
            throw new NullPointerException("Bu id de Bir kullanıcı yok.");
        }
        var result=new UserAuthenticationEntity();
        result.setUserEntity(user.get());
        result.setAuthCode(createRandomCode());
        result.setCreateDate(LocalDateTime.now());
        var authEntity= authenticationRepository.save(result);
        sendUserApprovedMail(user.get(),authEntity.getAuthCode());
        return  new Result(true);
    }

    @Override
    public Result userConfirmApprove(String authCode) {
        var userAuth= authenticationRepository.findByAuthCode(authCode);
        if (userAuth.isEmpty()){
            throw new InvalidValueException("Hata");
        }
        userAuth.get().getUserEntity().setStatus(UserStatus.APPROVED);
        userEntityRepository.save(userAuth.get().getUserEntity());
        userAuthenticationRepository.delete(userAuth.get());
        return new Result(true,"Başarılı bir şekilde onaylandı");
    }

    private void sendUserApprovedMail(UserEntity userEntity,String authCode) {
        String text = UserMessageHelper.userApprovedUrl + authCode;
        String to = userEntity.getEmail();
        mailService.sendSımpleMessage(to, text);
    }

    private String createRandomCode() {
        var str = randomString.nextString();
        var result = userAuthenticationRepository.findByAuthCode(str);
        if (result.isPresent()) {
            return createRandomCode();
        } else {
            return str;
        }
    }
}
