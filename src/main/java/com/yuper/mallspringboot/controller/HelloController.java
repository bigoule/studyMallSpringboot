package com.yuper.mallspringboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "HelloController", description = "this is my first springboot controller")
@RestController
//@Controller
public class HelloController {
    @ApiOperation("ｈｅｌｌo问候接口")
    @RequestMapping(value = "hello", method = RequestMethod.GET)
//    @ResponseBody
    public String hello(){
        return "This is My first springbootDeom!";
    }
}
