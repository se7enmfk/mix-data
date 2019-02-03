/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.se7en.biz.pro.entity.ProData;

import java.util.List;

/**
 * ProData 表数据库接口
 *
 * @author se7en zhou
 * @since 2019-01-10 15:44:53
 */
public interface ProDataMapper extends BaseMapper<ProData> {

    void mergeData(ProData proData);

    List<ProData> retrieveProData(ProData proData);
}