package ua.com.alevel.dao;

import ua.com.alevel.entity.BaseEntity;

public interface BaseAdminDao <ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    ENTITY getAdmin();
}
