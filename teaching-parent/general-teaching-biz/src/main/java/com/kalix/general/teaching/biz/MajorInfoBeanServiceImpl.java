package com.kalix.general.teaching.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.api.web.model.BaseTreeDTO;
import com.kalix.framework.core.impl.biz.TreeExtendShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.general.teaching.api.biz.IMajorInfoBeanService;
import com.kalix.general.teaching.api.dao.IMajorInfoBeanDao;
import com.kalix.general.teaching.entities.GradeBean;
import com.kalix.general.teaching.entities.MajorInfoBean;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by fj on 2017-8-17.
 */
public class MajorInfoBeanServiceImpl extends TreeExtendShiroGenericBizServiceImpl<IMajorInfoBeanDao, MajorInfoBean> implements IMajorInfoBeanService {

    private static final String TREE_NAME = "院(系)部";
    private static final String BEAN_NAME = "专业信息";

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
        return null;
    }

    @Override
    public BaseTreeDTO getTreeByNodeId(Long nodeId) {
        return null;
    }

    @Override
    public String getParentIdPath(Long nodeId) {
        return null;
    }
}
