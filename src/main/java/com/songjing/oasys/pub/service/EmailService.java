package com.songjing.oasys.pub.service;

import com.songjing.oasys.pub.entity.MailInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/2/1 11:19
 */
public interface EmailService {


    /**
     *发送html格式邮件带附件
     * @param info
     * @param file
     */
    void sendHtmlMail(MailInfo info, MultipartFile file);

    /**
     * 发送html格式邮件
     * @param info
     */
    void sendHtmlMail(MailInfo info);
    /**
  * 发送文本格式邮件
     * @param info
     */
    void sendTextMail(MailInfo info);
}
