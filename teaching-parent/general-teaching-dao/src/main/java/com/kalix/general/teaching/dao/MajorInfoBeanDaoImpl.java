package com.kalix.general.teaching.dao;

import com.kalix.admin.core.api.dao.IOrganizationBeanDao;
import com.kalix.admin.core.entities.OrganizationBean;
import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.general.teaching.api.dao.IMajorInfoBeanDao;
import com.kalix.general.teaching.entities.MajorInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
public class MajorInfoBeanDaoImpl extends BaseBeanDao<MajorInfoBean, Long> implements IMajorInfoBeanDao {
    private IOrganizationBeanDao organizationBeanDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<MajorInfoBean> findByTreeId(Long treeId) {
        List<MajorInfoBean> list = super.findByTreeId(treeId);
        //对象字典翻译
        for (int i = 0; i < list.size(); i++) {
            OrganizationBean organizationBean = organizationBeanDao.get(list.get(i).getTreeId());
            list.get(i).setOrgId(organizationBean.getId());
            list.get(i).setOrgName(organizationBean.getName());
        }
        return list;
    }

    @Override
    public JsonData findByTreeId(Long treeId, Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = super.findByTreeId(treeId, page, limit, jsonStr, sort);
        //对象字典翻译
        for (int i = 0; i < jsonData.getData().size(); i++) {
            MajorInfoBean majorInfoBean = (MajorInfoBean) jsonData.getData().get(i);
            OrganizationBean organizationBean = organizationBeanDao.get(majorInfoBean.getTreeId());
            majorInfoBean.setOrgId(organizationBean.getId());
            majorInfoBean.setOrgName(organizationBean.getName());
        }
        return jsonData;
    }

    public void setOrganizationBeanDao(IOrganizationBeanDao organizationBeanDao) {
        this.organizationBeanDao = organizationBeanDao;
    }
}
