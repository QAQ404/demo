package com.example.demo.dao;

import com.example.demo.pojo.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoomMapper {

    @Select("select r_name as name,r_address as address,r_phone as phone from room where r_name = #{name}")
    public Room findbyname(String name);
}
