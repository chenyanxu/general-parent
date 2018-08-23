package com.kalix.general.teaching.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Created by Administrator_ on 2018/6/13.
 * 实践环节实体类
 */

@Entity
@Table(name = "general_teaching_practice")
public class PracticeInfoBean extends PersistentEntity {
    private String kcdm;   // 课程代码
    private String zwmc;   // 中文名称
    private String ywmc;   // 英文名称
    private Double zxf;    // 总学分
    private Double zxs;    // 总学时
    private Integer hjlb;  // 环节类别，字典[环节类别]
    private String jxdg;   // 教学大纲
    private Long cddw;     // 承担单位
    @Transient
    private String cddwmc; // 承担单位名称

    public String getCddwmc() {
        return cddwmc;
    }

    public void setCddwmc(String cddwmc) {
        this.cddwmc = cddwmc;
    }

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

    public Integer getHjlb() {
        return hjlb;
    }

    public void setHjlb(Integer hjlb) {
        this.hjlb = hjlb;
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
}
