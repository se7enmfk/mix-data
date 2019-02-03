/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.controller;

import com.se7en.biz.common.controller.BaseController;
import com.se7en.biz.common.model.BaseResult;
import com.se7en.biz.pro.entity.ProDataType;
import com.se7en.biz.pro.service.ProDataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * ProDataType 表数据控制层
 *
 * @author se7en zhou
 * @since 2019-01-10 16:04:57
 */
@RestController
@RequestMapping("/")
public class ProDataTypeController extends BaseController {

	@Autowired
	private ProDataTypeService proDataTypeService;

	/** insert or update */
	@PostMapping(value = "/pro/dataType")
	public BaseResult<ProDataType> saveProDataType(@RequestBody ProDataType proDataType){
		return proDataTypeService.saveProDataType(proDataType);
	}

	/** select entity List  */
	@PostMapping(value = "/pro/dataTypeList")
	public List<ProDataType> retrieveList(@RequestBody ProDataType proDataType){
		return proDataTypeService.retrieveList(null);
	}
}