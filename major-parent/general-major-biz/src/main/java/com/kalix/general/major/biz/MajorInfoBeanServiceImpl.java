package com.kalix.general.major.biz;

import com.kalix.admin.core.api.biz.IOrganizationBeanService;
import com.kalix.admin.core.entities.OrganizationBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.general.major.api.biz.IMajorInfoBeanService;
import com.kalix.general.major.api.dao.IMajorInfoBeanDao;
import com.kalix.general.major.entities.MajorInfoBean;


/**
 * Created by fj on 2017-8-17.
 */
public class MajorInfoBeanServiceImpl extends ShiroGenericBizServiceImpl<IMajorInfoBeanDao, MajorInfoBean> implements IMajorInfoBeanService {

    private IOrganizationBeanService organizationBeanServiceImpl;

    @Override
    public JsonData getAllEntityByQuery(Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = super.getAllEntityByQuery(page, limit, jsonStr, sort);
        for (int i=0; i<jsonData.getData().size(); i++) {
            MajorInfoBean majorInfoBean = (MajorInfoBean) jsonData.getData().get(i);
            OrganizationBean organizationBean = organizationBeanServiceImpl.getEntity(majorInfoBean.getOrgid());
            majorInfoBean.setOrgname(organizationBean.getName());
        }
        return jsonData;
    }

    public void setOrganizationBeanServiceImpl(IOrganizationBeanService organizationBeanServiceImpl) {
        this.organizationBeanServiceImpl = organizationBeanServiceImpl;
    }
}
