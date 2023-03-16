package com.offcn.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.offcn.dao.UserMapper;
import com.offcn.pojo.User;
import com.offcn.pojo.UserExample;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //列表 分页 条件
    @Override
    public PageInfo<User> queryList(String name, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        UserExample example = new UserExample();
        if(name != null && name.length() > 0){
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUnameLike("%" + name + "%");
        }
        List<User> users = userMapper.selectByExample(example);
        PageInfo<User>pageInfo = new PageInfo<>(users,5);
        return pageInfo;
    }

    //冻结用户
    @Override
    public void cancel(User user) {
       userMapper.updateByPrimaryKeySelective(user);
    }
}
