package ua.com.alevel.service;

import ua.com.alevel.entity.Client;

public class ClientGenerationUtil {

    public static Client generateClient(String id, String firstName, String lastName, String email, String phone) {
        Client client = new Client();
        client.setId(id);
        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhone(phone);
        return client;
    }
}
