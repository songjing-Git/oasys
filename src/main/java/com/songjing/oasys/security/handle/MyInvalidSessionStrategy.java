package com.songjing.oasys.security.handle;

import com.songjing.oasys.security.JSONAuthentication;
import com.songjing.oasys.security.Result;
import com.songjing.oasys.security.ResultCode;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/5/12 15:41
 */
@Component("myInvalidSessionStrategy")
public class MyInvalidSessionStrategy extends JSONAuthentication implements InvalidSessionStrategy {
    @Override
    public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Result result = Result.error(ResultCode.USER_SESSION_INVALID);
        this.WriteJSON(request,response,result);
    }
}
