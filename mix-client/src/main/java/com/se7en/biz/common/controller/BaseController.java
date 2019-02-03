/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz.common.controller;

import com.ftx.frame.util.string.StringUtil;
import com.se7en.biz.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 设置每页显示的数目
     *
     * @param page
     */
	/*public <T> void setPageSize(Page<T> page) {

		page.setSize(SystemConfig.ROWS_PER_PAGE);
	}*/

    /**
     * json日期转换model日期
     *
     * @param binder
     */
    @InitBinder

    public void initBinder(HttpServletRequest request, WebDataBinder binder) {
        String contextPath = request.getServletPath();

        logger.debug(StringUtil.concat("request path:::::", contextPath));

        String user_ = (String) request.getAttribute(Constant.USER);
        String role_ = (String) request.getAttribute(Constant.ROLE);
        String bran_ = (String) request.getAttribute(Constant.BRAN);
        String com_ = (String) request.getAttribute(Constant.COMPANY);

        /*if (binder.getTarget() instanceof BaseObject) {
            String mode_ = (String) ObjectUtil.invokeGetter(binder.getTarget(), Constant.MODE, false);

            Object target = binder.getTarget();
            Field[] declaredFields = target.getClass().getDeclaredFields();
            for (Field field : declaredFields) {
                if (field.getName().equals("create_by") && StringUtil.isNotEmpty(user_) && Constant.FORM_MODE_NEW.equals(mode_)) {
                    ObjectUtil.invokeSetter(binder.getTarget(), "create_by", user_);
                }
                if (field.getName().equals("create_ts") && StringUtil.isNotEmpty(user_) && Constant.FORM_MODE_NEW.equals(mode_)) {
                    ObjectUtil.invokeSetter(binder.getTarget(), "create_ts", new Timestamp(System.currentTimeMillis()));
                }
                if (field.getName().equals("modify_by") && StringUtil.isNotEmpty(user_) && Constant.FORM_MODE_EDIT.equals(mode_)) {
                    ObjectUtil.invokeSetter(binder.getTarget(), "modify_by", user_);
                }
                if (field.getName().equals("modify_ts") && StringUtil.isNotEmpty(user_) && Constant.FORM_MODE_EDIT.equals(mode_)) {
                    ObjectUtil.invokeSetter(binder.getTarget(), "modify_ts", new Timestamp(System.currentTimeMillis()));
                }
                if (field.getName().equals("submit_user_code") && StringUtil.isNotEmpty(user_)) {
                    ObjectUtil.invokeSetter(binder.getTarget(), "submit_user_code", user_);
                }
                if (field.getName().equals("submit_role_code") && StringUtil.isNotEmpty(role_)) {
                    ObjectUtil.invokeSetter(binder.getTarget(), "submit_role_code", role_);
                }

            }
        }*/

    }

}