/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.service;

import com.se7en.biz.common.model.BaseResult;
import com.se7en.biz.common.service.BaseService;
import com.se7en.biz.pro.entity.ProDataType;

/**
 * ProDataType 表服务层接口
 *
 * @author se7en zhou
 * @since 2019-01-10 16:04:57
 */
public interface ProDataTypeService extends BaseService<ProDataType> {

    BaseResult<ProDataType> saveProDataType(ProDataType proDataType);

}