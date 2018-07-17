package com.kalix.general.person.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * Created by Administrator on 2017/3/3.
 */
@Entity
@Table(name = "general_person_researcher")
@ApiModel("科研人员<br>ResearcherBean")
public class ResearcherBean extends PersistentEntity {
    @ApiModelProperty(value = "工号", example = "0")
    //@Column(unique = true)
    private String code;
    @ApiModelProperty(value = "姓名", example = "陈某")
    private String name;
    @ApiModelProperty(value = "身份证号", example = "220***************")
    private String identificationCard;
    private Integer sex;      //性别，字典[性别]
    @ApiModelProperty(value = "出生日期", example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    @ApiModelProperty(value = "民族", example = "汉族")
    private String nation;
    @ApiModelProperty(value = "籍贯", example = "吉林省长春市")
    private String placeOfOrigin;
    @ApiModelProperty(value = "联系电话", example = "13704310431")
    private String phone;
    @ApiModelProperty(value = "电子邮件", example = "xxxxxxxxxxx@qq.com")
    private String email;
    @ApiModelProperty(value = "最初职称", example = "助教")
    private String firstTitle;
    @ApiModelProperty(value = "最初职称评定时间", example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date firstEvaluateDate;
    @ApiModelProperty(value = "最后职称", example = "讲师")
    private String lastTitle;
    @ApiModelProperty(value = "最后职称评定时间", example = "2015-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date lastEvaluateDate;
    @ApiModelProperty(value = "最后学历", example = "大学本科")
    private String education;
    @ApiModelProperty(value = "最后学位", example = "学士学位")
    private String degree;
    @ApiModelProperty(value = "毕业院校", example = "xxxx大学")
    private String school;
    @ApiModelProperty(value = "研究方向", example = "xxxx专业")
    private String direction;

    @ApiModelProperty(value = "所在单位部门id", example = "001")
    private Long orgId;
    @Transient
    private String orgName;   //所在单位部门名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    public Date getFirstEvaluateDate() {
        return firstEvaluateDate;
    }

    public void setFirstEvaluateDate(Date firstEvaluateDate) {
        this.firstEvaluateDate = firstEvaluateDate;
    }

    public String getLastTitle() {
        return lastTitle;
    }

    public void setLastTitle(String lastTitle) {
        this.lastTitle = lastTitle;
    }

    public Date getLastEvaluateDate() {
        return lastEvaluateDate;
    }

    public void setLastEvaluateDate(Date lastEvaluateDate) {
        this.lastEvaluateDate = lastEvaluateDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
