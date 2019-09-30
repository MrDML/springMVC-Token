package top.objccn.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import top.objccn.pojo.User;
import top.objccn.service.IUserservice;

@Service
public class UserserviceImpl implements IUserservice {


    @Value("${jwt.exepire_time_minute}")
    private String exepire_time_minute;

    @Value("${jwt.token_secret}")
    private String token_secret;

    @Override
    public User findById(int id) {

        User user = new User();

        user.setName("李白");
        user.setAge(22);
        user.setId(id);
        user.setSex("男");
        return user;
    }

    @Override
    public Boolean checkUserInfo(String name, String password) {


        System.out.println("exepire_time = "+ exepire_time_minute);
        System.out.println("exepire_time = "+ token_secret);

        return true;
    }
}
