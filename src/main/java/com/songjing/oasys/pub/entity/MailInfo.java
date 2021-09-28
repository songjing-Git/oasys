package com.songjing.oasys.pub.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/3/10 9:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailInfo {

    /**
     * 邮箱服务器
     */
    private String host;

    /**
     * 用户邮箱
     */
    private String formName;

    /**
     * 用户授权码
     */
    private String formPassword;

    /**
     * 消息回复邮箱
     */
    private String replayAddress;

    /**
     * 发送地址
     */
    private String toAddress;

    /**
     * 发送主题
     */
    private String subject;

    /**
     * 发送内容
     */
    private String content;
}
