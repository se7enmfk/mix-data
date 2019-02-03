/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.mapper;

import com.se7en.biz.pro.entity.ProDataType;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * ProDataType 表数据库接口
 *
 * @author se7en zhou
 * @since 2019-01-10 16:04:57
 */
public interface ProDataTypeMapper extends BaseMapper<ProDataType> {

    void mergeProDataType(ProDataType proDataType);

}