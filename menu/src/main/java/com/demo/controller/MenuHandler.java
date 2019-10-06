package com.demo.controller;

import com.demo.entity.MenuVO;
import com.demo.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuHandler {
    @Autowired
    private MenuRepository menuRepository;
    @Value("${server.port}")
    private String port;


    @GetMapping("/findAll/{page}/{limit}")
    public MenuVO findAll(@PathVariable("page") int page, @PathVariable("limit") int limit) {
        MenuVO menuVO = new MenuVO();
        menuVO.setCode(0);
        menuVO.setMsg("");
        menuVO.setCount(menuRepository.count());
        menuVO.setData(menuRepository.findAll((page - 1) * limit, limit));
        return menuVO;
    }

    @GetMapping("/index")
    public String index() {
        return "menu的端口：" + this.port;
    }

}
