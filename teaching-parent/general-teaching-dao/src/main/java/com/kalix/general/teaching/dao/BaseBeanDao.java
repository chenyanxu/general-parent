package com.kalix.general.teaching.dao;

import com.kalix.framework.core.api.persistence.BaseTreeExtendEntity;
import com.kalix.framework.core.impl.dao.BaseTreeExtendEntityDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;

/**
 * Created by sunlf on 2015/10/26.
 */
public abstract class BaseBeanDao<T extends BaseTreeExtendEntity, PK extends Serializable> extends BaseTreeExtendEntityDao<T, PK> {
    @Override
    @PersistenceContext(unitName = "general-major-unit")
    public void setEntityManager(EntityManager em) {
        super.setEntityManager(em);
    }
}
