package com.mayou.community.service;
/**
 * @Author: yfzhang
 * @Description:
 * @Date: Created in 7:07 PM 2020/2/17
 * @Modified By:
 */

import com.mayou.community.dao.UserDao;
import com.mayou.community.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findById(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }

    public int insert(User user) {
        return userDao.insert(user);
    }

}
