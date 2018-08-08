package com.kalix.general.teaching.entities;

import com.kalix.framework.core.api.persistence.PersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator_ on 2018/7/26.
 * 年级专业关联实体类
 */

@Entity
@Table(name = "general_teaching_grade_major")
public class GradeMajorBean extends PersistentEntity {
    private Long majorId; // 专业id
    private Long gradeId; // 年级id

    public Long getMajorId() {
        return majorId;
    }

    public void setMajorId(Long majorId) {
        this.majorId = majorId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }
}
