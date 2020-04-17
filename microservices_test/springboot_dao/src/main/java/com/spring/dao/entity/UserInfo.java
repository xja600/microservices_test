package com.spring.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@TableName("USER_INFO")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

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
    @TableField("LOCATEDCITY")
    private String locatedcity;

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
     * 语言环境
     */
    @TableField("LANGUAGE")
    private String language;

    /**
     * 上级用户
     */
    @TableField("HIGHERUP")
    private String higherup;

    /**
     * 用户类型,null则正常用户,2为合伙人用户
     */
    @TableField("USERTYPE")
    private String usertype;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
    public String getLoginid() {
        return loginid;
    }

    public void setLoginid(String loginid) {
        this.loginid = loginid;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getBelongorg() {
        return belongorg;
    }

    public void setBelongorg(String belongorg) {
        this.belongorg = belongorg;
    }
    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }
    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }
    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3;
    }
    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4;
    }
    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5;
    }
    public String getAttribute6() {
        return attribute6;
    }

    public void setAttribute6(String attribute6) {
        this.attribute6 = attribute6;
    }
    public String getAttribute7() {
        return attribute7;
    }

    public void setAttribute7(String attribute7) {
        this.attribute7 = attribute7;
    }
    public String getAttribute8() {
        return attribute8;
    }

    public void setAttribute8(String attribute8) {
        this.attribute8 = attribute8;
    }
    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
    public String getDescribe1() {
        return describe1;
    }

    public void setDescribe1(String describe1) {
        this.describe1 = describe1;
    }
    public String getDescribe2() {
        return describe2;
    }

    public void setDescribe2(String describe2) {
        this.describe2 = describe2;
    }
    public String getDescribe3() {
        return describe3;
    }

    public void setDescribe3(String describe3) {
        this.describe3 = describe3;
    }
    public String getDescribe4() {
        return describe4;
    }

    public void setDescribe4(String describe4) {
        this.describe4 = describe4;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public String getCerttype() {
        return certtype;
    }

    public void setCerttype(String certtype) {
        this.certtype = certtype;
    }
    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid;
    }
    public String getCompanytel() {
        return companytel;
    }

    public void setCompanytel(String companytel) {
        this.companytel = companytel;
    }
    public String getMobiletel() {
        return mobiletel;
    }

    public void setMobiletel(String mobiletel) {
        this.mobiletel = mobiletel;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getAccountid() {
        return accountid;
    }

    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }
    public String getId1() {
        return id1;
    }

    public void setId1(String id1) {
        this.id1 = id1;
    }
    public String getId2() {
        return id2;
    }

    public void setId2(String id2) {
        this.id2 = id2;
    }
    public Double getSum1() {
        return sum1;
    }

    public void setSum1(Double sum1) {
        this.sum1 = sum1;
    }
    public Double getSum2() {
        return sum2;
    }

    public void setSum2(Double sum2) {
        this.sum2 = sum2;
    }
    public String getInputorg() {
        return inputorg;
    }

    public void setInputorg(String inputorg) {
        this.inputorg = inputorg;
    }
    public String getInputuser() {
        return inputuser;
    }

    public void setInputuser(String inputuser) {
        this.inputuser = inputuser;
    }
    public String getInputdate() {
        return inputdate;
    }

    public void setInputdate(String inputdate) {
        this.inputdate = inputdate;
    }
    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }
    public String getInputtime() {
        return inputtime;
    }

    public void setInputtime(String inputtime) {
        this.inputtime = inputtime;
    }
    public String getUpdateuser() {
        return updateuser;
    }

    public void setUpdateuser(String updateuser) {
        this.updateuser = updateuser;
    }
    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getLocatedcity() {
        return locatedcity;
    }

    public void setLocatedcity(String locatedcity) {
        this.locatedcity = locatedcity;
    }
    public String getEducationalbg() {
        return educationalbg;
    }

    public void setEducationalbg(String educationalbg) {
        this.educationalbg = educationalbg;
    }
    public String getAmlevel() {
        return amlevel;
    }

    public void setAmlevel(String amlevel) {
        this.amlevel = amlevel;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getEducationexp() {
        return educationexp;
    }

    public void setEducationexp(String educationexp) {
        this.educationexp = educationexp;
    }
    public String getVocationexp() {
        return vocationexp;
    }

    public void setVocationexp(String vocationexp) {
        this.vocationexp = vocationexp;
    }
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
    public String getNtid() {
        return ntid;
    }

    public void setNtid(String ntid) {
        this.ntid = ntid;
    }
    public String getBelongteam() {
        return belongteam;
    }

    public void setBelongteam(String belongteam) {
        this.belongteam = belongteam;
    }
    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }
    public String getSkinpath() {
        return skinpath;
    }

    public void setSkinpath(String skinpath) {
        this.skinpath = skinpath;
    }
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    public String getHigherup() {
        return higherup;
    }

    public void setHigherup(String higherup) {
        this.higherup = higherup;
    }
    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
        "userid=" + userid +
        ", loginid=" + loginid +
        ", username=" + username +
        ", password=" + password +
        ", belongorg=" + belongorg +
        ", attribute1=" + attribute1 +
        ", attribute2=" + attribute2 +
        ", attribute3=" + attribute3 +
        ", attribute4=" + attribute4 +
        ", attribute5=" + attribute5 +
        ", attribute6=" + attribute6 +
        ", attribute7=" + attribute7 +
        ", attribute8=" + attribute8 +
        ", attribute=" + attribute +
        ", describe1=" + describe1 +
        ", describe2=" + describe2 +
        ", describe3=" + describe3 +
        ", describe4=" + describe4 +
        ", status=" + status +
        ", certtype=" + certtype +
        ", certid=" + certid +
        ", companytel=" + companytel +
        ", mobiletel=" + mobiletel +
        ", email=" + email +
        ", accountid=" + accountid +
        ", id1=" + id1 +
        ", id2=" + id2 +
        ", sum1=" + sum1 +
        ", sum2=" + sum2 +
        ", inputorg=" + inputorg +
        ", inputuser=" + inputuser +
        ", inputdate=" + inputdate +
        ", updatedate=" + updatedate +
        ", inputtime=" + inputtime +
        ", updateuser=" + updateuser +
        ", updatetime=" + updatetime +
        ", remark=" + remark +
        ", birthday=" + birthday +
        ", gender=" + gender +
        ", locatedcity=" + locatedcity +
        ", educationalbg=" + educationalbg +
        ", amlevel=" + amlevel +
        ", title=" + title +
        ", educationexp=" + educationexp +
        ", vocationexp=" + vocationexp +
        ", position=" + position +
        ", qualification=" + qualification +
        ", ntid=" + ntid +
        ", belongteam=" + belongteam +
        ", lob=" + lob +
        ", skinpath=" + skinpath +
        ", language=" + language +
        ", higherup=" + higherup +
        ", usertype=" + usertype +
        "}";
    }
}
