package com.offcn.controller;

import com.github.pagehelper.PageInfo;
import com.offcn.pojo.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    //列表 和 查询
    @GetMapping("list")
    public String list(@RequestParam(required = false) String name, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "3") int pageSize, Model model){
        PageInfo<User>pageInfo = userService.queryList(name,currentPage,pageSize);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("name",name);
        return "user_list";
    }

    //用户冻结
    @GetMapping("cancel")
    public String cancel(User user){
        userService.cancel(user);
        return "redirect:/user/list";
    }
}
