package com.example.springbootdemo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.springbootdemo.entity.Admins;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class AdminsJwtUtils{
    public static final long EXPIRE_TIME = 60L * 60 * 1000 * 25 *365;
    public static final String SECRET = "SECRET";
    //签发token
    public static String sign(Admins admins){
        LocalDateTime expireDate = LocalDateTime.now().plus(EXPIRE_TIME, ChronoUnit.MILLIS);
        ZoneId zoneId = ZoneId.systemDefault();
        return JWT.create().withClaim("username",admins.getUsername())
        .withClaim("addtime",admins.getAddtime())
        .withExpiresAt(Date.from(expireDate.atZone(zoneId).toInstant()))
        .sign(Algorithm.HMAC256(SECRET));
    }
    // 校验token
    public static boolean verify(String token){
        try{
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            verifier.verify(token);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    // 获取token内的鞋带的用户名信息
    public static String getUsernameByToken(String token){
        return JWT.decode(token).getClaim("username").asString();
    }
    public static Admins getAdminsByToken(String token){
        DecodedJWT decodedJWT = JWT.decode(token);
        Admins admins = new Admins();
        admins.setUsername(decodedJWT.getClaim("username").asString());
        admins.setAddtime(decodedJWT.getClaim("addtime").asString());
        return admins;
    }

//     public static void main(String[] args){
//         Admins admins = new Admins();
//         admins.setAddtime("2021-04-23 17:52:05");
//         admins.setUsername("admin");
//         String token = AdminsJwtUtils.sign(admins);
//         System.out.println(token);
//         System.out.println("verify toke " + token + "result:" + verify(token));
//         System.out.println("token:"+ token +"username " + getUsernameByToken(token));
//
//     }
}
