package top.objccn.service;

import top.objccn.pojo.User;

public interface IUserservice {


    /**
     * 根据ID查询
     * @param id
     * @return
     */
    User findById(int id);


    /**
     * 校验用户信息是否正确
     * @param name
     * @param password
     * @return
     */
    Boolean checkUserInfo(String name, String password);

}
