/*
 * Copyright (c) 2017- Ftecx Corp.
 * All rights reserved.
 */
package com.se7en.biz;

import com.ftx.frame.util.BaseConstant;
import com.ftx.frame.util.date.DateUtil;
import com.ftx.frame.util.properties.PropertiesUtil;

public class Constant extends BaseConstant {

    public final static String[] ALLOW_URLS = {"/sys/configList", "/adm/roleMenuList", "/adm/sysParamList", "/adm/userAccess"};

    public final static String MAX_DATE = "9999-12-31";

    public final static String REQUEST_STR = "request";
    public final static String RESPONSE_STR = "response";
    public final static String XML_TITLE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    public final static String RET_CODE = "000000";
    public final static String RET_MSG = "success";

    public final static String PRJ_STATUS_M = "M";
    public final static String PRJ_STATUS_B = "B";
    public final static String PRJ_STATUS_D = "D";

    public static final String AUDIT_STATUS_DFT = "DFT";

    public final static String P001 = "P001"; //项目建立
    public final static String P002 = "P002"; //项目变更
    public final static String P003 = "P003"; //委托人信息变更
    public final static String P004 = "P004"; //共有人信息变更
    public final static String P005 = "P005"; //资金管理单元信息变更
    public final static String P007 = "P007"; //事务服务事项信息披露变更
    public final static String P008 = "P008"; //事务服务事项常规询证计划变更
    public final static String P009 = "P009"; //变更条件设定

    public final static String RECV_TYPE_00 = "0";  //由委托人于其联系地址收取，以下可不填写
    public final static String RECV_TYPE_01 = "1";  //由委托人于其保单载记住址收取
    public final static String RECV_TYPE_02 = "2";  //以下独立填写

    public final static String TYPE_OTH = "OTH";  //其它 输入项

    public final static String ORG_TYPE_R = "R"; //客户推荐机
    public final static String ORG_TYPE_S = "S"; //客户推荐机构

    public final static String SUBMIT_STATUS_S = "S"; //成立提交
    public final static String SUBMIT_STATUS_M = "M"; //变更提交
    public final static String SUBMIT_STATUS_NA = "NA"; //保存
    public final static String SUBMIT_STATUS_ENA = "ENA"; //启用
    public final static String SUBMIT_STATUS_STP = "STP"; //暂停
    public final static String SUBMIT_STATUS_DEL = "DEL"; //作废
    public final static String SUBMIT_STATUS_DON = "DON"; //完成
    public final static String SUBMIT_STATUS_CNL = "CNL"; //取消
    public final static String SUBMIT_STATUS_ADT = "ADT"; //审核中

    public final static String TYPE_0 = "0";
    public final static String TYPE_1 = "1";
    public final static String TYPE_2 = "2";
    public final static String TYPE_3 = "3";
    public final static String TYPE_4 = "4";

    public final static String LIMIT_STYLE_0 = "0";  //当事人限制方式  0：按身份指定当事人
    public final static String LIMIT_STYLE_1 = "1";  //当事人限制方式  1：按身份的全部当事人

    public final static String ADDR_TYPE_C = "C";  //C:联系地址
    public final static String ADDR_TYPE_H = "H"; //H:家庭地址
    public final static String ADDR_TYPE_O = "O"; //O:办公地址
    public final static String ADDR_TYPE_R = "R"; //R:注册地址

    //当事人和当事人关联类型（1紧急联系人；2寄送地址（代收）联系人；3委托人的共有人；4受益人的监护人、5晚辈、6直系血亲、7法定继承人；）
    public final static String PTYS_REL_MAP_TYPE_01 = "1";  //紧急联系人
    public final static String PTYS_REL_MAP_TYPE_02 = "2";  //寄送地址（代收）联系人
    public final static String PTYS_REL_MAP_TYPE_03 = "3";  //委托人的共有人
    public final static String PTYS_REL_MAP_TYPE_04 = "4";  //受益人的监护人
    public final static String PTYS_REL_MAP_TYPE_05 = "5";  //晚辈
    public final static String PTYS_REL_MAP_TYPE_06 = "6";  //直系血亲
    public final static String PTYS_REL_MAP_TYPE_07 = "7";  //法定继承人

    //被保险人
    public final static String PARTY_TYPE_7 = "7";  //被保险人

    //资产细类
    public final static String ASSET_SUB_TYPE_C = "C";  //资金类
    public final static String ASSET_SUB_TYPE_F = "F";  //金融资产
    public final static String ASSET_SUB_TYPE_I = "I";  //保单
    public final static String ASSET_SUB_TYPE_H = "H";  //房产
    public final static String ASSET_SUB_TYPE_S = "S";  //股票
    public final static String ASSET_SUB_TYPE_E = "E";  //股权
    public final static String ASSET_SUB_TYPE_A = "A";  //艺术品
    public final static String ASSET_SUB_TYPE_L = "L";  //奢饰品
    public final static String ASSET_SUB_TYPE_O = "O";  //其他

