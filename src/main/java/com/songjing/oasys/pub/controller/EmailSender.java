package com.songjing.oasys.pub.controller;

import com.songjing.oasys.entity.Project;
import com.songjing.oasys.pub.entity.MailInfo;
import com.songjing.oasys.pub.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/2/1 11:02
 */
@RestController
@Api
@Slf4j
public class EmailSender {
    private final static String mail="1249932920@qq.com";

    @Resource
    EmailService emailService;

    @ApiOperation("审批报销邮件发送")
    @GetMapping("/send")
    public void send(){
        //发送对象的邮箱

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
            emailService.sendHtmlMail(info,null);
        } catch (Exception e) {
            System.out.print("'"+title+"'的邮件发送失败！");
            e.printStackTrace();
        }

    }

    @ApiOperation("内推职位发送邮件")
    @PostMapping("/pushSend")
    public void send( @RequestParam(required = false) MultipartFile file){
        //发送对象的邮箱
        String title = "职位查看通知";
        String content = "<div>工号:92590</div>" +
                "<div>姓名:宋京</div>" +
                "<div>内推了一名优秀员工,员工信息见附件</div>" +
                "<br/>" +
                "<button>审批通过</button>" +
                "<button>不通过</button>" ;
        MailInfo info = new MailInfo();
        info.setToAddress(mail);
        info.setSubject(title);
        info.setContent(content);
        try {
            emailService.sendHtmlMail(info,file);
        } catch (Exception e) {
            System.out.print("'"+title+"'的邮件发送失败！");
            e.printStackTrace();
        }
    }

    @ApiOperation("报销审批邮件")
    @PostMapping(value = "send/reimbursement")
    public void sendRmb(@RequestBody List<Map<String,Object>> param){
        log.info("===============param:"+param);
        //发送对象的邮箱
        String title = "报销审批通知";
        String content = "<div>工号:92590</div>" +
                "<div>姓名:宋京</div>" +
                "<div>"+param+"</div>" +
                "<br/>" +
                "<button>审批通过</button>   " +
                "  <button>不通过</button>" ;
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


    @ApiOperation("项目申请审批")
    @PostMapping("/send/projectApp")
    public void sendProjectApp(@RequestBody Project param) {
        String title = "项目申请审批通知";
        String content = "<div>工号:92590</div>" +
                "<div>姓名:宋京</div>" +
                "<div>"+param+"</div>" +
                "<br/>" +
                "<button>审批通过</button>   " +
                "  <button>不通过</button>" ;
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
