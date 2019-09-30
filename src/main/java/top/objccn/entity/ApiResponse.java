package top.objccn.entity;

import top.objccn.enums.ApiResponseEnum;

/**
 * @Auter MrDML
 * @Date 2019-09-30
 */
public class ApiResponse {

    // 错误码
    private int errCode = 0;

    // 错误信息
    private  String errMsg;

    // 响应数据
    private  Object data;


    /**
     * 默认构造方法
     */
    public ApiResponse(){


    }

    /**
     * 指定构造方法
     * @param data
     */
    public ApiResponse(Object data){
     this.data = data;
    }


    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ApiResponse{" + "errCode=" + errCode + ", errMsg='" + errMsg + '\'' + ", data=" + data + '}';
    }
}
