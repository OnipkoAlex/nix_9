package ua.com.alevel.dao;

import ua.com.alevel.db.CustomerDB;
import ua.com.alevel.entity.Customer;

public class CustomerDao {
    public void create(Customer customer) {
        CustomerDB.getInstance().create(customer);
    }

    public void update(Customer customer) {
        CustomerDB.getInstance().update(customer);
    }

    public void delete(int id) {
        CustomerDB.getInstance().delete(id);
    }

    public static int sizeOf() {
        return CustomerDB.sizeOf();
    }

    public Customer findById(int id) {
        return CustomerDB.getInstance().findById(id);
    }

    public Customer[] findAll() {
        return CustomerDB.getInstance().findAll();
    }
}
