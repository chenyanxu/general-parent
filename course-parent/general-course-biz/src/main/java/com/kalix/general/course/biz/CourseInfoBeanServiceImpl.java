package com.kalix.general.course.biz;

import com.kalix.framework.core.api.web.model.BaseTreeDTO;
import com.kalix.framework.core.impl.biz.TreeExtendShiroGenericBizServiceImpl;
import com.kalix.general.course.api.biz.ICourseInfoBeanService;
import com.kalix.general.course.api.dao.ICourseInfoBeanDao;
import com.kalix.general.course.entities.CourseInfoBean;

/**
 * Created by fj on 2017-8-17.
 */
public class CourseInfoBeanServiceImpl extends TreeExtendShiroGenericBizServiceImpl<ICourseInfoBeanDao, CourseInfoBean> implements ICourseInfoBeanService {

    private static final String TREE_NAME = "专业信息";
    private static final String BEAN_NAME = "课程信息";

    public CourseInfoBeanServiceImpl() {
        super.init(CourseInfoBean.class.getName());
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
