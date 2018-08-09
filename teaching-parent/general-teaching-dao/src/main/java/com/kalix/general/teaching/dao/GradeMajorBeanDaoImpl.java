package com.kalix.general.teaching.dao;

import com.kalix.general.teaching.api.dao.IGradeMajorBeanDao;
import com.kalix.general.teaching.entities.GradeMajorBean;

/**
 * 年级专业关联DAO实现
 *
 * @author hqj <br/>
 *         date:2018-8-7
 * @version 1.0.0
 */
public class GradeMajorBeanDaoImpl extends BaseBeanDao<GradeMajorBean, Long> implements IGradeMajorBeanDao {

    @Override
    public void deleteByGradeId(Long id) {
        String tbName = super.getTableName();
        String sql = "delete from " + tbName + " where gradeid=" + id;
        super.updateNativeQuery(sql);
    }
}
