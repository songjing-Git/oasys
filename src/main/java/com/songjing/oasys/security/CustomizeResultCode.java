package com.songjing.oasys.security;

/**
 * @author songjing
 * @version 1.0
 * @date 2021/5/10 16:53
 */
public interface CustomizeResultCode {

    /**
     * 获取错误状态码
     *
     * @return 错误状态码
     */
    Integer getCode();

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    String getMessage();
}
