package com.spring.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("CODE_LIBRARY")
public class CodeLibrary implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 代码编号
     */
    @TableId("CODENO")
    private String codeno;

    /**
     * 代码项编号
     */
    @TableField("ITEMNO")
    private String itemno;

    /**
     * 代码项名称
     */
    @TableField("ITEMNAME")
    private String itemname;

    /**
     * 征信代码
     */
    @TableField("BANKNO")
    private String bankno;

    /**
     * 排序号
     */
    @TableField("SORTNO")
    private String sortno;

    /**
     * 是否使用
     */
    @TableField("ISINUSE")
    private String isinuse;

    /**
     * 代码项描述
     */
    @TableField("ITEMDESCRIBE")
    private String itemdescribe;

    /**
     * 代码项属性
     */
    @TableField("ITEMATTRIBUTE")
    private String itemattribute;

    /**
     * 相关代码
     */
    @TableField("RELATIVECODE")
    private String relativecode;

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
     * 录入人
     */
    @TableField("INPUTUSER")
    private String inputuser;

    /**
     * 录入机构
     */
    @TableField("INPUTORG")
    private String inputorg;

    /**
     * 录入时间
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
     * HELPTEXT
     */
    @TableField("HELPTEXT")
    private String helptext;

    public String getItemno() {
        return itemno;
    }

    public void setItemno(String itemno) {
        this.itemno = itemno;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getCodeno() {
        return codeno;
    }

    public void setCodeno(String codeno) {
        this.codeno = codeno;
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno;
    }
    public String getSortno() {
        return sortno;
    }

    public void setSortno(String sortno) {
        this.sortno = sortno;
    }
    public String getIsinuse() {
        return isinuse;
    }

    public void setIsinuse(String isinuse) {
        this.isinuse = isinuse;
    }
    public String getItemdescribe() {
        return itemdescribe;
    }

    public void setItemdescribe(String itemdescribe) {
        this.itemdescribe = itemdescribe;
    }
    public String getItemattribute() {
        return itemattribute;
    }

    public void setItemattribute(String itemattribute) {
        this.itemattribute = itemattribute;
    }
    public String getRelativecode() {
        return relativecode;
    }

    public void setRelativecode(String relativecode) {
        this.relativecode = relativecode;
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
    public String getInputuser() {
        return inputuser;
    }

    public void setInputuser(String inputuser) {
        this.inputuser = inputuser;
    }
    public String getInputorg() {
        return inputorg;
    }

    public void setInputorg(String inputorg) {
        this.inputorg = inputorg;
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
    public String getHelptext() {
        return helptext;
    }

    public void setHelptext(String helptext) {
        this.helptext = helptext;
    }

    @Override
    public String toString() {
        return "CodeLibrary{" +
        "codeno=" + codeno +
        ", itemno=" + itemno +
        ", itemname=" + itemname +
        ", bankno=" + bankno +
        ", sortno=" + sortno +
        ", isinuse=" + isinuse +
        ", itemdescribe=" + itemdescribe +
        ", itemattribute=" + itemattribute +
        ", relativecode=" + relativecode +
        ", attribute1=" + attribute1 +
        ", attribute2=" + attribute2 +
        ", attribute3=" + attribute3 +
        ", attribute4=" + attribute4 +
        ", attribute5=" + attribute5 +
        ", attribute6=" + attribute6 +
        ", attribute7=" + attribute7 +
        ", attribute8=" + attribute8 +
        ", inputuser=" + inputuser +
        ", inputorg=" + inputorg +
        ", inputtime=" + inputtime +
        ", updateuser=" + updateuser +
        ", updatetime=" + updatetime +
        ", remark=" + remark +
        ", helptext=" + helptext +
        "}";
    }
}
