package com.shoucy.eren.admin.service;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shoucy.eren.admin.entity.User;
import com.shoucy.eren.admin.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 角色
 *
 * @author shoucy
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
