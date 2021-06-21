package com.songjing.oasys.security.handle;

import com.songjing.oasys.security.JSONAuthentication;
import com.songjing.oasys.security.Result;
import com.songjing.oasys.security.ResultCode;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/5/10 17:14
 */
@Component
public class MyExpiredSessionStrategy extends JSONAuthentication implements SessionInformationExpiredStrategy {
    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        Result result = Result.error(ResultCode.USER_ACCOUNT_USE_BY_OTHERS);
        this.WriteJSON(event.getRequest(),event.getResponse(),result);
    }
}
