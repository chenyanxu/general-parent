package com.kalix.general.major.biz;

import com.kalix.framework.core.api.web.model.BaseTreeDTO;
import com.kalix.framework.core.impl.biz.TreeExtendShiroGenericBizServiceImpl;
import com.kalix.general.major.api.biz.IMajorInfoBeanService;
import com.kalix.general.major.api.dao.IMajorInfoBeanDao;
import com.kalix.general.major.entities.MajorInfoBean;

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
