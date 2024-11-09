package com.shoucy.eren.system.service;

import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.shoucy.eren.system.entity.User;
import com.shoucy.eren.system.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * 角色
 *
 * @author shoucy
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

}
