package com.example.demomybatis.controller;

import com.example.demomybatis.dto.EntityDTO;
;
import com.example.demomybatis.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Api()
public class TestController {

    @Autowired
    private TestService testService;


    @ApiOperation(value = "查询id为1的用户")

    @RequestMapping(value = "/seluser")
    public EntityDTO seluser() {
        System.out.println("id：" + 1);
        Integer id = 1;
       EntityDTO user= testService.getById(id);
        return user;
    }

    @ApiOperation(value = "需要查询的id")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",paramType = "path",value = "你的id",required = true,dataType ="int")
    })

    @GetMapping("/{id}")
    public EntityDTO test(@PathVariable Integer id) {
        System.out.println("id:" + id);
        return testService.getById(id);
    }
}