package com.spring.dao.mybatisplus.controller;

import com.spring.dao.mybatisplus.constant.HttpCodeStatus;
import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import com.spring.dao.mybatisplus.request.SaveUserRequest;
import com.spring.dao.mybatisplus.service.JsonData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
/*import net.xdclass.shopmanager.constant.HttpCodeStatus;
import net.xdclass.shopmanager.model.User;
import net.xdclass.shopmanager.util.JsonData;*/
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/

@RestController
@RequestMapping("/api/controller/dao/swaggerUser")
@Api(tags = "用户模块",value = "用户controller")
public class SwaggerUserController {


    /**
     * http://localhost:8080/api/controller/dao/swaggerUser/list
     * http://localhost:8080/swagger-ui/index.html
     * @return
     */
    @ApiOperation("用户列表")
    //@RequestMapping("list")
    @GetMapping("list")
    public JsonData list(){

        UserInfoPlus user1 = UserInfoPlus.builder().userid("xja600").username("测试swagger1").email("794666918@qq.com").build();
        UserInfoPlus user2 = UserInfoPlus.builder().userid("xja600").username("测试swagger2").email("794666918@qq.com").build();
        List list = new ArrayList();
        list.add(user1);
        list.add(user2);
        return JsonData.buildSuccess(list);
    }

    @ApiOperation("查看用户详情")
    @GetMapping("detail")
    public JsonData query(@ApiParam(name = "id",value = "用户id",example = "1")@RequestParam("id") int id){
        return JsonData.buildSuccess();
    }

    @ApiOperation("用户登录")
    @PostMapping("login")
    @ApiResponses({
            @ApiResponse(responseCode = HttpCodeStatus.REDIRECT, description = "重定向,跳转登录"),
            @ApiResponse(responseCode = "403",description = "没权限"),
    })
    public JsonData login(
            @ApiParam(name = "phone", value = "手机号",example = "13888888888")
            @RequestParam("phone") String phone,
            @ApiParam(name = "pwd", value = "密码",example = "123456")
            @RequestParam("pwd")String pwd){

        return JsonData.buildSuccess();
    }

    @ApiIgnore
    @ApiOperation("根据id删除用户")
    @DeleteMapping("/delete/{id}")
    public JsonData delById(
            @ApiParam(name = "id",value = "用户id",example = "1")
            @PathVariable int id){
        return JsonData.buildSuccess();
    }

    @ApiOperation("新增用户")
    @PostMapping("save")
    //public JsonData save(SaveUserRequest userRequest){
    public JsonData save(@RequestBody SaveUserRequest userRequest){
        return JsonData.buildSuccess();
    }
}
