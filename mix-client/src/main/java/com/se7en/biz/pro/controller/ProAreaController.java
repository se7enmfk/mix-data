/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.controller;

import com.se7en.biz.common.controller.BaseController;
import com.se7en.biz.common.model.BaseResult;
import com.se7en.biz.pro.entity.ProArea;
import com.se7en.biz.pro.service.ProAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * ProArea 表数据控制层
 *
 * @author se7en zhou
 * @since 2019-01-21 09:36:51
 */
@RestController
@RequestMapping("/")
public class ProAreaController extends BaseController {

	@Autowired
	private ProAreaService proAreaService;

	/** insert or update */
	@PostMapping(value = "/pro/area")
	public BaseResult<ProArea> save(@RequestBody ProArea proArea){
		return proAreaService.save(proArea);
	}

	/** select one entity */
	@PostMapping(value = "/pro/areaOne")
	public ProArea getOne(@RequestBody ProArea proArea){
		return proAreaService.getOne(proArea);
	}

	/** select entity List  */
	@PostMapping(value = "/pro/areaList")
	public List<ProArea> retrieveList(@RequestBody ProArea proArea){
		return proAreaService.retrieveList(null);
	}
}