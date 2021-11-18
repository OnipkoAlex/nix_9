package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;

public interface BaseAdminDB<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    ENTITY getAdmin();
}
