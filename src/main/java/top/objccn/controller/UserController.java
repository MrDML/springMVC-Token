package top.objccn.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.objccn.entity.ApiResponse;
import top.objccn.enums.ApiResponseEnum;
import top.objccn.pojo.User;
import top.objccn.service.IUserservice;
import top.objccn.util.ApiResponseUtil;
import top.objccn.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserservice iuserservice;

    @Autowired
    JwtUtil jwtUtil;


    /**
     * headers = {"content-type=application/json"}
     * 请求格式必须是json
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public ApiResponse login(@RequestBody Map<String,Object>map){

        String name = (String)map.get("name");
        String password = (String)map.get("password");

        if (name != null && !("".equals(name)) && password != null && !("".equals(password))){

          // 校验用户信息
          Boolean success  = iuserservice.checkUserInfo(name, password);

          if (success){

              // 下发token
              String token = jwtUtil.createToekn(name,"1");

              String userName = jwtUtil.getUserName(token);
              Boolean aBoolean = jwtUtil.verifyToken(token);

              System.out.println("是否验证成功:"+ aBoolean);


              System.out.println("userName:"+userName);

              System.out.printf("token:"+token);

              if (token != null && !("".equals(token))){

                  HashMap<Object, Object> resmap = new HashMap<>();
                  resmap.put("token",token);

                  return ApiResponseUtil.getApiResponse(resmap);
              }
          }

        }

        return ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);
    }


    /**
     * 请求格式是正常的表单请求
     * @param id
     * @return
     */
    @RequestMapping("/findById")
    public ApiResponse findById(String id){

        User user = iuserservice.findById(Integer.parseInt(id));

        return ApiResponseUtil.getApiResponse(user);
    }


    @RequestMapping("/celebrate")
    public ApiResponse celebrate(String id){

        HashMap<String, Object> map = new HashMap<>();

        map.put("title","庆祝中华人民共和国成立70周年");
        map.put("desc","国是我的国,家是我的家,我爱我的国,我爱我的家,伟大的祖国,我为你自豪!" +
                "                                                                 " +
                "祝大家国庆快乐!"+
                "                                                                                                    " +
                "                                           " +
                "--Mr_DML");

        return ApiResponseUtil.getApiResponse(map);
    }










}
