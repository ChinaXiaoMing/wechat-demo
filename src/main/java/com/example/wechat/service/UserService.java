package com.example.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.wechat.entity.User;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户服务
 *
 * @author fu.yuanming
 * @date 2021-07-29
 */
public interface UserService extends IService<User> {

    /**
     * 导出excel
     *
     * @param response 响应
     * @throws IOException ioexception
     */
    void exportExcel(HttpServletResponse response) throws IOException;

}
