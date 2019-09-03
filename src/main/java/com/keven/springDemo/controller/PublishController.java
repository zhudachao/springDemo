package com.keven.springDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keven.springDemo.service.PublishService;

@RestController
@RequestMapping("publisher")
public class PublishController {
 
    @Autowired
    private PublishService publishService;
 
    @RequestMapping("{name}")
    public String sendMessage(@PathVariable("name") String name) {
        List<String> strLists = new ArrayList<>();
        for(int i =0 ;i<10;i++){
            String result =  publishService.sendMessage(name+i);
            strLists.add(result);
        }
         return strLists.toString();
    }
}
