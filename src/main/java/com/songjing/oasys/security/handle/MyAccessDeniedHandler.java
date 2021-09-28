package com.songjing.oasys.security.handle;

import com.songjing.oasys.security.JSONAuthentication;
import com.songjing.oasys.security.Result;
import com.songjing.oasys.security.ResultCode;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/5/10 17:12
 */

@Component
public class MyAccessDeniedHandler extends JSONAuthentication implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        Result result = Result.error(ResultCode.NO_PERMISSION);
        this.WriteJSON(request, response, result);
    }
}
