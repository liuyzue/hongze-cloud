package com.hongze.core.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.hongze.core.common.constant.WebConstants;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuyuze
 * @date 2024/11/15 15:16
 *
 * 通用响应类，用于封装接口返回数据
 * 该类实现了Serializable接口，以支持对象的序列化和反序列化
 * @param <T> 泛型参数，用于存放响应数据
 */
@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = -2273831007598772671L;

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应时间戳
     */
    private long timestamp;

    /**
     * 响应数据，当数据为空时，不会被序列化到JSON中
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    /**
     * 私有无参构造方法，初始化时间戳
     */
    private R() {
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 私有全参构造方法，初始化响应对象
     * @param code 响应状态码
     * @param data 响应数据
     * @param msg 响应消息
     */
    private R(int code, T data, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 私有构造方法，根据状态和数据初始化响应对象
     * @param status 响应状态枚举
     * @param data 响应数据
     */
    private R(WebConstants.Status status, T data) {
        this.code = status.getCode();
        this.msg = status.getMsg();
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 私有构造方法，根据状态、消息和数据初始化响应对象
     * @param status 响应状态枚举
     * @param msg 响应消息
     * @param data 响应数据
     */
    private R(WebConstants.Status status,String msg, T data) {
        this.code = status.getCode();
        this.msg = msg;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * 静态方法，用于创建成功的响应对象
     * @param <T> 泛型参数
     * @return 成功的响应对象，不含数据
     */
    public static <T> R<T> success() {
        return new R<>(WebConstants.Status.SUCCESS, null);
    }

    /**
     * 静态方法，用于创建含指定数据的成功响应对象
     * @param data 响应数据
     * @param <T> 泛型参数
     * @return 含指定数据的成功响应对象
     */
    public static <T> R<T> success(T data) {
        return new R<>(WebConstants.Status.SUCCESS, data);
    }

    /**
     * 静态方法，用于创建失败的响应对象
     * @param <T> 泛型参数
     * @return 失败的响应对象，不含数据
     */
    public static <T> R<T> fail() {
        return new R<>(WebConstants.Status.INTERNAL_SERVER_ERROR, null);
    }

    /**
     * 静态方法，用于创建含指定消息的失败响应对象
     * @param msg 响应消息
     * @param <T> 泛型参数
     * @return 含指定消息的失败响应对象
     */
    public static <T> R<T> fail(String msg) {
        return new R<>(WebConstants.Status.INTERNAL_SERVER_ERROR,msg,null);
    }

    /**
     * 判断响应是否成功
     * @return 如果成功则返回true，否则返回false
     */
    public boolean isSuccess() {
        return this.code == WebConstants.Status.SUCCESS.getCode();
    }

    /**
     * 判断响应是否失败
     * @return 如果失败则返回true，否则返回false
     */
    public boolean isFail() {
        return !isSuccess();
    }
}

