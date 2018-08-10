package com.kalix.general.teaching.dao;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.general.teaching.api.dao.IClassInfoBeanDao;
import com.kalix.general.teaching.api.dao.IGradeBeanDao;
import com.kalix.general.teaching.api.dao.IMajorInfoBeanDao;
import com.kalix.general.teaching.entities.ClassInfoBean;

import javax.persistence.criteria.CriteriaQuery;

/**
 * Created by Administrator on 2017/3/3.
 */
public class ClassInfoBeanDaoImpl extends BaseBeanDao<ClassInfoBean, Long> implements IClassInfoBeanDao {
    private IGradeBeanDao gradeBeanDao;
    private IMajorInfoBeanDao majorInfoBeanDao;

    @Override
    public ClassInfoBean get(Long id) {
        ClassInfoBean classInfoBean = super.get(id);
        String code = classInfoBean.getCode();
        String xh = code.substring(code.length() - 2, code.length());
        classInfoBean.setXh(xh);
        classInfoBean.setGrade(gradeBeanDao.get(classInfoBean.getGradeId()).getGrade());
        classInfoBean.setMajorName(majorInfoBeanDao.get(classInfoBean.getMajorId()).getCnName());
        return classInfoBean;
    }

    @Override
    public JsonData getAll(int page, int limit, CriteriaQuery criteriaQuery) {
        JsonData jsonData = super.getAll(page, limit, criteriaQuery);
        for (int i=0; i< jsonData.getData().size(); i++) {
            ClassInfoBean classInfoBean = (ClassInfoBean) jsonData.getData().get(i);
            String code = classInfoBean.getCode();
            String xh = code.substring(code.length() - 2, code.length());
            classInfoBean.setXh(xh);
            classInfoBean.setGrade(gradeBeanDao.get(classInfoBean.getGradeId()).getGrade());
            classInfoBean.setMajorName(majorInfoBeanDao.get(classInfoBean.getMajorId()).getCnName());
        }
        return jsonData;
    }

    public void setGradeBeanDao(IGradeBeanDao gradeBeanDao) {
        this.gradeBeanDao = gradeBeanDao;
    }

    public void setMajorInfoBeanDao(IMajorInfoBeanDao majorInfoBeanDao) {
        this.majorInfoBeanDao = majorInfoBeanDao;
    }
}
