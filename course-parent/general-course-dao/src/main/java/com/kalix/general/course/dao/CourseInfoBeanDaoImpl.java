package com.kalix.general.course.dao;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.general.course.api.dao.ICourseInfoBeanDao;
import com.kalix.general.course.entities.CourseInfoBean;
import com.kalix.general.major.api.dao.IMajorInfoBeanDao;
import com.kalix.general.major.entities.MajorInfoBean;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3.
 */
public class CourseInfoBeanDaoImpl extends BaseAdminDao<CourseInfoBean, Long> implements ICourseInfoBeanDao {
    private IMajorInfoBeanDao majorInfoBeanDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<CourseInfoBean> findByTreeId(Long treeId) {
        List<CourseInfoBean> list = super.findByTreeId(treeId);
        //对象字典翻译
        for (int i = 0; i < list.size(); i++) {
            MajorInfoBean majorInfoBean = majorInfoBeanDao.get(list.get(i).getTreeId());
            list.get(i).setMajorId(majorInfoBean.getId());
            list.get(i).setMajorName(majorInfoBean.getCnName());
        }
        return list;
    }

    @Override
    public JsonData findByTreeId(Long treeId, Integer page, Integer limit, String jsonStr, String sort) {
        JsonData jsonData = super.findByTreeId(treeId, page, limit, jsonStr, sort);
        //对象字典翻译
        for (int i = 0; i < jsonData.getData().size(); i++) {
            CourseInfoBean courseInfoBean = (CourseInfoBean) jsonData.getData().get(i);
            MajorInfoBean majorInfoBean = majorInfoBeanDao.get(courseInfoBean.getTreeId());
            courseInfoBean.setMajorId(majorInfoBean.getId());
            courseInfoBean.setMajorName(majorInfoBean.getCnName());
        }
        return jsonData;
    }

    public void setMajorInfoBeanDao(IMajorInfoBeanDao majorInfoBeanDao) {
        this.majorInfoBeanDao = majorInfoBeanDao;
    }
}
