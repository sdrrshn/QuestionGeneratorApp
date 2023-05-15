package com.sdrrshn.questiongeneratorapp.security.concrete;

import com.sdrrshn.questiongeneratorapp.security.abstracts.IAuthorizationProvider;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecuredRouteAspect {


    private IAuthorizationProvider authorizationProvider;

    @Autowired(required = false)
    public void setAuthorizationProvider(IAuthorizationProvider authorizationProvider) {
        this.authorizationProvider = authorizationProvider;
    }
    @Around("@annotation(com.sdrrshn.questiongeneratorapp.security.annotation.SecuredRoute)")
    public Object initializeSecuredOperation(ProceedingJoinPoint joinPoint) throws Throwable {
        authorizationProvider.isAuthorized();
        return joinPoint.proceed();
    }
}
