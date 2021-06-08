package com.testmany.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping(value = "/admin/ADM")
    public String admin () {
        return "/admin";
    }


}