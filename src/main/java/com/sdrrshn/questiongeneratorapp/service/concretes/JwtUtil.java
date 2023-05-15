package com.sdrrshn.questiongeneratorapp.service.concretes;

import com.sdrrshn.questiongeneratorapp.core.exception.UnauthorizedException;
import com.sdrrshn.questiongeneratorapp.core.results.DataResult;
import com.sdrrshn.questiongeneratorapp.core.results.SuccessDataResult;
import com.sdrrshn.questiongeneratorapp.data.dto.TokenPayload;
import com.sdrrshn.questiongeneratorapp.service.abstracts.IJwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtil implements IJwtUtil {
    private String secret;
    private Long expiresAfter;

    public JwtUtil(String secret, Long expiresAfter) {
        this.secret = secret;
        this.expiresAfter = expiresAfter;
    }

    @Override
    public DataResult<Claims> extractAllClaims(String token) {
        try {
            return new SuccessDataResult<>(Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody());
        } catch (Exception e) {
            throw new UnauthorizedException();
        }
    }

    @Override
    public DataResult<TokenPayload> getTokenPayload(String token) {
        try {
            TokenPayload tokenPayload = new TokenPayload();
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            tokenPayload.setId(claims.get("id", Long.class));
            tokenPayload.setUsername(claims.get("userName", String.class));
            return new SuccessDataResult<>(tokenPayload);

        } catch (Exception e) {
            throw new UnauthorizedException();
        }
    }

    @Override
    public String createToken(Map<String, Object> claims) {
        long nowInMilis = System.currentTimeMillis();
        return Jwts.builder().setClaims(claims).setSubject("q-auth-token").setIssuedAt(new Date(nowInMilis))
            .setExpiration(new Date(nowInMilis + expiresAfter))
            .signWith(SignatureAlgorithm.HS256, secret).compact();
    }

}