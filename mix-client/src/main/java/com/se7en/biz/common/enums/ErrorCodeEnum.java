package com.se7en.biz.common.enums;

import com.ftx.frame.common.component.FtxException;

/**
 * @author XCQ
 * 中台六位错误码
 */
public enum ErrorCodeEnum {
    dataModify("FOS 000001", "该数据已被修改，请重新查询操作。"),
    assetEmpty("FOS 000002", "委托资产不能为空！"),
    trustVolNotEquals("FOS 000003", "受益权份额合计与资金管理单元信托财产份额不相等！"),
    trustPercentNotHundred("FOS 000004", "受益权份额占比合计应为100%！"),
    accBnfDivideEmpty("FOS 000005", "请填写%s的资产比例划分！"),
    trustBnfEmpty("FOS 000006", "请填写资产份额比例划分！"),
    feeCheck("FOS 000007", "资金管理单元账户可用现金大于等于需支付的建档费！"),
    rightStatusCheck1("FOS 000008", "受益人【%s】正在处理状态变更，不能划分比例!"),
    rightStatusCheck2("FOS 000009", "受益人【%s】正在处理状态变更，不能交易!"),
    assetValidDtCheck("FOS 000010", "【%s】受让日应大于等于信托成立日、小于等于信托生效日！"),
    assetValidDtCheckReceipt("FOS 000011", "【%s】收款日期应大于等于信托成立日、小于等于信托生效日！"),
    assetValidDtCheck2("FOS 000012", "【%s】受让日小于等于信托单位追加日！"),
    assetValidDtCheck2Receipt("FOS 000013", "【%s】收款日期小于等于信托单位追加日！"),
    assetValidDtCheck3("FOS 000014", "【%s】受让日应大于等于追加委托申请日、小于等于信托单位追加日！"),
    assetValidDtCheck3Receipt("FOS 000015", "【%s】收款日期应大于等于追加委托申请日、小于等于信托单位追加日！"),

    ;
    private String returnCode;
    private String returnDesc;

    ErrorCodeEnum(String returnCode, String returnDesc) {
        this.returnCode = returnCode;
        this.returnDesc = returnDesc;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public String getReturnDesc() {
        return returnDesc;
    }

    public static void throwFtxException(ErrorCodeEnum code, Object... formatStr) {

        String desc = code.returnDesc;

        if (formatStr != null && formatStr.length > 0) {
            desc = String.format(desc, formatStr);
        }
        throw new FtxException(code.returnCode, desc);

    }
}
