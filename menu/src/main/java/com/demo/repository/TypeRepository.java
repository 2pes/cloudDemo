package com.demo.repository;

import com.demo.entity.Type;

import java.util.List;

public interface TypeRepository {
    public List<Type> findAll();
}
