package com.spring.dao.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.dao.mybatisplus.constant.HttpCodeStatus;
import com.spring.dao.mybatisplus.entity.UserInfoPlus;
import com.spring.dao.mybatisplus.mapper.UserInfoPlusMapper;
import com.spring.dao.mybatisplus.request.ReqAddUserInfoDTO;
import com.spring.dao.mybatisplus.request.SaveUserRequest;
import com.spring.dao.mybatisplus.service.JsonData;
import com.spring.dao.mybatisplus.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;

/*import net.xdclass.shopmanager.constant.HttpCodeStatus;
import net.xdclass.shopmanager.model.User;
import net.xdclass.shopmanager.util.JsonData;*/

/**
 *
 */
@RestController
@RequestMapping("/api/controller/dao/swaggerUser2")
@Api(tags = "我的-用户模块",value = "用户controller")
@Slf4j
public class SwaggerUserController2 {

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private UserInfoPlusMapper userInfoPlusMapper;
    /**
     * http://localhost:8080/api/controller/dao/swaggerUser/list
     * http://localhost:8080/swagger-ui/index.html
     * 请求参数：页数、行数
     * @return
     */
    @ApiOperation("用户列表")
    //@RequestMapping("list")
    @GetMapping("getUserlist")
    //@ApiParam(name = "id",value = "用户id",example = "1")@RequestParam("id") int id
    public JsonData getUserlist(@ApiParam(name = "current",value = "页数",example = "1")@RequestParam("current") int current,
                                @ApiParam(name = "size",value = "行数",example = "10")@RequestParam("size") int size){
        log.info("--getUserlist-----current[{}],size[{}]",current,size);
        Page<UserInfoPlus> page  = new Page<>(current,size);
        IPage<UserInfoPlus> iPage =  userInfoPlusMapper.selectPage(page,null);
        log.info("总条数:{}",iPage.getTotal());
        log.info("总页数:{}",iPage.getPages());
        log.info("数据：{}",iPage.getRecords());
        return JsonData.buildSuccess(iPage.getRecords());
    }
    @ApiOperation("新增用户")
    @PostMapping("insertUserInfo")
    //public JsonData save(SaveUserRequest userRequest){
    @ApiResponses({
            @ApiResponse(responseCode = HttpCodeStatus.SUCCESS, description = "新增成功"),
            @ApiResponse(responseCode = HttpCodeStatus.CODE_401, description = "You are not authorized to view the resource"),
            @ApiResponse(responseCode = HttpCodeStatus.CODE_401, description = "Accessing the resource you were trying to reach is forbidden"),
    })
    public JsonData insertUserInfo(@RequestBody ReqAddUserInfoDTO reqAddUserInfoDTO){
        log.info("--insertUserInfo-reqAddUserInfoDTO[{}]",reqAddUserInfoDTO);
        UserInfoPlus userInfoPlusQry = userInfoPlusMapper.selectOne(new QueryWrapper<UserInfoPlus>().eq("USERID",reqAddUserInfoDTO.getUserid()));
        if(userInfoPlusQry != null){
            return JsonData.builder().code(10001).msg("该用户已经存在，请确认客户编号是否正确").build();
        }
        //示例：UserInfoPlus.builder().userid("").build();

        UserInfoPlus userInfoPlus = new UserInfoPlus();
        BeanUtils.copyProperties(reqAddUserInfoDTO,userInfoPlus);
        log.info("---userInfoPlus[{}]",userInfoPlus);
        userInfoPlusMapper.insert(userInfoPlus);
        return JsonData.buildSuccess();
    }

    @ApiOperation("根据客户编号查询用户信息")
    @GetMapping("getUserInfoById")
    public JsonData getUserInfoById(@ApiParam(name = "userId",value = "用户编号",example = "1")@RequestParam("userId") String userId){
        log.info("--getUserInfoById-----userId[{}]",userId);
        UserInfoPlus userInfoPlus = userInfoPlusMapper.selectOne(new QueryWrapper<UserInfoPlus>().eq("USERID",userId));
        if(userInfoPlus == null){
            return JsonData.builder().code(10002).msg("该用户不存在，请确认客户编号是否正确").build();
        }
        log.info("数据,userInfoPlus：{}",userInfoPlus);
        return JsonData.buildSuccess(userInfoPlus);
    }

}
