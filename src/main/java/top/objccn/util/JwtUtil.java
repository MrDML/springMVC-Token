package top.objccn.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

/**
 * @Auter MrDML
 * @Date 2019-09-30
 */
@Component
public class JwtUtil {


    /**
     * 过期时间
     */
    @Value("${jwt.exepire_time_minute}")
    private String exepire_time_minute;


    /**
     * token 私钥
     *
     */
    @Value("${jwt.token_secret}")
    private String token_secret;



    /**
     *  获取用户名
     *  获得token中的信息无需secret解密也能获得
     * @param token
     * @return
     */
    public  String getUserName(String token){

        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = JWT.decode(token);
            String loginName = decodedJWT.getClaim("uname").asString();
            return loginName;
        } catch (JWTDecodeException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     *  获取用户id
     * @param token
     * @return
     */
    public String getUserId(String token){

        DecodedJWT decodedJWT = null;
        try {
             decodedJWT = JWT.decode(token);
            String uid = decodedJWT.getClaim("uid").asString();
            return uid;
        } catch (JWTDecodeException e) {
            e.printStackTrace();
        }
        return null;
    }



    /**
     * 校验token 信息
     * @param token
     * @return
     */
    public  Boolean verifyToken(String token){


        try {
            Algorithm algorithm = Algorithm.HMAC256(token_secret);

            JWTVerifier verifier = JWT.require(algorithm).build();

            DecodedJWT decodedJWT = verifier.verify(token);

           return  (decodedJWT != null)? true : false;

        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 生成token
     * @param uname
     * @param uid
     * @return
     */
    public String createToekn(String uname,String uid){

        try {
            HashMap<String, Object> headerClaims = new HashMap<>();
            headerClaims.put("type","jwt");
            headerClaims.put("alg","HS256");


            // 过期时间,分为单位
            Long exepire_time = 1000 * 60  * Long.parseLong(exepire_time_minute);

            System.out.println("TOKEN_SECRET:"+token_secret);
            System.out.println("EXPIRE_TIME:"+exepire_time);

            Algorithm algorithm = Algorithm.HMAC256(token_secret);

            // 过期时间
            Date EXPIR_DATE = new Date(System.currentTimeMillis() + exepire_time);

            String sign =
                    JWT.create()
                            .withHeader(headerClaims)    // 1. 设置头信息
                            .withClaim("uname", uname) // 2. 设置载荷信息
                            .withClaim("uid", uid) // 2. 设置载荷信息
                            .withExpiresAt(EXPIR_DATE) // 3. 设置签名信息
                            .sign(algorithm);

            return sign;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }











}
