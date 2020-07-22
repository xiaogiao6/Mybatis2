package com.example.demomybatis.service;


import com.example.demomybatis.dao.TestDao;
import com.example.demomybatis.dto.EntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TestDao testDao;

    public EntityDTO getById(Integer id) {
        return testDao.getById(id);
    }

}