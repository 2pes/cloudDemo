package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chen
 * @created 2019-10-05-21:44.
 */
@RestController
@RequestMapping("/order")
public class OrderHandler {
    @Value("${server.port}")
    private String port;

    @GetMapping("/index")
    public String index() {
        return "order的端口：" + this.port;
    }
}