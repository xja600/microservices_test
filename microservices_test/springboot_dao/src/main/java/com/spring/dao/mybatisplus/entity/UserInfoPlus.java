package com.spring.dao.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <p>
 * 用户基本信息
 * </p>
 *
 * @author luochongping
 * @since 2019-04-08
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@TableName("USER_INFO")
public class UserInfoPlus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 乐观锁版本号
     */
    @Version
    private Integer version;

    /**
     * 逻辑删除标识位
     */
    private Integer deleted;

    /**
     * 用户工号
     */
    @TableId("USERID")
    private String userid;

    /**
     * 登录账号
     */
    @TableField("LOGINID")
    private String loginid;

    /**
     * 用户姓名
     */
    @TableField("USERNAME")
    private String username;

    /**
     * 用户密码
     */
    @TableField("PASSWORD")
    private String password;

    /**
     * 所属机构
     */
    @TableField("BELONGORG")
    private String belongorg;

    /**
     * 属性一
     */
    @TableField("ATTRIBUTE1")
    private String attribute1;

    /**
     * 属性二
     */
    @TableField("ATTRIBUTE2")
    private String attribute2;

    /**
     * 属性三
     */
    @TableField("ATTRIBUTE3")
    private String attribute3;

    /**
     * 属性四
     */
    @TableField("ATTRIBUTE4")
    private String attribute4;

    /**
     * 属性五
     */
    @TableField("ATTRIBUTE5")
    private String attribute5;

    /**
     * 属性六
     */
    @TableField("ATTRIBUTE6")
    private String attribute6;

    /**
     * 属性七
     */
    @TableField("ATTRIBUTE7")
    private String attribute7;

    /**
     * 属性八
     */
    @TableField("ATTRIBUTE8")
    private String attribute8;

    /**
     * 属性集
     */
    @TableField("ATTRIBUTE")
    private String attribute;

    /**
     * 用户类型
     */
    @TableField("DESCRIBE1")
    private String describe1;

    /**
     * 描述二
     */
    @TableField("DESCRIBE2")
    private String describe2;

    /**
     * 描述三
     */
    @TableField("DESCRIBE3")
    private String describe3;

    /**
     * 描述四
     */
    @TableField("DESCRIBE4")
    private String describe4;

    /**
     * 状态
     */
    @TableField("STATUS")
    private String status;

    /**
     * 证件类型
     */
    @TableField("CERTTYPE")
    private String certtype;

    /**
     * 用户身份证号
     */
    @TableField("CERTID")
    private String certid;

    /**
     * 单位电话
     */
    @TableField("COMPANYTEL")
    private String companytel;

    /**
     * 手机号码
     */
    @TableField("MOBILETEL")
    private String mobiletel;

    /**
     * 电子邮件
     */
    @TableField("EMAIL")
    private String email;

    /**
     * 个贷系统编号
     */
    @TableField("ACCOUNTID")
    private String accountid;

    /**
     * 编号1
     */
    @TableField("ID1")
    private String id1;

    /**
     * 编号2
     */
    @TableField("ID2")
    private String id2;

    /**
     * 相关金额1
     */
    @TableField("SUM1")
    private Double sum1;

    /**
     * 相关金额2
     */
    @TableField("SUM2")
    private Double sum2;

    /**
     * 登记单位
     */
    @TableField("INPUTORG")
    private String inputorg;

    /**
     * 登记人
     */
    @TableField("INPUTUSER")
    private String inputuser;

    /**
     * 登记日期
     */
    @TableField("INPUTDATE")
    private String inputdate;

    /**
     * 更新日期
     */
    @TableField("UPDATEDATE")
    private String updatedate;

    /**
     * 登记时间
     */
    @TableField("INPUTTIME")
    private String inputtime;

    /**
     * 更新人
     */
    @TableField("UPDATEUSER")
    private String updateuser;

    /**
     * 更新时间
     */
    @TableField("UPDATETIME")
    private String updatetime;

    /**
     * 备注
     */
    @TableField("REMARK")
    private String remark;

    /**
     * 生日
     */
    @TableField("BIRTHDAY")
    private String birthday;

    /**
     * 性别
     */
    @TableField("GENDER")
    private String gender;

    /**
     * 用户所在城市
     */
    /*@TableField("LOCATEDCITY")
    private String locatedcity;*/

    /**
     * 学历
     */
    @TableField("EDUCATIONALBG")
    private String educationalbg;

    /**
     * 客户经理级别
     */
    @TableField("AMLEVEL")
    private String amlevel;

    /**
     * 行内职务
     */
    @TableField("TITLE")
    private String title;

    /**
     * 教育经历
     */
    @TableField("EDUCATIONEXP")
    private String educationexp;

    /**
     * 工作经历
     */
    @TableField("VOCATIONEXP")
    private String vocationexp;

    /**
     * 职称
     */
    @TableField("POSITION")
    private String position;

    /**
     * 任职资格
     */
    @TableField("QUALIFICATION")
    private String qualification;

    /**
     * NTID
     */
    @TableField("NTID")
    private String ntid;

    /**
     * 所属团队
     */
    @TableField("BELONGTEAM")
    private String belongteam;

    /**
     * [NEW] 业务条线
     */
    @TableField("LOB")
    private String lob;

    /**
     * UI皮肤路径
     */
    @TableField("SKINPATH")
    private String skinpath;

    /**
     * 版本号
     */
  /*  @Version
    private Integer version;*/

    /**
     * 语言环境
     */
   /* @TableField("LANGUAGE")
    private String language;*/

    /**
     * 上级用户
     */
   /* @TableField("HIGHERUP")
    private String higherup;*/

    /**
     * 用户类型,null则正常用户,2为合伙人用户
     */
/*    @TableField("USERTYPE")
    private String usertype;*/

}
