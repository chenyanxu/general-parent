package com.kalix.general.teaching.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Administrator_ on 2018/6/13.
 * 理论课程实体类
 */

@Entity
@Table(name = "general_teaching_lesson")
public class LessonInfoBean extends PersistentEntity {
    private String kcdm;   // 课程代码
    private String zwmc;   // 中文名称
    private String ywmc;   // 英文名称
    private Double zxf;    // 总学分
    private Double zxs;    // 总学时
    private Integer syxs;  // 课内实践(实验学时)
    private Integer jsxs;  // 理论学时(讲授学时)
    private Integer kclb1; // 课程类别1，字典[课程类别1]
    private Integer kclb2; // 课程类别2，字典[课程类别2]
    private Integer sjxs;  // 课外学时(上机学时)
    private Integer qtxs;  // 其他学时
    private String jxdg;   // 教学大纲
    private Long cddw;     // 承担单位
    @Transient
    private String cddwmc; // 承担单位名称

    public String getKcdm() {
        return kcdm;
    }

    public void setKcdm(String kcdm) {
        this.kcdm = kcdm;
    }

    public String getZwmc() {
        return zwmc;
    }

    public void setZwmc(String zwmc) {
        this.zwmc = zwmc;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public Double getZxf() {
        return zxf;
    }

    public void setZxf(Double zxf) {
        this.zxf = zxf;
    }

    public Double getZxs() {
        return zxs;
    }

    public void setZxs(Double zxs) {
        this.zxs = zxs;
    }

    public Integer getSyxs() {
        return syxs;
    }

    public void setSyxs(Integer syxs) {
        this.syxs = syxs;
    }

    public Integer getJsxs() {
        return jsxs;
    }

    public void setJsxs(Integer jsxs) {
        this.jsxs = jsxs;
    }

    public Integer getKclb1() {
        return kclb1;
    }

    public void setKclb1(Integer kclb1) {
        this.kclb1 = kclb1;
    }

    public Integer getKclb2() {
        return kclb2;
    }

    public void setKclb2(Integer kclb2) {
        this.kclb2 = kclb2;
    }

    public Integer getSjxs() {
        return sjxs;
    }

    public void setSjxs(Integer sjxs) {
        this.sjxs = sjxs;
    }

    public Integer getQtxs() {
        return qtxs;
    }

    public void setQtxs(Integer qtxs) {
        this.qtxs = qtxs;
    }

    public String getJxdg() {
        return jxdg;
    }

    public void setJxdg(String jxdg) {
        this.jxdg = jxdg;
    }

    public Long getCddw() {
        return cddw;
    }

    public void setCddw(Long cddw) {
        this.cddw = cddw;
    }

    public String getCddwmc() {
        return cddwmc;
    }

    public void setCddwmc(String cddwmc) {
        this.cddwmc = cddwmc;
    }
}
