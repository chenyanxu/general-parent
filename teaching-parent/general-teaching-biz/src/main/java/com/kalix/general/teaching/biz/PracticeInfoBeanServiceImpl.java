package com.kalix.general.teaching.biz;

import com.kalix.admin.core.api.biz.IOrganizationBeanService;
import com.kalix.admin.core.entities.OrganizationBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.general.teaching.api.biz.IPracticeInfoBeanService;
import com.kalix.general.teaching.api.dao.IPracticeInfoBeanDao;
import com.kalix.general.teaching.entities.PracticeInfoBean;

/**
 * Created by fj on 2017-8-17.
 */
public class PracticeInfoBeanServiceImpl extends ShiroGenericBizServiceImpl<IPracticeInfoBeanDao, PracticeInfoBean> implements IPracticeInfoBeanService {

    private IOrganizationBeanService organizationBeanServiceImpl;

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = super.getAllEntityByQuery(page, limit, jsonStr, sort);
        for (int i = 0; i < jsonData.getData().size(); i++) {
            PracticeInfoBean practiceInfoBean = (PracticeInfoBean) jsonData.getData().get(i);
            OrganizationBean organizationBean = organizationBeanServiceImpl.getEntity(practiceInfoBean.getCddw());
            practiceInfoBean.setCddwmc(organizationBean.getName());
        }
        return jsonData;
    }

    public void setOrganizationBeanServiceImpl(IOrganizationBeanService organizationBeanServiceImpl) {
        this.organizationBeanServiceImpl = organizationBeanServiceImpl;
    }
}
