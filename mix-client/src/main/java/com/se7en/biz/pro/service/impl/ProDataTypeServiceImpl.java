/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.pro.service.impl;

import com.cxytiandi.encrypt.util.JsonUtils;
import com.se7en.biz.HttpUtil;
import com.se7en.biz.common.model.BaseResult;
import com.se7en.biz.common.service.impl.BaseServiceImpl;
import com.se7en.biz.pro.entity.ProDataType;
import com.se7en.biz.pro.mapper.ProDataTypeMapper;
import com.se7en.biz.pro.service.ProDataTypeService;
import com.se7en.conf.SysProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ProDataType 表服务层接口实现类
 *
 * @author se7en zhou
 * @since 2019-01-10 16:04:57
 */
@Service
public class ProDataTypeServiceImpl extends BaseServiceImpl<ProDataTypeMapper, ProDataType> implements ProDataTypeService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProDataTypeMapper proDataTypeMapper;
    @Autowired
    private SysProperties sysProperties;

    @Override
    public BaseResult<ProDataType> saveProDataType(ProDataType proDataType) {

        try {
//            for (int i = 0; i < 100; i++) {
                String url = "http://dnfwujia.com/index.php/Index/Index/search";
                String http = HttpUtil.http("name=" + URLEncoder.encode(proDataType.getName(), "UTF-8"), sysProperties.getPhpId(), url);
//                String content = StringUtil.isNotEmpty(proDataType.getContent())?proDataType.getContent():"page="+i;
//                String http = HttpUtil.http(content,sysProperties.getPhpId(), url);
//            String http = "{\"count\":\"8\",\"size\":0,\"page\":null,\"alist\":[{\"id\":\"648\",\"goodname\":\"+7\\u9ec4\\u91d1\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1003\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535896934\",\"img\":\"uploads\\/149318935048825.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"649\",\"goodname\":\"+7\\u94c2\\u91d1\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1004\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535896945\",\"img\":\"uploads\\/149318933195624.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"650\",\"goodname\":\"+7\\u7fe1\\u7fe0\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1005\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535896991\",\"img\":\"uploads\\/149318929038526.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"651\",\"goodname\":\"+7\\u94bb\\u77f3\\u88c5\\u5907\\u5f3a\\u5316\\u5238\",\"code\":\"1006\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897045\",\"img\":\"uploads\\/149318925936633.png\",\"typeid1\":\"8\",\"typeid2\":\"210\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"670\",\"goodname\":\"+7\\u9ec4\\u91d1\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1025\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897433\",\"img\":\"uploads\\/149318859079491.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"671\",\"goodname\":\"+7\\u94c2\\u91d1\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1026\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897445\",\"img\":\"uploads\\/149318856467840.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"672\",\"goodname\":\"+7\\u7fe1\\u7fe0\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1027\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897455\",\"img\":\"uploads\\/149318854140618.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"},{\"id\":\"673\",\"goodname\":\"+7\\u94bb\\u77f3\\u88c5\\u5907\\u589e\\u5e45\\u5238\",\"code\":\"1028\",\"nowprice\":\"0\",\"gid\":\"1\",\"aid\":null,\"createtime\":\"1535897464\",\"img\":\"uploads\\/149318851567439.png\",\"typeid1\":\"8\",\"typeid2\":\"211\",\"typeid3\":\"0\",\"styleid\":\"1\"}]}";
                Map map = JsonUtils.toBean(Map.class, http);
                List<Map<String, Object>> alist = (List<Map<String, Object>>) map.get("alist");
                List<ProDataType> list = new ArrayList<>();
                ProDataType proDataType1;
                for (Map<String, Object> map1 : alist) {
                    proDataType1 = new ProDataType();
                    proDataType1.setId(Integer.parseInt(map1.get("id").toString()));
                    proDataType1.setName(new String(map1.get("goodname").toString().getBytes(), "utf-8"));
                    list.add(proDataType1);
                }
                proDataType.setList(list);
                proDataTypeMapper.mergeProDataType(proDataType);
//            }

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new BaseResult<>(proDataType);
    }
}