/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.service.impl;

import com.cxytiandi.encrypt.util.JsonUtils;
import com.ftx.frame.util.calculate.NumberUtil;
import com.ftx.frame.util.object.ObjectUtil;
import com.se7en.biz.HttpUtil;
import com.se7en.biz.common.service.impl.BaseServiceImpl;
import com.se7en.biz.pro.entity.ProArea;
import com.se7en.biz.pro.entity.ProData;
import com.se7en.biz.pro.entity.ProDataType;
import com.se7en.biz.pro.mapper.ProDataMapper;
import com.se7en.biz.pro.service.ProAreaService;
import com.se7en.biz.pro.service.ProDataService;
import com.se7en.biz.pro.service.ProDataTypeService;
import com.se7en.conf.SysProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ProData 表服务层接口实现类
 *
 * @author se7en zhou
 * @since 2019-01-10 15:44:53
 */
@Service
public class ProDataServiceImpl extends BaseServiceImpl<ProDataMapper, ProData> implements ProDataService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProDataTypeService proDataTypeService;
    @Autowired
    private ProAreaService proAreaService;
    @Autowired
    private SysProperties sysProperties;
    @Autowired
    private ProDataMapper proDataMapper;

    public static void main(String[] args) {
        String a = "[{\"id\":\"35\",\"areaname\":\"\u65b0\u8de8\u533a1\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7535\u4fe1\",\"code\":\"101\",\"updatetime\":\"1547960169\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"36\",\"areaname\":\"\u65b0\u8de8\u533a2\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7535\u4fe1\",\"code\":\"102\",\"updatetime\":\"1547960169\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"37\",\"areaname\":\"\u65b0\u8de8\u533a3A\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7535\u4fe1\",\"code\":\"103\",\"updatetime\":\"1547997971\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"38\",\"areaname\":\"\u65b0\u8de8\u533a3B\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7535\u4fe1\",\"code\":\"104\",\"updatetime\":\"1547997971\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"39\",\"areaname\":\"\u65b0\u8de8\u533a4\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7535\u4fe1\",\"code\":\"105\",\"updatetime\":\"1547997971\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"40\",\"areaname\":\"\u65b0\u8de8\u533a5\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7535\u4fe1\",\"code\":\"106\",\"updatetime\":\"1547997971\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"41\",\"areaname\":\"\u65b0\u8de8\u533a6\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7f51\u901a\",\"code\":\"107\",\"updatetime\":\"1547997971\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"42\",\"areaname\":\"\u65b0\u8de8\u533a7\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7f51\u901a\",\"code\":\"108\",\"updatetime\":\"1547997971\",\"level\":\"2\",\"isfirst\":null,\"selected\":null},{\"id\":\"43\",\"areaname\":\"\u65b0\u8de8\u533a8\u533a\",\"gid\":\"1\",\"pid\":\"6\",\"type\":\"\u7f51\u901a\",\"code\":\"109\",\"updatetime\":\"1547997971\",\"level\":\"2\",\"isfirst\":null,\"selected\":null}]";

        try {
            String s = new String(a.getBytes(), "utf-8");
            System.out.println(s);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public List<ProData> retrieveProData(ProData proData) {
        return proDataMapper.retrieveProData(proData);
    }

    public void setData() {
//        String stime = LocalDate.now().plusMonths(-3).withDayOfMonth(1).toString();
        String stime = LocalDate.now().plusDays(-10).toString();
        String etime = LocalDate.now().toString();
        List<ProDataType> proDataTypes = proDataTypeService.retrieveList(null);
        List<ProArea> proAreas = proAreaService.retrieveList(new ProArea().setArea_id(35));
        for (ProArea proArea : proAreas) {
            for (ProDataType proDataType : proDataTypes) {
                String http = HttpUtil.http("id=" + proDataType.getId() + "&aid=" + proArea.getArea_id() + "&types=1&stime=" + stime + "&etime=" + etime, sysProperties.getPhpId(), sysProperties.getDataUrl());
//        String http = "{\"data1\":\"1940000,1800000,1780000,1900000,1955555,1999999,1930000,1911111,1890000,1825555,2079072,2200000,2181111,2122200,2122200,2122200,2122200,2122200,2249999,2249999,2249999,2249999,2249999,2299996,2277777,2350000,\",\"data2\":\"3100000,1600000,1600000,1600000,1666666,1666666,1809999,1809999,1890000,1925555,1925555,1925500,1949999,1949999,1949999,1949999,1949999,1949999,2180000,2180000,2180000,2180000,2180000,2180000,2222222,2222222,\",\"data3\":\"1565,5389,2859,1814,1588,1002,1151,1207,1596,1766,1831,2269,2288,1927,1927,1927,1927,1927,1593,1593,1593,1593,1593,1766,1473,1651,\",\"data4\":\"157,539,286,182,159,101,116,121,160,177,184,227,229,193,193,193,193,193,160,160,160,160,160,177,148,166,\",\"data5\":\"263.3895,906.9687,481.1697,305.2962,267.2604,168.6366,193.7133,203.1381,268.6068,297.2178,308.1573,381.8727,385.0704,324.3141,324.3141,324.3141,324.3141,324.3141,268.1019,268.1019,268.1019,268.1019,268.1019,297.2178,247.9059,277.8633,\",\"xAxis\":\"2019-01-01 12:39:50,2019-01-04 10:58:15,2019-01-05 03:06:48,2019-01-05 19:33:39,2019-01-06 09:01:12,2019-01-06 23:47:37,2019-01-07 12:16:06,2019-01-08 03:14:29,2019-01-08 15:31:42,2019-01-09 13:08:40,2019-01-10 04:51:08,2019-01-10 19:52:45,2019-01-11 14:35:34,2019-01-12 02:31:34,2019-01-12 02:31:34,2019-01-12 02:31:34,2019-01-12 02:31:34,2019-01-12 02:31:34,2019-01-12 12:34:01,2019-01-12 12:34:01,2019-01-12 12:34:01,2019-01-12 12:34:01,2019-01-12 12:34:01,2019-01-12 22:38:01,2019-01-13 16:37:00,2019-01-14 02:48:01,\",\"info\":{\"goodname\":\"+7\u9ec4\u91d1\u88c5\u5907\u589e\u5e45\u5238\"}} \n";
                Map map = JsonUtils.toBean(Map.class, http);
                String datas = map.get("data1").toString() + map.get("data2").toString();
                String xAxis = map.get("xAxis").toString();
                ProData proData;
                String[] data = datas.split(",");
                String[] xAxi = xAxis.split(",");
                List<ProData> list = new ArrayList<>();
                for (int i = 0; i < xAxi.length; i++) {
                    proData = new ProData();
                    proData.setId(proDataType.getId());
                    proData.setArea_id(proArea.getArea_id());
                    proData.setData_dt(xAxi[i]);
                    proData.setData_value(NumberUtil.toBigDecimal(data[i]));
                    list.add(proData);
                }
                removeDuplicateWithOrder(list);
//        list.stream().distinct();
                proDataMapper.mergeData(new ProData().setList(list));
            }
        }

    }

    public void removeDuplicateWithOrder(List list) {
        Map map = new HashMap<>();
        for (Object o : list) {
            Object id = ObjectUtil.invokeGetter(o, "id", false);
            Object data_dt = ObjectUtil.invokeGetter(o, "data_dt", false);
            map.put(id.toString() + data_dt.toString(), o);
        }
        list.clear();
        for (Object o : map.entrySet()) {
            list.add(o);
        }
        System.out.println(" remove duplicate " + list);
    }
}