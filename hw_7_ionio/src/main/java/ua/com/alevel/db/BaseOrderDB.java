package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;

import java.util.List;

public interface BaseOrderDB<ENTITY extends BaseEntity> {

    void create(ENTITY entity);
    void update(ENTITY entity);
    void delete(String orderId);
    void deleteByClientId(String id);
    ENTITY findById(String orderId);
    List<ENTITY> findByClientId(String id);
    List<ENTITY> findAll();
    int sizeOf();
}