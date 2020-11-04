package com.tanwan.controller;

import com.tanwan.entity.SysUser;
import com.tanwan.service.SysUserService;
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
@RequestMapping("/sysUser")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation("添加用户")
    @PostMapping("/addUser")
    public String addUser(@RequestBody @Valid SysUser sysUser) {
        return "success";
    }

    @ApiOperation("获得单个用户")
    @GetMapping("/getUser")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户Id"),
            @ApiImplicitParam(name = "userName", value = "用户名称", defaultValue = "游客")
    })
    public SysUser getUser(@RequestParam @NotNull String id,
                           String userName) {

        return sysUserService.getById(id);
    }
}