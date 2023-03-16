package com.offcn.service;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.User;

public interface UserService {
    PageInfo<User> queryList(String name, int currentPage, int pageSize);

    void cancel(User user);
}
