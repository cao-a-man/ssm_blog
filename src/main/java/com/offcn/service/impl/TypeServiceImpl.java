package com.offcn.service.impl;

import com.offcn.dao.BtypeMapper;
import com.offcn.pojo.Btype;
import com.offcn.pojo.BtypeExample;
import com.offcn.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private BtypeMapper btypeMapper;

    @Override
    public List<Btype> queryList(Integer pid) {
        BtypeExample example = new BtypeExample();
        BtypeExample.Criteria criteria = example.createCriteria();
        if(pid != null){
            //查小类
            criteria.andTypePidEqualTo(pid);
        }else{
            criteria.andTypePidIsNull();
        }
        List<Btype> list = btypeMapper.selectByExample(example);
        for(Btype btype : list){
            Integer id = btype.getTypeid();
            BtypeExample example1 = new BtypeExample();
            BtypeExample.Criteria criteria1 = example1.createCriteria();
            criteria1.andTypePidEqualTo(id);

            List<Btype> child = btypeMapper.selectByExample(example1);

            btype.setChild(child);
        }
        return list;
    }

    //添加操作
    @Override
    public void add(Btype btype) {
        btypeMapper.insertSelective(btype);
    }
}
