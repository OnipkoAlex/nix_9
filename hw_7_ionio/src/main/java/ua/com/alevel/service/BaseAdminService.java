package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

public interface BaseAdminService <ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    ENTITY getAdmin();
}
