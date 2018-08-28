package com.kalix.general.teaching.api.biz;

import com.kalix.framework.core.api.biz.IBizService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.general.teaching.entities.ClassInfoBean;

/**
 * Created by dell on 14-1-17.
 */
public interface IClassInfoBeanService extends IBizService<ClassInfoBean> {

    /**
     * 根据年级和专业id获取所有班级信息
     *
     * @param grade
     * @param majorId
     * @return
     */
    JsonData getClassInfos(String grade, Long majorId);
}
