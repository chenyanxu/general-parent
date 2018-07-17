package com.kalix.general.person.biz;

import com.kalix.admin.core.api.biz.IOrganizationBeanService;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.QueryDTO;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.general.person.api.biz.IResearcherBeanService;
import com.kalix.general.person.api.dao.IResearcherBeanDao;
import com.kalix.general.person.entities.ResearcherBean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hqj on 2017-3-7.
 */
public class ResearcherBeanServiceImpl extends ShiroGenericBizServiceImpl<IResearcherBeanDao, ResearcherBean> implements IResearcherBeanService {
    private static final String FUNCTION_NAME = "科研人员信息";
    private IOrganizationBeanService organizationBeanService;

    public ResearcherBeanServiceImpl() {
        super.init(ResearcherBean.class.getName());
    }

    @Override
    public boolean isSave(ResearcherBean entity, JsonStatus status) {
        /*ResearcherBean bean = (ResearcherBean) entity;
        List<ResearcherBean> researcherBeans = dao.find("select ob from ResearcherBean ob where ob.code = ?1", bean.getCode());
        if (researcherBeans != null && researcherBeans.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }*/
        return true;
    }

    @Override
    public boolean isUpdate(ResearcherBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        /*ResearcherBean bean = (ResearcherBean) entity;
        List<ResearcherBean> researcherBeans = dao.find("select ob from ResearcherBean ob where ob.id <> ?1 and ob.code = ?2",
                bean.getId(), bean.getCode());
        if (researcherBeans != null && researcherBeans.size() > 0) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经存在！");
            return false;
        }*/
        return true;
    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (dao.get(entityId) == null) {
            status.setFailure(true);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public ResearcherBean getEntity(long entityId) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("orgId/orgName/name", organizationBeanService);
        return super.getEntity(entityId, maps);
    }

    @Override
    public JsonData getAllEntityByQuery(QueryDTO queryDTO) {
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("orgId/orgName/name", organizationBeanService);
        return super.getAllEntityByQuery(queryDTO, maps);
    }

    public void setOrganizationBeanService(IOrganizationBeanService organizationBeanService) {
        this.organizationBeanService = organizationBeanService;
    }
}
