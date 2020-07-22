package com.dao;

import com.domain.QueryVo;
import com.domain.User;

import java.util.List;

public interface IUserDao {
    List<User>findAll();
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Integer userId);
    User findOneUser(Integer userId);
    List<User>findByname(String username);
    List<User>findByCondition(User user);
    List<User>findUserInIds(QueryVo vo);

}
