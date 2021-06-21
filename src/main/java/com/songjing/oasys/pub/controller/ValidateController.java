package com.songjing.oasys.pub.controller;

import com.songjing.oasys.utils.ValidateUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/4/26 14:57
 */
@RestController
@Api
@Slf4j
public class ValidateController {
    /**
     * 生成验证码
     */
    public static final String VERIFY_ID = "verid";

    @Resource
    RedisTemplate<String, Object> redisTemplate;

    @RequestMapping("/getCodeImg")
    public void getCodeImg(HttpServletRequest request, HttpServletResponse response) {
        try {
            Object[] objs = ValidateUtils.createImage();
            String code = objs[0].toString();
            String verid = UUID.randomUUID().toString().replaceAll("-", "");
            //将uuid串存入cookie
            Cookie cookie=new Cookie(VERIFY_ID, verid);
            response.addCookie(cookie);
            //将验证码存入redis
            redisTemplate.opsForValue().set(verid, code, 3600);

            /**
             * log.info("verid:"+verid);
             log.info("code:"+code);
             */
            BufferedImage image = (BufferedImage) objs[1];
            response.setContentType("image/png");
            OutputStream os = response.getOutputStream();
            //输出验证码图片文件流
            ImageIO.write(image, "png", os);
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * 登陆验证
     */
    /*@RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public LoginResult login(HttpServletRequest request,
                             HttpServletResponse response,
                             @RequestParam("username") String username,
                             @RequestParam("password") String password,
                             @RequestParam("vercode") String vercode) {

        LoginResult result1=new LoginResult();

        //Verification Code
        if(!StringUtils.hasText(vercode)){
            result1.setResultCode(400);
            result1.setResultMessage("请输入验证码");
            return result1;
        }
        String verid= CookieUtil.getValue(request,"verid");      //从cookie获取uuid串
        String redisVerCode=null;
        if(StringUtils.hasText(verid)){
            redisVerCode= JedisUtil.getStringValue(verid);       //从redis获取验证码
            JedisUtil.del("verid"+verid);
        }
        if(verid==null || redisVerCode==null){
            result1.setResultCode(400);
            result1.setResultMessage("验证码已过期，请刷新验证码");
            return result1;
        }
        CookieUtil.remove(request,response,"verid");
        if(!redisVerCode.equalsIgnoreCase(vercode)){     //比对验证码
            result1.setResultCode(ConstantsInit.PARAMS_ERROR);
            result1.setResultMessage("验证码错误");
            return result1;
        }

        //验证码校验通过
        //开始验证用户名密码，过程省略。。。
        return result1;
    }*/

}
