package com.kalix.general.teaching.biz;

import com.kalix.framework.core.api.persistence.JsonData;
import com.kalix.framework.core.api.persistence.JsonStatus;
import com.kalix.framework.core.impl.biz.ShiroGenericBizServiceImpl;
import com.kalix.framework.core.util.Assert;
import com.kalix.general.teaching.api.biz.IClassInfoBeanService;
import com.kalix.general.teaching.api.dao.IClassInfoBeanDao;
import com.kalix.general.teaching.api.dao.IGradeBeanDao;
import com.kalix.general.teaching.api.dao.IMajorInfoBeanDao;
import com.kalix.general.teaching.entities.ClassInfoBean;
import com.kalix.general.teaching.entities.GradeBean;
import com.kalix.general.teaching.entities.MajorInfoBean;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by fj on 2017-8-17.
 */
public class ClassInfoBeanServiceImpl extends ShiroGenericBizServiceImpl<IClassInfoBeanDao, ClassInfoBean> implements IClassInfoBeanService {

    private static final String FUNCTION_NAME = "班级";
    private IGradeBeanDao gradeBeanDao;
    private IMajorInfoBeanDao majorInfoBeanDao;

    @Override
    public boolean isDelete(Long entityId, JsonStatus status) {
        if (dao.get(entityId) == null) {
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "已经被删除！");
            return false;
        }
        // 判断如果班级已被用于构建学生信息，不能删除
        /*if (true) {
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "已经使用，不允许删除！");
        }*/
        return true;
    }

    @Override
    public boolean isUpdate(ClassInfoBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        ClassInfoBean classInfoBean = (ClassInfoBean) entity;

        // 判断是否修改班级代码
        ClassInfoBean oldClass = this.dao.get(entity.getId());
        // 修改班级代码
        if (oldClass.getGradeId().longValue() != classInfoBean.getGradeId().longValue() ||
                oldClass.getMajorId().longValue() != classInfoBean.getMajorId() ||
                !oldClass.getXh().equals(classInfoBean.getXh())) {
            // 判断如果班级已被用于构建学生信息，不能修改代码
            /*if (true) {
                status.setSuccess(false);
                status.setMsg(FUNCTION_NAME + "已经使用，代码不允许修改！");
                return false;
            }*/
            // 生成新的班级代码
            GradeBean gradeBean = gradeBeanDao.get(classInfoBean.getGradeId());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
            String year = sdf.format(gradeBean.getGrade());
            MajorInfoBean majorInfoBean = majorInfoBeanDao.get(classInfoBean.getMajorId());
            String newCode = year + majorInfoBean.getCode() + classInfoBean.getXh();
            // 判断班级代码是否重复
            List<ClassInfoBean> beans = dao.find("select ob from ClassInfoBean ob where ob.id <> ?1 and ob.code = ?2 ",
                    classInfoBean.getId(), newCode);
            if (beans != null && beans.size() > 0) {
                status.setSuccess(false);
                status.setMsg("更新" + FUNCTION_NAME + "[" + entity.getCode() + "]失败,已经存在！");
                return false;
            }
            classInfoBean.setCode(newCode);
        }
        return true;
    }

    @Override
    public boolean isSave(ClassInfoBean entity, JsonStatus status) {
        Assert.notNull(entity, "实体不能为空.");
        ClassInfoBean classInfoBean = (ClassInfoBean) entity;
        // 生成班级序号2位
        String xh = "";
        List<ClassInfoBean> beans = dao.find("select ob from ClassInfoBean ob where ob.gradeId = ?1 and ob.majorId = ?2 order by ob.code",
                classInfoBean.getGradeId(), classInfoBean.getMajorId());
        if (beans != null && beans.size() > 0) {
            for (int i = 1; i < 100; i++) {
                boolean isOK = true;
                for (int j = 0; j < beans.size(); j++) {
                    String code = beans.get(j).getCode();
                    int tmp = Integer.parseInt(code.substring(code.length() - 2, code.length()));
                    if (tmp == i) {
                        isOK = false;
                        break;
                    }
                }
                if (isOK) {
                    DecimalFormat df = new DecimalFormat("00");
                    xh = df.format(i);
                    break;
                }
            }
        } else {
            xh = "01";
        }
        if (xh.equals("")) {
            status.setSuccess(false);
            status.setMsg(FUNCTION_NAME + "2位序号已经全部占用，无法自动创建班级代码！");
            return false;
        }
        // 生成新的班级代码
        GradeBean gradeBean = gradeBeanDao.get(classInfoBean.getGradeId());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String year = sdf.format(gradeBean.getGrade());
        MajorInfoBean majorInfoBean = majorInfoBeanDao.get(classInfoBean.getMajorId());
        String newCode = year + majorInfoBean.getCode() + xh;
        classInfoBean.setCode(newCode);
        return true;
    }

    /**
     * 根据年级和专业id获取所有班级信息
     *
     * @param grade
     * @param majorId
     * @return
     */
    @Override
    public JsonData getClassInfos(String grade, Long majorId) {
        JsonData jsonData = new JsonData();
        List classInfos = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        try {
            Date date = sdf.parse(grade);
            String sql = "select c.* from " + this.dao.getTableName() + " c where c.gradeid in " +
                    " (select g.id from " + this.gradeBeanDao.getTableName() + " g where g.grade = ?1) and c.majorid = ?2";
            classInfos = this.dao.findByNativeSql(sql, ClassInfoBean.class, date, majorId);
            jsonData.setData(classInfos);
            jsonData.setTotalCount((long) classInfos.size());
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
