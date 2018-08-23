package com.kalix.general.teaching.biz;

import com.kalix.admin.core.api.biz.IOrganizationBeanService;
import com.kalix.admin.core.entities.OrganizationBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.general.teaching.api.biz.ILessonInfoBeanService;
import com.kalix.general.teaching.api.dao.ILessonInfoBeanDao;
import com.kalix.general.teaching.entities.LessonInfoBean;

/**
 * Created by fj on 2017-8-17.
 */
public class LessonInfoBeanServiceImpl extends ShiroGenericBizServiceImpl<ILessonInfoBeanDao, LessonInfoBean> implements ILessonInfoBeanService {

    private IOrganizationBeanService organizationBeanServiceImpl;

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = super.getAllEntityByQuery(page, limit, jsonStr, sort);
        for (int i = 0; i < jsonData.getData().size(); i++) {
            LessonInfoBean lessonInfoBean = (LessonInfoBean) jsonData.getData().get(i);
            OrganizationBean organizationBean = organizationBeanServiceImpl.getEntity(lessonInfoBean.getCddw());
            lessonInfoBean.setCddwmc(organizationBean.getName());
        }
        return jsonData;
    }

    public void setOrganizationBeanServiceImpl(IOrganizationBeanService organizationBeanServiceImpl) {
        this.organizationBeanServiceImpl = organizationBeanServiceImpl;
    }
}
