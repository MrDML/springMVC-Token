package top.objccn.enums;

/**
 * @Auter MrDML
 * @Date 2019-09-30
 */
public enum ApiResponseEnum {

    /**
     * API 调用成功的回调
     */
    SUCCESS(10000,"请求成功"),
    FAIL(10001,"请求失败"),
    LOGIN_FAIL(10099,"登录失败"),
    AUTH_ERROR(10100,"认证失败");

    private int errCode = 0;
    private  String errMsg;



    private ApiResponseEnum(int errCode,String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
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
}
