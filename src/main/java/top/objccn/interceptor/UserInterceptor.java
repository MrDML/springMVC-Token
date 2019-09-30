package top.objccn.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import top.objccn.entity.ApiResponse;
import top.objccn.enums.ApiResponseEnum;
import top.objccn.util.ApiResponseUtil;
import top.objccn.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserInterceptor implements HandlerInterceptor{



    @Autowired
    JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setCharacterEncoding("utf-8");

        String auth_token = request.getHeader("auth_token");

        if (auth_token != null){
            // 验证token是否正确
            Boolean aBoolean = jwtUtil.verifyToken(auth_token);

            if (aBoolean){

                System.out.println("验证成功");
                return true;
            }

        }

        ApiResponse apiResponse = ApiResponseUtil.getApiResponse(ApiResponseEnum.AUTH_ERROR);

        responseMessage(response,apiResponse);

      /*  request.setCharacterEncoding("UTF-8");

        response.setContentType("text/json;charset=utf-8");
     */
      /*  String authorization = request.getHeader("Authorization");


        System.out.println("Authorization:"+authorization);
       */

        System.out.println("进入了拦截器......");

        return false;
    }

    private void responseMessage(HttpServletResponse response, ApiResponse apiResponse){

        response.setContentType("text/json;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(JSONObject.toJSONString(apiResponse));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
