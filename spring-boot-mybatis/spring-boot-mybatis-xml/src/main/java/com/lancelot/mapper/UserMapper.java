package com.lancelot.mapper;

import com.lancelot.model.User;

import java.util.List;

/**
 * @author lancelot
 * @date 2020/3/9
 */
public interface UserMapper {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
