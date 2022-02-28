package com.spring.dao.mybatisplus.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 新增用户信息请求体
 */
@ApiModel(value = "新增用户请求模型")
@Data
public class ReqAddUserInfoDTO {

    @ApiModelProperty(value = "用户id",required = true,example = "test123")
    private String userid;

    @ApiModelProperty(value = "用户名称",required = true,example = "张三")
    private String username;

    @ApiModelProperty(value = "备注",required = false)
    private String attribute;

}
