package com.kalix.general.teaching.api.biz;

import com.kalix.general.teaching.entities.GradeBean;
import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonStatus;

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
     * 根据年级ID获得所有专业
     *
     * @param id
     * @return
     */
    List getMajorIdsByGradeId(Long id);
}
