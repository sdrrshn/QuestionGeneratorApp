package com.sdrrshn.questiongeneratorapp.service.concretes;

import com.sdrrshn.questiongeneratorapp.core.exception.InvalidValueException;
import com.sdrrshn.questiongeneratorapp.core.mail.MailService;
import com.sdrrshn.questiongeneratorapp.core.messages.UserMessageHelper;
import com.sdrrshn.questiongeneratorapp.core.results.DataResult;
import com.sdrrshn.questiongeneratorapp.core.results.Result;
import com.sdrrshn.questiongeneratorapp.core.results.SuccessDataResult;

import com.sdrrshn.questiongeneratorapp.data.dto.AuthenticationDto;
import com.sdrrshn.questiongeneratorapp.data.dto.ResetPasswordDto;
import com.sdrrshn.questiongeneratorapp.data.enums.UserStatus;
import com.sdrrshn.questiongeneratorapp.entity.UserAuthenticationEntity;
import com.sdrrshn.questiongeneratorapp.entity.UserEntity;
import com.sdrrshn.questiongeneratorapp.repository.UserAuthenticationRepository;
import com.sdrrshn.questiongeneratorapp.repository.UserEntityRepository;
import com.sdrrshn.questiongeneratorapp.security.encryption.abstracts.IPasswordEncryptor;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IAuthenticationService;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IJwtUtil;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


@Service
public class AuthenticationService implements IAuthenticationService {
    private final UserEntityRepository userEntityRepository;

    private final RandomString randomString;
    private final UserAuthenticationRepository userAuthenticationRepository;
    private final UserAuthenticationRepository authenticationRepository;
    private final MailService mailService;
    private final IJwtUtil jwtUtil;
    private final IPasswordEncryptor passwordEncryptor;


    public AuthenticationService(UserEntityRepository userEntityRepository, RandomString randomString, UserAuthenticationRepository userAuthenticationRepository, UserAuthenticationRepository authenticationRepository, MailService mailService, IJwtUtil jwtUtil, IPasswordEncryptor passwordEncryptor) {
        this.userEntityRepository = userEntityRepository;
        this.randomString = randomString;
        this.userAuthenticationRepository = userAuthenticationRepository;
        this.authenticationRepository = authenticationRepository;
        this.mailService = mailService;
        this.jwtUtil = jwtUtil;
        this.passwordEncryptor = passwordEncryptor;
    }


    @Override
    public DataResult<String> login(AuthenticationDto authenticationDto) throws Exception {
        UserEntity userEntity = userEntityRepository.findByUsername(authenticationDto.getUsername()).get();
        if (!passwordEncryptor.matches(authenticationDto.getPassword(),userEntity.getPassword())) {
            throw new Exception("password is not correct");
        } else return new SuccessDataResult<>(jwtUtil.createToken(userToHashMap(userEntity)),"TOKEN CREATED.");
    }

    private Map<String, Object> userToHashMap(UserEntity userEntity) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id",userEntity.getId());
        claims.put("username",userEntity.getUsername());
        claims.put("status",userEntity.getStatus());
        return claims;
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
        var result = new UserAuthenticationEntity();
        result.setUserEntity(user.get());
        result.setAuthCode(createRandomCode());
        result.setCreateDate(LocalDateTime.now());
        var authEntity = authenticationRepository.save(result);
        sendUserApprovedMail(user.get(), authEntity.getAuthCode());
        return new Result(true);
    }

    @Override
    public Result userConfirmApprove(String authCode) {
        var userAuth = authenticationRepository.findByAuthCode(authCode);
        if (userAuth.isEmpty()) {
            throw new InvalidValueException("Hata");
        }
        userAuth.get().getUserEntity().setStatus(UserStatus.APPROVED);
        userEntityRepository.save(userAuth.get().getUserEntity());
        userAuthenticationRepository.delete(userAuth.get());
        return new Result(true, "Başarılı bir şekilde onaylandı");
    }

    private void sendUserApprovedMail(UserEntity userEntity, String authCode) {
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
