package com.tanwan.controller;

import com.tanwan.dto.AuthUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "系统授权接口")
@RestController
@RequestMapping("/system/auth")
public class AuthorizationController {

    @ApiOperation("登录授权")
    @GetMapping(value = "/login")
    public Object login(@Validated @RequestBody AuthUserDto authUser, HttpServletRequest request) {
        return null;
    }
}
