package com.hongze.core.common.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 登录用户信息
 *
 * @author liuyuze
 */
@Data
public class LoginUser implements Serializable {

    // 序列化ID，用于标识类的版本
    private static final long serialVersionUID = -1663615739553199455L;

    // 用户ID，唯一标识一个用户
    private String id;

    // 用户账号，用于登录系统
    private String account;

    // 用户姓名，用于显示用户的真实姓名
    private String username;

    // 用户昵称，用户在系统中的别名
    private String nickname;

    // 租户ID，用于多租户系统中标识用户所属的租户
    private String tenantId;

    // 岗位ID，标识用户所在的岗位
    private String postId;

    // 角色ID，标识用户的角色
    private String roleId;

    // 角色名称，用户角色的可读名称
    private String roleName;

    // 用户类型，用于区分不同类型的用户
    private int type;
}

