package com.example.controller;

import com.example.annotation.RequestMapping;
import com.example.annotation.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * packageName    : com.example.mvcpractice.controller
 * fileName       : HomeController
 * author         : swch
 * date           : 2022-10-04
 * description    :
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "home";
    }
}
