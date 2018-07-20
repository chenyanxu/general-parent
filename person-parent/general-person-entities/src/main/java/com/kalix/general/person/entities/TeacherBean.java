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
@Table(name = "general_person_teacher")
@ApiModel("教师信息<br>TeacherBean")
public class TeacherBean extends PersistentEntity {
    @ApiModelProperty(value = "工号", example = "0")
    //@Column(unique = true)
    private String code;
    @ApiModelProperty(value = "姓名", example = "陈某")
    private String name;
    private Integer sex;            //性别，字典[性别]
    @ApiModelProperty(value = "出生日期", example = "2010-02-01")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date birthday;
    @ApiModelProperty(value = "学历", example = "大学本科")
    private String education;
    @ApiModelProperty(value = "学位", example = "学士学位")
    private String degree;
    @ApiModelProperty(value = "职称", example = "高级教师")
    private Integer positionalTitles;  //职称,字典[职称]
    @ApiModelProperty(value = "入校年份/启聘年份", example = "2017")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "GMT+8")
    private Date entranceYear;
    private String specialIdentity; //特殊身份
    @ApiModelProperty(value = "民族", example = "汉族")
    private String nation;
    @ApiModelProperty(value = "籍贯", example = "吉林省")
    private String placeOfOrigin;
    @ApiModelProperty(value = "现住址", example = "吉林省长春市")
    private String address;
    @ApiModelProperty(value = "身份证号", example = "220***************")
    private String identificationCard;
    @ApiModelProperty(value = "岗位", example = "0")
    private Integer position;       //岗位，字典[岗位名称]
    @ApiModelProperty(value = "是否在岗/是否聘任：（0-否 1-是）", allowableValues = "0,1", example = "1")
    private Integer beOnDuty = 1;
    @ApiModelProperty(value = "联系电话", example = "043288888888")
    private String phone;
    @ApiModelProperty(value = "邮箱", example = "text@kalix.com")
    private String email;
    @ApiModelProperty(value = "手机", example = "18866667777")
    private String mobile;
    @ApiModelProperty(value = "个人简历", example = "0")
    private String resume;
    @ApiModelProperty(value = "个人说明", example = "0")
    private String introduction;
    @ApiModelProperty(value = "学术研究", example = "0")
    private String learning;
    @ApiModelProperty(value = "教学情况", position = 10, example = "0")
    private String teaching;
    @ApiModelProperty(value = "擅长课程", position = 11, example = "0")
    private String coursesSkills;
    @ApiModelProperty(value = "预备知识", position = 12, example = "0")
    private String preliminary;
    private String remark;          //备注
    @ApiModelProperty(value = "照片", example = "http://head.png")
    private String icon;

    @ApiModelProperty(value = "所在单位id", position = 5, example = "0")
    private Long orgId;
    @Transient
    private String orgName;         //所在单位名称

    private Integer beOnExternal;   //是否外聘(教师类别)，0-在编，1-外聘
    private String originUnit;      //所属单位

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

    public Integer getPositionalTitles() {
        return positionalTitles;
    }

    public void setPositionalTitles(Integer positionalTitles) {
        this.positionalTitles = positionalTitles;
    }

    public Date getEntranceYear() {
        return entranceYear;
    }

    public void setEntranceYear(Date entranceYear) {
        this.entranceYear = entranceYear;
    }

    public String getSpecialIdentity() {
        return specialIdentity;
    }

    public void setSpecialIdentity(String specialIdentity) {
        this.specialIdentity = specialIdentity;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public void setIdentificationCard(String identificationCard) {
        this.identificationCard = identificationCard;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Integer getBeOnDuty() {
        return beOnDuty;
    }

    public void setBeOnDuty(Integer beOnDuty) {
        this.beOnDuty = beOnDuty;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getLearning() {
        return learning;
    }

    public void setLearning(String learning) {
        this.learning = learning;
    }

    public String getTeaching() {
        return teaching;
    }

    public void setTeaching(String teaching) {
        this.teaching = teaching;
    }

    public String getCoursesSkills() {
        return coursesSkills;
    }

    public void setCoursesSkills(String coursesSkills) {
        this.coursesSkills = coursesSkills;
    }

    public String getPreliminary() {
        return preliminary;
    }

    public void setPreliminary(String preliminary) {
        this.preliminary = preliminary;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Integer getBeOnExternal() {
        return beOnExternal;
    }

    public void setBeOnExternal(Integer beOnExternal) {
        this.beOnExternal = beOnExternal;
    }

    public String getOriginUnit() {
        return originUnit;
    }

    public void setOriginUnit(String originUnit) {
        this.originUnit = originUnit;
    }
}
