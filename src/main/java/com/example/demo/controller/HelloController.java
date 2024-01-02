package com.example.demo.controller;

import com.example.demo.pojo.Room;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private RoomService roomService;
    @RequestMapping("/hello")
    public Room hello(String name){
        System.out.println(name);
        System.out.println(roomService.findbyname(name));
        return roomService.findbyname(name);
    }
}
