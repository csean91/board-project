package com.example.controller;

import com.example.annotation.Controller;
import com.example.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * packageName    : com.example.controller
 * fileName       : HealthCheckController
 * author         : swch
 * date           : 2022-10-05
 * description    :
 */
@Controller
public class HealthCheckController {

    @RequestMapping(value = "/health", method = RequestMethod.GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
        return "ok";
    }
}
