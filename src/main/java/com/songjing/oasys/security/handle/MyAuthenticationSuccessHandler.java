package com.songjing.oasys.security.handle;

import com.songjing.oasys.security.JSONAuthentication;
import com.songjing.oasys.security.Result;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/5/10 16:55
 */
@Component
public class MyAuthenticationSuccessHandler extends JSONAuthentication implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        Result result = Result.ok().message("登录成功");
        System.out.println("登录成功");
       this.WriteJSON(httpServletRequest,httpServletResponse,result);
    }
}
