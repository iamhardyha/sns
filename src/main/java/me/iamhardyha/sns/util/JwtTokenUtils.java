package me.iamhardyha.sns.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtTokenUtils {

    public static String generateToken(String userName, String key, long expiredTimeMs) {
        return Jwts.builder()
                .claims(Map.of("userName", userName))  // setClaims 제거
                .issuedAt(new Date(System.currentTimeMillis()))  // setIssuedAt 제거
                .expiration(new Date(System.currentTimeMillis() + expiredTimeMs))  // setExpiration 제거
                .signWith(getKey(key))  // SignatureAlgorithm 불필요, 키에서 자동 추론
                .compact();
    }

    public static String getUserName(String token, String key) {
        return parseClaims(token, key).get("userName", String.class);
    }

    public static boolean isExpired(String token, String key) {
        return parseClaims(token, key)
                .getExpiration()
                .before(new Date());
    }

    private static Claims parseClaims(String token, String key) {
        return Jwts.parser()
                .verifyWith((SecretKey) getKey(key))  // setSigningKey 제거
                .build()
                .parseSignedClaims(token)  // parseClaimsJws 제거
                .getPayload();
    }

    private static Key getKey(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
