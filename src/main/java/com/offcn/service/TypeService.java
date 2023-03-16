package com.offcn.service;

import com.offcn.pojo.Btype;

import java.util.List;

public interface TypeService {
    List<Btype> queryList(Integer pid);

    void add(Btype btype);
}
