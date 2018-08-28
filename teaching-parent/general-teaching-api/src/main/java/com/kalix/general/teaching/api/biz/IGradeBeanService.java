package com.kalix.general.teaching.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.BaseTreeDTO;
import com.kalix.general.teaching.dto.model.GradeMajorDTO;
import com.kalix.general.teaching.entities.GradeBean;

import java.util.List;

/**
 * Created by dell on 14-1-17.
 */
public interface IGradeBeanService extends IBizService<GradeBean> {

    /**
     * 保存年级与专业关联
     *
     * @param ids
     * @return
     */
    JsonStatus saveGradeMajors(List ids);

    /**
     * 根据年级ID获得所有专业信息ids
     *
     * @param id
     * @return
     */
    List getMajorIdsByGradeId(Long id);

    /**
     * 根据年级ID获得所有专业信息
     *
     * @param id
     * @return
     */
    JsonData getMajorInfosByGradeId(Long id);

    /**
     * 根据年级获得所有专业信息
     *
     * @param grade
     * @return
     */
    JsonData getMajorInfosByGrade(String grade);

    /**
     * 根据年级查询专业信息树(null或""代表查全部)
     *
     * @param grade
     * @return
     */
    BaseTreeDTO getMajorTreeByGrade(String grade);
}
