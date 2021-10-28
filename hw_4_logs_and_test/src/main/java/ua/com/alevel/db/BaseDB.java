package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;

public interface BaseDB<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(Integer id);
    ENTITY findById(Integer id);
    ENTITY[] findAll();
}