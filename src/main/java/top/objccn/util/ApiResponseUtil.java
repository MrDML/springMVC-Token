package top.objccn.util;

import top.objccn.entity.ApiResponse;
import top.objccn.enums.ApiResponseEnum;

/**
 * @Auter MrDML
 * @Date 2019-09-30
 */
public class ApiResponseUtil {


    /**
     * 获取请求成功响应的ApiResponse
     * @param data
     * @return
     */
    public static ApiResponse getApiResponse(Object data){

        return getAPiResponse(data, ApiResponseEnum.SUCCESS.getErrCode(),ApiResponseEnum.SUCCESS.getErrMsg());
    }


    /**
     * 获取其他响应ApReponse,不带数据
     * @param code
     * @param msg
     * @return
     */
    public static ApiResponse getApiResponse(int code, String msg){

        return getAPiResponse(null,code,msg);
    }


    /**
     * 有枚举对象,转换响应 getApiResponse 对象
     * @param responseEnum
     * @return
     */
    public static  ApiResponse getApiResponse(ApiResponseEnum responseEnum){
        return getApiResponse(responseEnum.getErrCode(),responseEnum.getErrMsg());
    }



    /**
     * 获取响应信息
     * @param data
     * @param code
     * @param msg
     * @return
     */
    public static ApiResponse getAPiResponse(Object data, int code, String msg){
        ApiResponse apiResponse = new ApiResponse(data);
        apiResponse.setErrCode(code);
        apiResponse.setErrMsg(msg);
        return apiResponse;
    }


}
