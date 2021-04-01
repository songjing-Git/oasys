package com.songjing.oasys.pub.controller;

import com.songjing.oasys.pub.entity.MailInfo;
import com.songjing.oasys.pub.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/2/1 11:02
 */
@RestController
@Api
public class EmailSender {

    @Resource
    EmailService emailService;

    @ApiOperation("邮件发送")
    @GetMapping("/send")
    public void send(){
        //发送对象的邮箱
        String mail = "1249932920@qq.com";
        String title = "审批通知";
        String content = "<div>工号:92590</div>" +
                "<div>姓名:宋京</div>" +
                "<div>提交了审批报销</div>" +
                "<br/>" +
                "<button>审批通过</button>" +
                "<button>不通过</button>" ;
        MailInfo info = new MailInfo();
        info.setToAddress(mail);
        info.setSubject(title);
        info.setContent(content);
        try {
            emailService.sendHtmlMail(info);
        } catch (Exception e) {
            System.out.print("'"+title+"'的邮件发送失败！");
            e.printStackTrace();
        }

    }

}
