package com.songjing.oasys.pub.service.impl;

import com.songjing.oasys.pub.entity.MailInfo;
import com.songjing.oasys.pub.service.EmailService;
import com.songjing.oasys.utils.MultipartFileToFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

    /**
     * qq的服务器
     */
    private final static String HOST = "smtp.qq.com";
    /**
     * 你的邮箱
     */
    private final static String FORM_NAME = "1249932920@qq.com";
    /**
     * 授权码
     */
    private final static String PASSWORD = "omelbdslkhpvbacb";
    /**
     * 你的邮箱
     */
    private final static String REPLAY_ADDRESS = "1249932920@qq.com";



    @Override
    public  void sendHtmlMail(MailInfo info, MultipartFile file) {
        info.setHost(HOST);
        info.setFormName(FORM_NAME);
        //网易邮箱的授权码~不一定是密码
        info.setFormPassword(PASSWORD);
        info.setReplayAddress(REPLAY_ADDRESS);
        try {
            Message message = getMessage(info);
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(info.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
            // 遍历添加附件
            BodyPart attachmentBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(MultipartFileToFile.multipartFileToFile(file));
            attachmentBodyPart.setDataHandler(new DataHandler(source));
            attachmentBodyPart.setFileName(file.getOriginalFilename());
            mainPart.addBodyPart(attachmentBodyPart);
           /* if (fileList != null && fileList.size() > 0) {
                for (File file : fileList) {
                    BodyPart attachmentBodyPart = new MimeBodyPart();
                    DataSource source = new FileDataSource(file);
                    attachmentBodyPart.setDataHandler(new DataHandler(source));
                    attachmentBodyPart.setFileName(file.getName());
                    mainPart.addBodyPart(attachmentBodyPart);
                }
            }*/

            message.setContent(mainPart);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sendHtmlMail(MailInfo info) {
        info.setHost(HOST);
        info.setFormName(FORM_NAME);
        //网易邮箱的授权码~不一定是密码
        info.setFormPassword(PASSWORD);
        info.setReplayAddress(REPLAY_ADDRESS);
        try {
            Message message = getMessage(info);
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(info.getContent(), "text/html; charset=utf-8");
            mainPart.addBodyPart(html);
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

        info.setHost(HOST);
        info.setFormName(FORM_NAME);
        info.setFormPassword(PASSWORD);   //网易邮箱的授权码~不一定是密码
        info.setReplayAddress(REPLAY_ADDRESS);
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
