package ua.com.alevel.service;

import ua.com.alevel.entity.Order;

public class OrderGenerationUtil {

    public static Order generateOrder(String firstName, String lastName, int width, int height, String color, String type) {
        Order order = new Order();
        order.setFirstName(firstName);
        order.setLastName(lastName);
        order.setWidth(width);
        order.setHeight(height);
        order.setColor(color);
        order.setType(type);
        return order;
    }
}
