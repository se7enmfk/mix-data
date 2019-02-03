/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.service;

import com.se7en.biz.common.service.BaseService;
import com.se7en.biz.pro.entity.ProData;

import java.util.List;

/**
 * ProData 表服务层接口
 *
 * @author se7en zhou
 * @since 2019-01-10 15:44:53
 */
public interface ProDataService extends BaseService<ProData> {

    void setData();

    List<ProData> retrieveProData(ProData proData);
}