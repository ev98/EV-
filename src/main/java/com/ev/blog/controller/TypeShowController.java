package com.ev.blog.controller;


import com.ev.blog.pojo.Blog;
import com.ev.blog.pojo.Type;
import com.ev.blog.service.BlogService;
import com.ev.blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types/{id}")
    public String types(@PathVariable Long id, @RequestParam(required = false,defaultValue = "1",value = "pagenum")int pagenum,
                        Model model){
        PageHelper.startPage(pagenum, 50);  //开启分页
        List<Type> types = typeService.getBlogType();
        //-1从导航点过来的
        if (id == -1){
            id = types.get(0).getId();
        }
        List<Blog> blogs = blogService.getByTypeId(id);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("types", types);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTypeId", id);

        return "types";
    }
}
