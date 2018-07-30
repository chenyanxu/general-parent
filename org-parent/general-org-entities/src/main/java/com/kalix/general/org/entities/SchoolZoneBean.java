package com.kalix.general.org.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 校区信息实体类
 * @author fwb <br/>
 *         date:2015-7-24
 * @version 1.0.0
 */
@Entity
@Table(name = "general_school_zone")
public class SchoolZoneBean extends PersistentEntity {

    private String xqdm;   // 校区代码
    private String zwmc;   // 中文名称
    private String zwjc;   // 中文简称
    private String dz;     // 地址
    private String yb;     // 邮编
    private String hcz;    // 火车站

    public String getXqdm() {
        return xqdm;
    }

    public void setXqdm(String xqdm) {
        this.xqdm = xqdm;
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

    public String getHcz() {
        return hcz;
    }

    public void setHcz(String hcz) {
        this.hcz = hcz;
    }
}
