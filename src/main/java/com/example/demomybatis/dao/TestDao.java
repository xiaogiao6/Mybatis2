package com.example.demomybatis.dao;

import com.example.demomybatis.dto.EntityDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestDao {

    EntityDTO getById(Integer id);

}