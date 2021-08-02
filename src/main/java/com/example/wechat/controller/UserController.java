package com.example.wechat.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.wechat.common.Result;
import com.example.wechat.constant.Error;
import com.example.wechat.entity.User;
import com.example.wechat.exception.CustomException;
import com.example.wechat.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 用户控制器
 *
 * @author fu.yuanming
 * @date 2021-07-29
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "用户管理")
public class UserController {

    private final UserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    public Result<List<User>> list() {
        return Result.success(userService.list());
    }

    @GetMapping("/page")
    @ApiOperation(value = "查询用户列表（分页）", notes = "查询用户列表（分页）")
    public Result<Page<User>> userPage(@RequestParam(required = false, defaultValue = "0") int current,
                             @RequestParam(required = false, defaultValue = "10") int pageSize) {
        Page<User> page = new Page<>(current, pageSize);
        return Result.success(userService.page(page));
    }

    @PostMapping("/addOrUpdate")
    @ApiOperation(value = "新增/修改用户信息", notes = "新增/修改用户信息")
    public Result<Boolean> addOrUpdateUser(@RequestBody User user) {
        return Result.success(userService.saveOrUpdate(user));
    }

    @GetMapping("/detail")
    @ApiOperation(value = "获取用户信息详情", notes = "获取用户信息详情")
    public Result<User> findUserDetail(@RequestParam Long id) {
        User user = userService.getOne(Wrappers.<User>lambdaQuery().eq(User::getId, id));
        return Result.success(user);
    }

    @PostMapping("/delete")
    @ApiOperation(value = "删除用户信息", notes = "删除用户信息")
    public Result<Boolean> deleteUser(@RequestParam Long id) {
        return Result.success(userService.removeById(id));
    }

    @PostMapping("/export")
    @ApiOperation(value = "导出用户信息", notes = "导出用户信息")
    public void exportUser(@ApiIgnore HttpServletResponse response) {
        try {
            userService.exportExcel(response);
        } catch (IOException e) {
            log.error("导出Excel发生错误", e);
            throw new CustomException(Error.ERROR_EXPORT.getCode(), Error.ERROR_EXPORT.getMassage());
        }
    }

}
