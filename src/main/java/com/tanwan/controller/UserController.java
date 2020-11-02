package com.tanwan.controller;

import com.tanwan.entity.User;
import com.tanwan.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Api(tags = "用户管理接口")
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid User user) {
        return "success";
    }

    @ApiOperation("获得单个用户")
    @GetMapping("/getUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户Id"),
            @ApiImplicitParam(name = "userName", value = "用户名称", defaultValue = "游客")
    })
    public User getUser(@RequestParam @NotNull String userId,
                        String userName) {
        User user = new User();
        user.setId(1L);
        user.setAccount("12345678");
        user.setPassword("12345678");
        user.setEmail("123@qq.com");
        return user;
    }
}