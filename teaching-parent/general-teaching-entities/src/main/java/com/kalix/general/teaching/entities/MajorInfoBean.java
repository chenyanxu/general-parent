package com.kalix.general.teaching.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kalix.framework.core.api.persistence.BaseTreeExtendEntity;
import com.kalix.framework.core.api.persistence.PersistentEntity;
import org.apache.openjpa.persistence.jdbc.Unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @类描述：专业信息管理
 * @创建人： fwb
 * @创建时间：2018-07-06
 * @修改人： hqj
 * @修改时间：2018-07-13
 * @修改备注：
 */
//todo 修改模型定义
@Entity
@Table(name = "general_teaching_major")
public class MajorInfoBean extends BaseTreeExtendEntity {
    @Column(unique = true)
    private String code;           // 专业代码
    @Column(unique = true)
    private String standardCode;   // 国标专业代码
    private String cnName;         // 中文名称
    private String enName;         // 英文名称
    private Integer subjectType;   // 所属学科，字典[学科]
    private String period;         // 学制(学习年限)
    private String trainingLevel;  // 培养层次
    private Integer available = 1; // 状态，是否可用：（0-不可用 1-可用），字典[状态]
    private String degree;         // 授予学位
    private String normalClass;    // 师范类
    private String minorRepair;    // 允许辅修
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy", timezone = "GMT+8")
    private Date settingYear;      // 设置年份
    private String introduction;   // 专业简介

    @Transient
    private Long orgId;            // 所属院(系)部id
    @Transient
    private String orgName;        // 所属院(系)部名称

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStandardCode() {
        return standardCode;
    }

    public void setStandardCode(String standardCode) {
        this.standardCode = standardCode;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public Integer getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Integer subjectType) {
        this.subjectType = subjectType;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTrainingLevel() {
        return trainingLevel;
    }

    public void setTrainingLevel(String trainingLevel) {
        this.trainingLevel = trainingLevel;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getNormalClass() {
        return normalClass;
    }

    public void setNormalClass(String normalClass) {
        this.normalClass = normalClass;
    }

    public String getMinorRepair() {
        return minorRepair;
    }

    public void setMinorRepair(String minorRepair) {
        this.minorRepair = minorRepair;
    }

    public Date getSettingYear() {
        return settingYear;
    }

    public void setSettingYear(Date settingYear) {
        this.settingYear = settingYear;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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
