package ua.com.alevel.service;

import ua.com.alevel.entity.BaseEntity;

public interface BaseOrderService <ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String orderId);
    void deleteByClientId(String id);
    ENTITY findById(String orderId);
    ENTITY[] findByClientId(String id);
    ENTITY[] findAll();
    int sizeOf();
}
