package com.kalix.general.major.entities;

import com.kalix.framework.core.api.annotation.KalixCascade;
import com.kalix.framework.core.api.annotation.TableCascade;
import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @类描述：专业课程管理
 * @创建人： hqj
 * @创建时间：2017-11-28
 * @修改人：
 * @修改时间：
 * @修改备注：
 */
//todo 修改模型定义
@Entity
@Table(name = "general_major_course")
public class MajorInfoBean extends PersistentEntity {
    private String name;    //课程名称
    private Long orgid;     //所在机构(学院专业)id
    @Transient
    private String orgname;     //所在机构(学院专业)id
    private String comment; //课程描述
    private String zydm;   //专业代码
    private String gbzydm; //国标专业代码
    private String zwmc;   //中文名称
    private String ywmc;    //英文名称
    private String ssxk;    //所属学科
    private String xz  ;    //学制
    private String pycc;    //培养层次
    private String zt;      //状态
    private String syxw;    //授予学位
    private String sfl;     //师范类
    private String yxfx;    //允许辅修
    private String sznf;    //设置年份
    private String zyjj;    //专业简介


    public String getOrgname() {
        return orgname;
    }

    public void setOrgname(String orgname) {
        this.orgname = orgname;
    }

    public String getZydm() {
        return zydm;
    }

    public void setZydm(String zydm) {
        this.zydm = zydm;
    }

    public String getGbzydm() {
        return gbzydm;
    }

    public void setGbzydm(String gbzydm) {
        this.gbzydm = gbzydm;
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

    public String getSsxk() {
        return ssxk;
    }

    public void setSsxk(String ssxk) {
        this.ssxk = ssxk;
    }

    public String getXz() {
        return xz;
    }

    public void setXz(String xz) {
        this.xz = xz;
    }

    public String getPycc() {
        return pycc;
    }

    public void setPycc(String pycc) {
        this.pycc = pycc;
    }

    public String getZt() {
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }

    public String getSyxw() {
        return syxw;
    }

    public void setSyxw(String syxw) {
        this.syxw = syxw;
    }

    public String getSfl() {
        return sfl;
    }

    public void setSfl(String sfl) {
        this.sfl = sfl;
    }

    public String getYxfx() {
        return yxfx;
    }

    public void setYxfx(String yxfx) {
        this.yxfx = yxfx;
    }

    public String getSznf() {
        return sznf;
    }

    public void setSznf(String sznf) {
        this.sznf = sznf;
    }

    public String getZyjj() {
        return zyjj;
    }

    public void setZyjj(String zyjj) {
        this.zyjj = zyjj;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getOrgid() {
        return orgid;
    }

    public void setOrgid(Long orgid) {
        this.orgid = orgid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
