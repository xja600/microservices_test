package com.spring.dao.mybatisplus.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 小滴课堂,愿景：让技术不再难学
 *
 * @Description
 * @Author 二当家小D
 * @Remark 有问题直接联系我，源码-笔记-技术交流群
 * @Version 1.0
 **/
@ApiModel(value = "新增用户请求模型")
@Data
public class SaveUserRequest {

    @ApiModelProperty(value = "主键")
    private int id;

    @ApiModelProperty(value = "邮箱",required = true,example = "794666918@qq.com")
    private String email;

    @ApiModelProperty(value = "手机号",required = false)
    private String phone;

    private  String name;

}
