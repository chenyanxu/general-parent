package com.kalix.general.org.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 学校信息实体类
 * @author fwb <br/>
 *         date:2015-7-24
 * @version 1.0.0
 */
@Entity
@Table(name = "general_school_info")
public class SchoolInfoBean extends PersistentEntity {

    private String xxdm;   // 学校代码
    private String xxxz;   // 学校性质
    private String xxlb;   // 学校类别
    private String zwmc;   // 中文名称
    private String zwjc;   // 中文简称
    private String ywmc;   // 英文名称
    private String ywjc;   // 英文简称
    private String zgbm;   // 主管部门
    private String sj;     // 书记
    private String xz;     // 校长
    private String dh;     // 电话
    private String cz;     // 传真
    private String lxr;    // 联系人
    private String dzyx;   // 电子邮箱
    private String wz;     // 网址
    private String dz;     // 地址
    private String yb;     // 邮编

    public String getXxdm() {
        return xxdm;
    }

    public void setXxdm(String xxdm) {
        this.xxdm = xxdm;
    }

    public String getXxxz() {
        return xxxz;
    }

    public void setXxxz(String xxxz) {
        this.xxxz = xxxz;
    }

    public String getXxlb() {
        return xxlb;
    }

    public void setXxlb(String xxlb) {
        this.xxlb = xxlb;
    }

    public String getZwmc() {
        return zwmc;
    }

    public void setZwmc(String zwmc) {
        this.zwmc = zwmc;
    }

    public String getZwjc() {
        return zwjc;
    }

    public void setZwjc(String zwjc) {
        this.zwjc = zwjc;
    }

    public String getYwmc() {
        return ywmc;
    }

    public void setYwmc(String ywmc) {
        this.ywmc = ywmc;
    }

    public String getYwjc() {
        return ywjc;
    }

    public void setYwjc(String ywjc) {
        this.ywjc = ywjc;
    }

    public String getZgbm() {
        return zgbm;
    }

    public void setZgbm(String zgbm) {
        this.zgbm = zgbm;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getDh() {
        return dh;
    }

    public void setDh(String dh) {
        this.dh = dh;
    }

    public String getCz() {
        return cz;
    }

    public void setCz(String cz) {
        this.cz = cz;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getDzyx() {
        return dzyx;
    }

    public void setDzyx(String dzyx) {
        this.dzyx = dzyx;
    }

    public String getWz() {
        return wz;
    }

    public void setWz(String wz) {
        this.wz = wz;
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz;
    }

    public String getYb() {
        return yb;
    }

    public void setYb(String yb) {
        this.yb = yb;
    }
}
