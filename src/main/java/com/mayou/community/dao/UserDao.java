package com.mayou.community.dao;

import org.apache.ibatis.annotations.Select;
import com.mayou.community.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yfzhang
 * @Description:
 * @Date: Created in 7:05 PM 2020/2/17
 * @Modified By:
 */
@Repository
public interface UserDao {

    /*xml方式*/
    User findByName(String name);

    /*注解方式*/
    @Select("select * from users")
    List<User> findAll();
}
