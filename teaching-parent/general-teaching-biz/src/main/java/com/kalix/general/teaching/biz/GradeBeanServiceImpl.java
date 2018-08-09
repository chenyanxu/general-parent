package com.kalix.general.teaching.biz;

import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.framework.core.util.StringUtils;
import com.kalix.general.teaching.api.biz.IGradeBeanService;
import com.kalix.general.teaching.api.dao.IGradeBeanDao;
import com.kalix.general.teaching.api.dao.IGradeMajorBeanDao;
import com.kalix.general.teaching.entities.GradeBean;
import com.kalix.general.teaching.entities.GradeMajorBean;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fj on 2017-8-17.
 */
public class GradeBeanServiceImpl extends ShiroGenericBizServiceImpl<IGradeBeanDao, GradeBean> implements IGradeBeanService {

    private static final String FUNCTION_NAME = "年级";
    private IGradeMajorBeanDao gradeMajorBeanDao;

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (dao.get(entityId) == null) {
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isUpdate(GradeBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        GradeBean gradeBean = (GradeBean) entity;
        List<GradeBean> beans = dao.find("select ob from GradeBean ob where ob.id <> ?1 and ob.grade = ?2 ",
                gradeBean.getId(), gradeBean.getGrade());
        if (beans != null && beans.size() > 0) {
            status.setSuccess(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String year = sdf.format(entity.getGrade());
            status.setMsg("更新" + FUNCTION_NAME + "[" + year + "]失败,已经存在！");
            return false;
        }
        return true;
    }

    @Override
    public boolean isSave(GradeBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        GradeBean gradeBean = (GradeBean) entity;
        List<GradeBean> beans = dao.find("select ob from GradeBean ob where ob.grade = ?1", gradeBean.getGrade());
        if (beans != null && beans.size() > 0) {
            status.setSuccess(false);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String year = sdf.format(entity.getGrade());
            status.setMsg(FUNCTION_NAME + "[" + year + "]已经存在！");
            return false;
        }
        return true;
    }

    /**
     * 保存年级与专业关联
     *
     * @param ids
     * @return
     */
    @Override
    @Transactional
    public JsonStatus saveGradeMajors(List ids) {
        JsonStatus jsonStatus = new JsonStatus();
        if (ids == null || ids.size() != 2) {
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("保存失败!");
            return jsonStatus;
        }
        try {
            Long gradeId = Long.valueOf(ids.get(0).toString());
            String majorId = ids.get(1).toString();

            gradeMajorBeanDao.deleteByGradeId(gradeId);

            String userName = getShiroService().getCurrentUserLoginName();
            if (StringUtils.isNotEmpty(majorId)) {
                String[] majorIds = majorId.split(",");
                for (String _majorId : majorIds) {
                    if (StringUtils.isNotEmpty(_majorId.trim())) {
                        GradeMajorBean gradeMajorBean = new GradeMajorBean();
                        gradeMajorBean.setCreateBy(userName);
                        gradeMajorBean.setUpdateBy(userName);
                        gradeMajorBean.setGradeId(gradeId);
                        gradeMajorBean.setMajorId(Long.parseLong(_majorId));
                        gradeMajorBeanDao.save(gradeMajorBean);
                    }
                }
            }
            jsonStatus.setSuccess(true);
            jsonStatus.setMsg("保存成功!");
        } catch (Exception e) {
            e.printStackTrace();
            jsonStatus.setSuccess(false);
            jsonStatus.setMsg("保存失败!");
            return jsonStatus;
        }
        return jsonStatus;
    }

    /**
     * 根据年级ID获得所有专业
     *
     * @param id
     * @return
     */
    @Override
    public List getMajorIdsByGradeId(Long id) {
        List majorIds = new ArrayList();
        List<GradeMajorBean> gradeMajorBeans = gradeMajorBeanDao.find("select ob from GradeMajorBean ob where ob.gradeId = ?1", id);
        if (gradeMajorBeans != null && !gradeMajorBeans.isEmpty()) {
            for (GradeMajorBean gradeMajorBean : gradeMajorBeans) {
                if (gradeMajorBean != null && gradeMajorBean.getMajorId().longValue() != 0L) {
                    majorIds.add(gradeMajorBean.getMajorId());
                }
            }
        }
        return majorIds;
    }

    public void setGradeMajorBeanDao(IGradeMajorBeanDao gradeMajorBeanDao) {
        this.gradeMajorBeanDao = gradeMajorBeanDao;
    }
}
