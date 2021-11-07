package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;

public interface BaseOrderDB<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String orderId);
    void deleteByClientId(String id);
    ENTITY findById(String orderId);
    ENTITY[] findByClientId(String id);
    ENTITY[] findAll();
    int sizeOf();
}