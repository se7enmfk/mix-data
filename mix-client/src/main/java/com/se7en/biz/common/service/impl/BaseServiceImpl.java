/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.common.service.impl;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import com.ftx.frame.util.object.ObjectUtil;
import com.ftx.frame.util.string.StringUtil;
import com.se7en.biz.Constant;
import com.se7en.biz.common.model.BaseResult;
import com.se7en.biz.common.service.BaseService;
import com.se7en.biz.common.util.EntityUtil;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 主键 String 类型 IService 实现类（ 泛型：M 是 mapper 对象， T 是实体 ）
 * </p>
 *
 * @author se7en
 * @since 2017/11/5 14:46
 */

public class BaseServiceImpl<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements BaseService<T> {

//    @Autowired
//    private AdmDataSerialnoService admDataSerialnoService;

    @Transactional(rollbackFor = Exception.class)
    public BaseResult<T> save(T entity) {

        boolean valid;

        TableInfo tableInfo = TableInfoHelper.getTableInfo(entity.getClass());
        String key = EntityUtil.getKey(entity);

        Object all_ind = ObjectUtil.invokeGetter(entity, "all_ind_", false);
        if (tableInfo.getIdType() == IdType.ID_WORKER_STR) {
            insertOrUpdate(entity);
        } else {
            //主键为空，insert
            if (StringUtil.isEmpty(key)) {
//                entity = admDataSerialnoService.getDataSerno(entity);
                if (Constant.YES.equals(all_ind)) {
                    valid = insertAllColumn(entity);
                } else {
                    valid = insert(entity);
                }
            }
            //主键不为空，update
            else {
                if (Constant.YES.equals(all_ind)) {
                    valid = updateAllColumn(entity);
                } else {
                    valid = updateById(entity);
                }
            }
//            if (!valid)
//                ErrorCodeEnum.throwFtxException(ErrorCodeEnum.dataModify);
        }


        return new BaseResult<>(Constant.CODE_200, entity);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean delete(T entity) {
        boolean delete = delete(new EntityWrapper<>(entity));

//        if (!delete)
//            ErrorCodeEnum.throwFtxException(ErrorCodeEnum.dataModify);

        return delete;
    }

    public T getOne(T entity) {
        return selectOne(new EntityWrapper<>(entity));
    }

    /**
     * 设置order_by排列
     *
     * @param entity
     * @return
     */
    public List<T> retrieveList(T entity) {
        EntityWrapper<T> entityWrapper = new EntityWrapper<>(entity);
        /*try {
            Object orderBy = ObjectUtil.invokeGetter(entity, "order_by", false);
            if (StringUtil.isNotEmpty(orderBy))
                entityWrapper.orderBy(orderBy.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        return selectList(entityWrapper);
    }


    @Transactional(rollbackFor = Exception.class)
    public boolean updateAllColumn(T entity) {
        String key = EntityUtil.getKey(entity);

        T one = this.selectById(key);
        Object create_by = ObjectUtil.invokeGetter(one, "create_by", false);
        ObjectUtil.invokeSetter(entity, "create_by", create_by);
        Object create_ts = ObjectUtil.invokeGetter(one, "create_ts", false);
        ObjectUtil.invokeSetter(entity, "create_ts", create_ts);
        return this.updateAllColumnById(entity);
    }
}
