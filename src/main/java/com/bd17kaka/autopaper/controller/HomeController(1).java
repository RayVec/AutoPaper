package com.bd17kaka.autopaper.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


	@RequestMapping(value = "/")
    public String getUser(){
        return "forward:/index.html";
    }


}
