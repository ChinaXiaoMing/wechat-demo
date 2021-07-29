package com.example.wechat.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wechat.entity.User;
import com.example.wechat.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author fu.yuanming
 * @date 2021-07-29
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
