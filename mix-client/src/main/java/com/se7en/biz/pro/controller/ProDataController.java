/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.controller;

import com.se7en.biz.common.controller.BaseController;
import com.se7en.biz.common.model.BaseResult;
import com.se7en.biz.pro.entity.ProData;
import com.se7en.biz.pro.service.ProDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ProData 表数据控制层
 *
 * @author se7en zhou
 * @since 2019-01-10 15:44:53
 */
@RestController
@RequestMapping("/")
public class ProDataController extends BaseController {

    @Autowired
    private ProDataService proDataService;

    /**
     * insert or update
     */
    @PostMapping(value = "/pro/data")
    public BaseResult<ProData> save(@RequestBody ProData proData) {
        return proDataService.save(proData);
    }

    /**
     * select entity List
     */
    @PostMapping(value = "/pro/dataList")
    public List<ProData> retrieveList(@RequestBody ProData proData) {
        return proDataService.retrieveProData(proData);
    }

    /**
     * select entity List
     */
    @PostMapping(value = "/pro/setData")
    public String setData(@RequestBody ProData proData) {
        proDataService.setData();
        return "s";
    }

}