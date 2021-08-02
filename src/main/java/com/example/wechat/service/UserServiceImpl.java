package com.example.wechat.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.wechat.constant.Error;
import com.example.wechat.entity.User;
import com.example.wechat.exception.CustomException;
import com.example.wechat.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fu.yuanming
 * @date 2021-07-29
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<User> userList = baseMapper.selectList(Wrappers.emptyWrapper());
        if (CollUtil.isEmpty(userList)) {
            throw new CustomException(Error.ERROR_EXPORT_EMPTY.getCode(), Error.ERROR_EXPORT_EMPTY.getMassage());
        }
        List<Map<String, Object>> list = new ArrayList<>();
        for (User user : userList) {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("账号", user.getUsername());
            map.put("用户名", user.getName());
            String sex;
            if (user.getSex() == 0) {
                sex = "未知";
            } else {
                sex = user.getSex() == 1 ? "男" : "女";
            }
            map.put("性别", sex);
            list.add(map);
        }
        String fileName = "用户信息";
        // 导出Excel
        exportExcel(fileName, list, response);
    }

    private void exportExcel(String fileName, List<Map<String, Object>> data, HttpServletResponse response) throws IOException {
        ExcelWriter writer = ExcelUtil.getBigWriter();
        writer.renameSheet(fileName);
        // 写入Excel数据
        writer.write(data, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
        writer.flush(response.getOutputStream(), true);
        writer.close();
    }

}
