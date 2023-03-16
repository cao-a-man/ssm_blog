package com.offcn.controller;

import com.offcn.pojo.Btype;
import com.offcn.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("type")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //列表 -- 没有条件  没有分页
    @GetMapping("list")
    public String list(@RequestParam(required = false) Integer pid, Model model){
        //默认显示大类
        List<Btype> list = typeService.queryList(pid);
        model.addAttribute("list",list);
        return "type_list";
    }

    //添加操作
    @PostMapping("add")
    public String add(Btype btype){
        typeService.add(btype);
        return "redirect:/type/list";
    }
}
