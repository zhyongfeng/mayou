package com.mayou.community.service;
/**
 * @Author: yfzhang
 * @Description:
 * @Date: Created in 7:07 PM 2020/2/17
 * @Modified By:
 */

import com.mayou.community.dao.UserDao;
import com.mayou.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findByName(String name) {
        User user = userDao.findByName(name);
        return user;
    }

    public List<User> findAll() {
        List<User> users = userDao.findAll();
        return users;
    }
}
