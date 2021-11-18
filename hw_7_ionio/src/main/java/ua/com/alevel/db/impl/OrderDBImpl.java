package ua.com.alevel.db.impl;

import ua.com.alevel.db.OrderDB;
import ua.com.alevel.entity.Order;
import ua.com.alevel.lib.FileToObject;
import ua.com.alevel.lib.ObjectToFile;
import ua.com.alevel.util.GenerateOrderIDUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OrderDBImpl implements OrderDB {

    private static OrderDBImpl instance;
    private final Path path = Paths.get("Order.csv");

    private OrderDBImpl() {
    }

    public static OrderDBImpl getInstance() {
        if (instance == null) {
            instance = new OrderDBImpl();
        }
        return instance;
    }

    public void create(Order order) {
        order.setOrderId(GenerateOrderIDUtil.generate(order.getId()));
        ObjectToFile.runObjectToFile(order, path);
    }

    public void update(Order order) {
        List<Order> orders = findAll();

        for (Order i : orders) {
            if (i.getOrderId().equals(order.getOrderId())) {
                i.setFirstName(order.getFirstName());
                i.setLastName(order.getLastName());
                i.setWidth(order.getWidth());
                i.setHeight(order.getHeight());
                i.setColor(order.getColor());
                i.setType(order.getType());
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        orders.stream().forEach(x -> ObjectToFile.runObjectToFile(x, path));
    }

    public void deleteByClientId(String id) {
        List<Order> orderList = findAll();

        for (Order i : orderList) {
            if (i.getId().equals(id)) {
                orderList.remove(i);
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        orderList.stream().forEach(x -> ObjectToFile.runObjectToFile(x, path));
    }

    public void delete(String orderId) {
        List<Order> orderList = findAll();

        for (Order i : orderList) {
            if (i.getOrderId().equals(orderId)) {
                orderList.remove(i);
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        orderList.stream().forEach(x -> ObjectToFile.runObjectToFile(x, path));
    }

    public Order findById(String orderId) {
        List<Order> orders = findAll();
        for (Order i : orders) {
            if (i.getOrderId().equals(orderId)) {
                return i;
            }
        }
        return null;
    }

    public List<Order> findByClientId(String id) {
        List<Order> orders = findAll();
        int clientsOrders = 0;
        for (Order i : orders) {
            if (i.getId().equals(id)) clientsOrders++;
        }
        if (clientsOrders == 0) return null;
        List<Order> order = new ArrayList<>();
        for (Order i : orders) {
            if (i.getId().equals(id)) {
                order.add(i);
            }
        }
        return order;
    }

    public List<Order> findAll() {
        List<Order> orderList = new ArrayList<>();
        List<String[]> stringList = FileToObject.runFileToObject(path);

        if (stringList.size() == 0) return null;

        for (String[] line : stringList) {
            Order order = new Order();
            order.setOrderId(line[0]);
            order.setFirstName(line[1]);
            order.setLastName(line[2]);
            order.setWidth(Integer.parseInt(line[3]));
            order.setHeight(Integer.parseInt(line[4]));
            order.setColor(line[5]);
            order.setType(line[6]);
            order.setPrice(Integer.parseInt(line[7]));
            order.setId(line[8]);
            orderList.add(order);
        }

        return orderList;
    }

    @Override
    public int sizeOf() {
        return FileToObject.runFileToObject(path).size();
    }
}
