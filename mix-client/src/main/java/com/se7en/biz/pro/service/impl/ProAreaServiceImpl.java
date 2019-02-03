/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.service.impl;

import com.se7en.biz.common.service.impl.BaseServiceImpl;
import com.se7en.biz.pro.entity.ProArea;
import com.se7en.biz.pro.mapper.ProAreaMapper;
import com.se7en.biz.pro.service.ProAreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * ProArea 表服务层接口实现类
 *
 * @author se7en zhou
 * @since 2019-01-21 09:36:51
 */
@Service
public class ProAreaServiceImpl extends BaseServiceImpl<ProAreaMapper, ProArea> implements ProAreaService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

}