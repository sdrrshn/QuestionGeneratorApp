package com.sdrrshn.questiongeneratorapp.security.abstracts;

import com.sdrrshn.questiongeneratorapp.core.exception.UnauthorizedException;

import java.util.List;

public interface IAuthorizationProvider {
    List<String> getClaims() throws UnauthorizedException;
    void isAuthorized() throws UnauthorizedException;
}
