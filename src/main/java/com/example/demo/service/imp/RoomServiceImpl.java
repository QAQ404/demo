package com.example.demo.service.imp;

import com.example.demo.mapper.RoomMapper;
import com.example.demo.pojo.Room;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public Room findbyname(String name) {
        return roomMapper.findbyname(name);
    }
}