    public final static String ASS_REG_TYPE_PN = "PN";  //池子无预设分配

    //事务服务事项 事项类型
    public final static String SERVICE_TYPE_PR = "PR";  //定期报告 Periodic report
    public final static String SERVICE_TYPE_LR = "LR";  //清算报告  Liquidation report
    public final static String SERVICE_TYPE_CCS = "CCS";  //常规询证计划  Conventional consultation scheme

    public final static String INCOME_EXPENSES_I = "I"; //收入
    public final static String INCOME_EXPENSES_E = "E"; //支出

    public final static String FUNDS_FROM_INASSET = "INASSET"; //资金来源  内含于资产
    public final static String FUNDS_FROM_INFEE = "INFEE"; //资金来源  内含于费用
    public final static String FUNDS_FROM_OUT = "OUT"; //资金来源  外含

    public final static String OPERATE_TYPE_N = "N"; //操作类型 新增
    public final static String OPERATE_TYPE_E = "E"; //操作类型 编辑
    public final static String OPERATE_TYPE_D = "D"; //操作类型 删除（清空）

    public final static String ROLE_CODE_TM = "TM"; //信托经理
    public final static String ROLE_CODE_TSM = "TSM"; //服务经理
    public final static String ROLE_CODE_IM = "IM"; //投资经理

    public final static String SEARCH_TYPE_prjManageUserAssign = "prjManageUserAssign"; //查询类型 项目人员指派
    public final static String SEARCH_TYPE_prjManageUserAdjust = "prjManageUserAdjust"; //查询类型 项目人员调整
    public final static String ASSIGNED_TYPE_A = "A"; //全部调整

    public final static String UPL_MODULE_V = "V"; //项目估值数据
    public final static String UPL_MODULE_H = "H"; //项目持仓数据
    public final static String UPL_MODULE_P = "P"; //池子底层产品

    public static final String SC_SYS_ASSIGNEE_NO = "SYS_ASSIGNEE_NO";//系统受托人编号
    public static final String SC_SYS_ASSIGNEE_LOG_NO = "SYS_ASSIGNEE_LOG_NO";//系统受托人日志编号
    public static final String SC_SYS_ASSIGNEE_ACC_NO = "SYS_ASSIGNEE_ACC_NO";//系统受托人账户号
    public static final String SC_SYS_ASSIGNEE_ACC_NAME = "SYS_ASSIGNEE_ACC_NAME";//系统受托人账户名
    public static final String SC_SYS_ASSIGNEE_ACC_OPEN_BANK = "SYS_ASSIGNEE_ACC_OPEN_BANK";//系统受托人开户行

    public static final String PARTY_TYPE_1 = "1";//委托人
    public static final String PARTY_TYPE_2 = "2";//受托人
    public static final String PARTY_TYPE_3 = "3";//受益人
    public static final String PARTY_TYPE_4 = "4";//监察人

    public final static String COUNT_TYPE_1 = "1";   //统计类型  信托经理
    public final static String COUNT_TYPE_2 = "2";   //统计类型 分布区域

    public static final String OPERATE_TYPE_SEL = "SEL";    //查询
    public static final String OPERATE_TYPE_EXP = "EXP";    //文件导出

    public static final String COUNT_SIZE_PRV = "PRV";    //统计维度  省
    public static final String COUNT_SIZE_CT = "CT";    //统计维度  市
    public static final String COUNT_SIZE_CUNTY = "CUNTY";    //统计维度  区（县）
    public static final String COUNT_SIZE_10= "10";    //总行
    public static final String COUNT_SIZE_20 = "20";    //分行
    public static final String COUNT_SIZE_30 = "30";    //二分
    public static final String COUNT_SIZE_70 = "70";    //一支
    public static final String COUNT_SIZE_80 = "80";    //二支
    public static final String COUNT_SIZE_90 = "90";    //网点

    public static final String SCALE_TYPE_0 = "0";    //全选或为空
    public static final String SCALE_TYPE_1 = "1";    //资金管理单元规模
    public static final String SCALE_TYPE_2 = "2";    //非资金管理单元规模

    public static final String PROCESS_DESCRIPTION = "process_description";    //审核单名称

    public final static PropertiesUtil KEY_LIST = PropertiesUtil.getInstance("key");

    public static final String SUPP_MAP_TYPE_1 = "1";//项目信息
    public static final String SUPP_MAP_TYPE_2 = "2";//当事人信息
    public static final String SUPP_MAP_TYPE_3 = "3";//当事人与项目关联信息

    public static final java.sql.Date RIGHT_START_DT = DateUtil.stringToDate("1900-01-01");
    public static final java.sql.Date RIGHT_END_DT = DateUtil.stringToDate("9999-12-31");
}
