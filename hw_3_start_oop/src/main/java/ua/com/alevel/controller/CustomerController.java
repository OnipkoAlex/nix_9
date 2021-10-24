package ua.com.alevel.controller;

import ua.com.alevel.entity.Customer;
import ua.com.alevel.service.CustomerService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CustomerController {
    private static final CustomerService customerService = new CustomerService();

    public static void run() {
        String position;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private static void runNavigation() {
        System.out.println();
        System.out.println("1 to add customer.");
        System.out.println("2 to update customer.");
        System.out.println("3 to delete customer.");
        System.out.println("4 to findById customer.");
        System.out.println("5 to findAll customers.");
        System.out.println("6 to exit.");
        System.out.println();
    }

    private static void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
            case "6":
                System.exit(0);
                break;
        }
        runNavigation();
    }

    private static void create(BufferedReader reader) {
        System.out.println("CustomerController.create");
        do {
            try {
                System.out.println("Please, enter customer's first name");
                String firstName = reader.readLine();
                System.out.println("Please, enter customer's second name");
                String secondName = reader.readLine();
                System.out.println("Please, enter customer's age");
                String ageString = reader.readLine();
                int age = Integer.parseInt(ageString);
                Customer customer = new Customer();
                customer.setAge(age);
                customer.setFirstName(firstName);
                customer.setSecondName(secondName);
                customerService.create(customer);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("problem: = " + e.getMessage());
            }
        } while (true);
    }

    private static void update(BufferedReader reader) {
        System.out.println("CustomerController.update");
        do {
            try {
                System.out.println("Please, enter customer's id");
                String idString = reader.readLine();
                System.out.println("Please, enter customer's first name");
                String firstName = reader.readLine();
                System.out.println("Please, enter customer's second name");
                String secondName = reader.readLine();
                System.out.println("Please, enter customer's age");
                String ageString = reader.readLine();
                int age = Integer.parseInt(ageString);
                int id = Integer.parseInt(idString);
                Customer customer = new Customer();
                customer.setId(id);
                customer.setFirstName(firstName);
                customer.setSecondName(secondName);
                customer.setAge(age);
                customerService.update(customer);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("problem: = " + e.getMessage());
            }
        } while (true);
    }

    private static void delete(BufferedReader reader) {
        System.out.println("CustomerController.delete");
        do {
            try {
                System.out.println("Please, enter id");
                int id = Integer.parseInt(reader.readLine());
                customerService.delete(id);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("problem: = " + e.getMessage());
            }
        }while (true);
    }

    private static void findById(BufferedReader reader) {
        System.out.println("CustomerController.findById");
        do {
            try {
                System.out.println("Please, enter id");
                int id = Integer.parseInt(reader.readLine());
                Customer customer = customerService.findById(id);
                System.out.println("customer = " + customer);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println("problem: = " + e.getMessage());
            }
        }while (true);
    }

    private static void findAll(BufferedReader reader) {
        System.out.println("CustomerController.findAll");
        Customer[] customers = customerService.findAll();
        if (customers != null && CustomerService.sizeOf() != 0) {
            for (int i = 0; i < CustomerService.sizeOf(); i++) {
                System.out.println(customers[i]);
            }
        } else {
            System.out.println("customers empty");
        }
    }
}
