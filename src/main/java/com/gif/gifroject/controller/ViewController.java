package com.gif.gifroject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/view")
@Controller
public class ViewController {
    @RequestMapping("/home-view")
    public String home()
    {
        return "home";
    }
}
