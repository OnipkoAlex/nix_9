package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.OrderDao;
import ua.com.alevel.db.impl.OrderDBImpl;
import ua.com.alevel.entity.Order;

import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public void create(Order order) {
        OrderDBImpl.getInstance().create(order);
    }

    @Override
    public void update(Order order) {
        OrderDBImpl.getInstance().update(order);
    }

    @Override
    public void delete(String orderId) {
        OrderDBImpl.getInstance().delete(orderId);
    }

    @Override
    public void deleteByClientId(String id) {
        OrderDBImpl.getInstance().deleteByClientId(id);
    }

    @Override
    public Order findById(String orderId) {
        return OrderDBImpl.getInstance().findById(orderId);
    }

    @Override
    public List<Order> findByClientId(String id) {
        return OrderDBImpl.getInstance().findByClientId(id);
    }

    @Override
    public List<Order> findAll() {
        return OrderDBImpl.getInstance().findAll();
    }

    @Override
    public int sizeOf() {
        return OrderDBImpl.getInstance().sizeOf();
    }
}
