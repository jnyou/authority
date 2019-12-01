package cn.blithe.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName BCryptPasswordEncoder
 * @Deacription SpringSecurity加密
 * @Author 夏小颜
 * @Date 2019/12/1 18:37
 * @Version 1.0
 **/
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String BCryptPasswordEncoder(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String pwd = BCryptPasswordEncoder("123");
        System.out.println(pwd);  //$2a$10$bLUQWKxqk3gVBVPchXunt.g9CaFMSFZ8IlUD2Rz1oQ5Gp4vvAlf0S
    }
}