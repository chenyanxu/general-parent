package com.kalix.general.course.entities;

import com.kalix.framework.core.api.persistence.BaseTreeExtendEntity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @类描述：课程管理
 * @创建人： hqj
 * @创建时间：2017-11-28
 * @修改人： hqj
 * @修改时间：2018-07-16
 * @修改备注：
 */
//todo 修改模型定义
@Entity
@Table(name = "general_course_info")
public class CourseInfoBean extends BaseTreeExtendEntity {
    private String name;    //课程名称
    private String comment; //课程描述

    @Transient
    private Long majorId;
    private String majorName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }
}
