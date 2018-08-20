package com.kalix.general.teaching.biz;

import com.kalix.admin.core.api.dao.IOrganizationBeanDao;
import com.kalix.admin.core.entities.OrganizationBean;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.BaseTreeDTO;
import com.kalix.framework.core.impl.biz.TreeExtendShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.general.teaching.api.biz.IMajorInfoBeanService;
import com.kalix.general.teaching.api.dao.IGradeBeanDao;
import com.kalix.general.teaching.api.dao.IGradeMajorBeanDao;
import com.kalix.general.teaching.api.dao.IMajorInfoBeanDao;
import com.kalix.general.teaching.entities.GradeBean;
import com.kalix.general.teaching.entities.GradeMajorBean;
import com.kalix.general.teaching.entities.MajorInfoBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fj on 2017-8-17.
 */
public class MajorInfoBeanServiceImpl extends TreeExtendShiroGenericBizServiceImpl<IMajorInfoBeanDao, MajorInfoBean> implements IMajorInfoBeanService {

    private static final String TREE_NAME = "院(系)部";
    private static final String BEAN_NAME = "专业信息";

    private IGradeMajorBeanDao gradeMajorBeanDao;
    private IGradeBeanDao gradeBeanDao;
    private IOrganizationBeanDao organizationBeanDao;

    public MajorInfoBeanServiceImpl() {
        super.init(MajorInfoBean.class.getName());
        super.setTreeName(TREE_NAME);
        super.setBeanName(BEAN_NAME);
    }

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (dao.get(entityId) == null) {
            status.setSuccess(false);
            status.setMsg(BEAN_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(MajorInfoBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        MajorInfoBean majorInfoBean = (MajorInfoBean) entity;
        List<MajorInfoBean> beans = dao.find("select ob from MajorInfoBean ob where ob.id <> ?1 and (ob.code = ?2 or ob.standardCode = ?3)",
                majorInfoBean.getId(), majorInfoBean.getCode(), majorInfoBean.getStandardCode());
        if (beans != null && beans.size() > 0) {
            status.setSuccess(false);
            status.setMsg("更新" + BEAN_NAME + "[" + entity.getCode() + "]失败,已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isSave(MajorInfoBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        MajorInfoBean majorInfoBean = (MajorInfoBean) entity;
        List<MajorInfoBean> beans = dao.find("select ob from MajorInfoBean ob where ob.code = ?1 or ob.standardCode = ?2",
                majorInfoBean.getCode(), majorInfoBean.getStandardCode());
        if (beans != null && beans.size() > 0) {
            status.setSuccess(false);
            status.setMsg(BEAN_NAME + "[" + entity.getCode() + "]已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public BaseTreeDTO getAllTree() {
        return this.getTreeByNodeId(-1L);
    }

    @Override
    public BaseTreeDTO getTreeByNodeId(Long nodeId) {
        BaseTreeDTO rtn = new BaseTreeDTO();
        List<OrganizationBean> list = new ArrayList<OrganizationBean>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        if (nodeId != null && nodeId.longValue() > 0) {
            String sql = "select DISTINCT(o.*) from " + this.organizationBeanDao.getTableName() + " o, " +
                    this.dao.getTableName() + " m where o.id = m.treeid and m.id = ?1 order by o.id";
            list = this.dao.findByNativeSql(sql, OrganizationBean.class, nodeId);
        } else {
            String sql = "select DISTINCT(o.*) from " + this.organizationBeanDao.getTableName() + " o, " +
                    this.dao.getTableName() + " m where o.id = m.treeid order by o.id";
            list = this.dao.findByNativeSql(sql, OrganizationBean.class);
        }
        rtn.setId(-1L);
        List<BaseTreeDTO> orgs = new ArrayList<BaseTreeDTO>();
        for (int i = 0; i < list.size(); i++) {
            OrganizationBean organizationBean = list.get(i);
            BaseTreeDTO org = new BaseTreeDTO();
            org.setId(organizationBean.getId());
            org.setName(organizationBean.getName());
            org.setText(organizationBean.getName());
            org.setLeaf(false);
            org.setParentId(-1L);
            org.setParentName("根");

            List<MajorInfoBean> list1 = new ArrayList<MajorInfoBean>();
            if (nodeId != null && nodeId.longValue() > 0) {
                String sql = "select * from " + this.dao.getTableName() + " where id = ?1 and treeid = ?2 order by code";
                list1 = this.dao.findByNativeSql(sql, MajorInfoBean.class, nodeId, org.getId());
            } else {
                String sql = "select * from " + this.dao.getTableName() + " where treeid = ?1 order by code";
                list1 = this.dao.findByNativeSql(sql, MajorInfoBean.class, org.getId());
            }

            List<BaseTreeDTO> parents = new ArrayList<BaseTreeDTO>();
            for (int j = 0; j<list1.size(); j++) {
                MajorInfoBean majorInfoBean = list1.get(j);
                BaseTreeDTO parent = new BaseTreeDTO();
                parent.setId(majorInfoBean.getId());
                parent.setName(majorInfoBean.getCnName());
                parent.setText(majorInfoBean.getCnName());
                parent.setLeaf(false);
                parent.setParentId(org.getId());
                parent.setParentName(org.getName());

                List<GradeMajorBean> gradeMajorBeans = gradeMajorBeanDao.find(
                        "select ob from GradeMajorBean ob where ob.majorId = ?1", parent.getId());
                List<BaseTreeDTO> children = new ArrayList<BaseTreeDTO>();
                for (GradeMajorBean gradeMajorBean : gradeMajorBeans) {
                    GradeBean gradeBean = gradeBeanDao.get(gradeMajorBean.getGradeId());
                    BaseTreeDTO child = new BaseTreeDTO();
                    child.setId(gradeBean.getId());
                    child.setName(sdf.format(gradeBean.getGrade()));
                    child.setText(sdf.format(gradeBean.getGrade()));
                    child.setLeaf(true);
                    child.setParentId(parent.getId());
                    child.setParentName(parent.getName());
                    children.add(child);
                }
                parent.setChildren(children);
                parents.add(parent);
            }

            org.setChildren(parents);
            orgs.add(org);
        }
        rtn.setChildren(orgs);
        return rtn;
    }

    @Override
    public String getParentIdPath(Long nodeId) {
        return null;
    }

    public void setGradeMajorBeanDao(IGradeMajorBeanDao gradeMajorBeanDao) {
        this.gradeMajorBeanDao = gradeMajorBeanDao;
    }

    public void setGradeBeanDao(IGradeBeanDao gradeBeanDao) {
        this.gradeBeanDao = gradeBeanDao;
    }

    public void setOrganizationBeanDao(IOrganizationBeanDao organizationBeanDao) {
        this.organizationBeanDao = organizationBeanDao;
    }
}
