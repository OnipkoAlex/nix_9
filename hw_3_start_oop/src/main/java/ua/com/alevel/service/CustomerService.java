package ua.com.alevel.service;

import ua.com.alevel.dao.CustomerDao;
import ua.com.alevel.db.CustomerDB;
import ua.com.alevel.entity.Customer;

public class CustomerService {
    private final CustomerDao customerDao = new CustomerDao();

    public void create(Customer customer) {
        customerDao.create(customer);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }

    public void delete(int id) {
        customerDao.delete(id);
    }

    public Customer findById(int id) {
        return customerDao.findById(id);
    }

    public Customer[] findAll() {
        return customerDao.findAll();
    }

    public static int sizeOf() {
        return CustomerDB.sizeOf();
    }
}
