package ua.com.alevel.db;

import ua.com.alevel.entity.Customer;

public class CustomerDB {
    private final Customer[] customers;
    private static CustomerDB instance;
    private static int newCustomerId = 0;


    private CustomerDB() {
        customers = new Customer[100];
    }

    public static CustomerDB getInstance() {
        if (instance == null) {
            instance = new CustomerDB();
        }
        return instance;
    }

    public void create(Customer customer) {
        customer.setId(newCustomerId);
        customers[newCustomerId] = customer;
        newCustomerId++;
    }

    public void update(Customer customer) {
        Customer current = findById(customer.getId());
        current.setAge(customer.getAge());
        current.setFirstName(customer.getFirstName());
    }

    public void delete(int id) {
        for (int i = id; i < newCustomerId - 1; i++) {
            customers[i] = customers[i + 1];
            customers[i].setId(customers[i].getId() - 1);
        }
        newCustomerId--;
    }

    public Customer findById(int id) {
        return customers[id];
    }

    public static int sizeOf() {
        return newCustomerId;
    }

    public Customer[] findAll() {
        return customers;
    }
}
