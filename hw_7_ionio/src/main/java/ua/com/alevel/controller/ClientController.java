package ua.com.alevel.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import ua.com.alevel.entity.Access;
import ua.com.alevel.entity.Client;
import ua.com.alevel.service.impl.ClientServiceImpl;

public class ClientController {
    public static final ClientServiceImpl clientService = new ClientServiceImpl();

    private static final Logger LOGGER_INFO = LoggerFactory.getLogger("info");
    private static final Logger LOGGER_WARN = LoggerFactory.getLogger("warn");
    private static final Logger LOGGER_ERROR = LoggerFactory.getLogger("error");

    public static void registration(Access access) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Client> clients = clientService.findAll();
        Client client = new Client();
        boolean notVacantEmail = false;
        boolean notVacantPhone = false;

        LOGGER_INFO.info("Entering ClientController.");
        LOGGER_INFO.info("Login is vacant, starting registration.");
        do {
            try {
                System.out.print("Enter first name: ");
                String firstName = reader.readLine();
                if (!firstName.isEmpty() && !firstName.isBlank()) client.setFirstName(firstName);
                else continue;
                System.out.print("Enter last name: ");
                String lastName = reader.readLine();
                if (!lastName.isEmpty() && !lastName.isBlank()) client.setLastName(lastName);
                else continue;
                System.out.print("Enter email: ");
                String email = reader.readLine();
                if (!email.isEmpty() && !email.isBlank()) client.setEmail(email);
                else continue;
                System.out.print("Enter phone number: ");
                String phone = reader.readLine();
                if (!phone.isEmpty() && !phone.isBlank()) client.setPhone(phone);
                else continue;
                if (clientService.sizeOf() > 1) {
                    LOGGER_INFO.info(clientService.sizeOf() + " clients. Checking if Email and Phone unique.");
                    for (Client i : clients) {
                        if (i.getEmail().equals(email)) notVacantEmail = true;
                        if (i.getPhone().equals(phone)) notVacantPhone = true;
                    }
                }
                if (notVacantEmail) {
                    LOGGER_WARN.warn("Email is already in use.");
                    System.out.println("Email is already in use."); continue;
                }
                if (notVacantPhone) {
                    LOGGER_WARN.warn("Phone number is already in use.");
                    System.out.println("Phone number is already in use."); continue;
                }
                LOGGER_INFO.info("Created client: " + client);
                client.setId(access.getId());
                System.out.println();
                System.out.println(client);
                client.setId(access.getId());
                clientService.update(client);
                break;
            } catch (IOException e) {
                LOGGER_ERROR.error("Creating client failed.");
                e.printStackTrace();
            }
        } while(true);

        MainMenuController.runMainMenu(access);
    }
}
