package com.songjing.oasys.pub.service.impl;

import com.songjing.oasys.pub.entity.MailInfo;
import com.songjing.oasys.pub.service.EmailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/2/1 11:19
 */
@Service
public class EmailServiceImpl implements EmailService {

    //163的服务器
    private final static String host = "smtp.qq.com";
    //你的邮箱
    private final static String formName = "1249932920@qq.com";
    //授权码
    private final static String password = "omelbdslkhpvbacb";
    //你的邮箱
    private final static String replayAddress = "1249932920@qq.com";

    @Override
    public  void sendHtmlMail(MailInfo info) {
        info.setHost(host);
        info.setFormName(formName);
        info.setFormPassword(password);   //网易邮箱的授权码~不一定是密码
        info.setReplayAddress(replayAddress);
        try {
            Message message = getMessage(info);
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(info.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 将MiniMultipart对象设置为邮件内容
            message.setContent(mainPart);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public  void sendTextMail(MailInfo info) {

        info.setHost(host);
        info.setFormName(formName);
        info.setFormPassword(password);   //网易邮箱的授权码~不一定是密码
        info.setReplayAddress(replayAddress);
        try {
            Message message = getMessage(info);
            //消息发送的内容
            message.setText(info.getContent());

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private    Message getMessage(MailInfo info) throws Exception {
        final Properties p = System.getProperties();
        p.setProperty("mail.smtp.host", info.getHost());
        p.setProperty("mail.smtp.auth", "true");
        p.setProperty("mail.smtp.user", info.getFormName());
        p.setProperty("mail.smtp.pass", info.getFormPassword());

        // 根据邮件会话属性和密码验证器构造一个发送邮件的session
        Session session = Session.getInstance(p, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(p.getProperty("mail.smtp.user"), p.getProperty("mail.smtp.pass"));
            }
        });
        session.setDebug(true);
        Message message = new MimeMessage(session);
        //消息发送的主题
        message.setSubject(info.getSubject());
        //接受消息的人
        message.setReplyTo(InternetAddress.parse(info.getReplayAddress()));
        //消息的发送者
        message.setFrom(new InternetAddress(p.getProperty("mail.smtp.user"), "宋京"));
        // 创建邮件的接收者地址，并设置到邮件消息中
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(info.getToAddress()));
        // 消息发送的时间
        message.setSentDate(new Date());


        return message;
    }


}
