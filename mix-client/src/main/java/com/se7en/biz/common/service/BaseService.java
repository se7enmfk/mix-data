/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.common.service;


import com.baomidou.mybatisplus.service.IService;
import com.se7en.biz.common.model.BaseResult;

import java.util.List;

/**
 * <p>
 * Base Service
 * </p>
 *
 * @author se7en
 * @Date 2016-04-20
 */
public interface BaseService<T> extends IService<T> {

    /**
     * 根据对象做 insert OR update：
     * 当对象有主键时：update by主键；
     * 当对象没有主键时：对象的 @TableId(type = IdType.INPUT)，ADM_DATA_SERIALNO 必须有对应字段的serial no；insert操作
     * all_ind_ 决定是否对全部字段作insert or update
     *
     * @param entity
     * @return
     */
    BaseResult<T> save(T entity);

    /**
     * 根据对象的 delete
     *
     * @param entity
     * @return
     */
    boolean delete(T entity);

    /**
     * 根据对象的获取一条数据
     *
     * @param entity
     * @return
     */
    T getOne(T entity);

    /**
     * 根据对象的获取所有数据
     *
     * @param entity
     * @return
     */
    List<T> retrieveList(T entity);

}
