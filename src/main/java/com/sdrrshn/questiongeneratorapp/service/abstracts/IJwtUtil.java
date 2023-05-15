package com.sdrrshn.questiongeneratorapp.service.abstracts;

import com.sdrrshn.questiongeneratorapp.core.results.DataResult;
import com.sdrrshn.questiongeneratorapp.data.dto.TokenPayload;
import io.jsonwebtoken.Claims;

import java.util.Map;

public interface IJwtUtil {
    DataResult<Claims> extractAllClaims(String token);

    DataResult<TokenPayload> getTokenPayload(String token);

    String createToken(Map<String, Object> claims);

}
