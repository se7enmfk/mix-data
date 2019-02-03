package com.se7en.biz.common.util;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import com.ftx.frame.util.object.ObjectUtil;
import com.ftx.frame.util.string.StringUtil;
import com.se7en.biz.Constant;

import java.sql.Timestamp;

/**
 * Description: 对象常用操作
 * Author: Kakus
 * CreateTime: 2018/9/6 14:33
 */
public class EntityUtil {

    /**
     * 设置对象创建/修改信息
     *
     * @param entity
     * @param user_code
     */
    public static <T> void setCreateInfo(T entity, String user_code) {
        if (entity != null) {
            String operate_type = (String) ObjectUtil.invokeGetter(entity, "operate_type", false);
            setUpdInfo(entity, operate_type, user_code);
        }
    }

    /**
     * 设置对象创建/修改信息
     *
     * @param entity
     * @param user_code
     */
    public static <T> void setUpdInfo(T entity, String type, String user_code) {
        if (entity != null) {
            Timestamp current_ts = new Timestamp(System.currentTimeMillis());
            if (Constant.FORM_MODE_NEW.equals(type)) {
                if (StringUtil.isNotEmpty(user_code)) {
                    ObjectUtil.invokeSetter(entity, "create_by", user_code);
                }
                ObjectUtil.invokeSetter(entity, "create_ts", current_ts);
            } else {
                if (StringUtil.isNotEmpty(user_code)) {
                    ObjectUtil.invokeSetter(entity, "modify_by", user_code);
                }
                ObjectUtil.invokeSetter(entity, "modify_ts", current_ts);
            }
        }
    }

    public static <T> String getKey(T entity) {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(entity.getClass());
        Object o = ObjectUtil.invokeGetter(entity, tableInfo.getKeyProperty(), false);
        return o == null ? null : o.toString();
    }
}
