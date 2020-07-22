package com.example.demomybatis.controller;

import com.example.demomybatis.dto.EntityDTO;
;
import com.example.demomybatis.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @ResponseBody
    @RequestMapping(value = "/seluser")
    public EntityDTO seluser() {
        System.out.println("id" + 1);
        Integer id = 1;
       EntityDTO user= testService.getById(id);
        return user;
    }

//    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
//    public EntityDTO test(@PathVariable Integer id) {
//        System.out.println("id:" + id);
//        return testService.getById(id);
//    }
}