package com.shoucy.eren.system.entity;

import com.mybatisflex.annotation.Table;
import com.shoucy.eren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户表
 *
 * @author shoucy
 */
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_user")
@Data
public class User extends BaseEntity {

    /**
     * 用户名
     */
    String username;

    /**
     * 密码
     */
    String password;

    /**
     * 电话号码
     */
    String phone;

    /**
     * 邮箱地址
     */
    String email;

    /**
     * 昵称
     */
    String nickname;

    /**
     * 所属部门ID
     */
    String dept_id;

    /**
     * 姓名
     */
    String name;

    /**
     * 头像
     */
    String avatar;

    /**
     * 锁定标记，0未锁定，9已锁定
     */
    String lock_flag;

    /**
     * 删除标记，0未删除，1已删除
     */
    String del_flag;

    /**
     * 微信登录openId
     */
    String wx_openid;

    /**d
     * 小程序openId
     */
    String mini_openid;

}