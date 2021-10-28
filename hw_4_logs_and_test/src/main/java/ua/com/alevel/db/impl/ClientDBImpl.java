package ua.com.alevel.db.impl;

import ua.com.alevel.db.ClientDB;
import ua.com.alevel.entity.Client;

public final class ClientDBImpl implements ClientDB {

    private final Client[] clients;
    private static ClientDBImpl instance;
    private int nextClientId = 0;

    private ClientDBImpl() {
        clients = new Client[100];
    }

    public static ClientDBImpl getInstance() {
        if (instance == null) {
            instance = new ClientDBImpl();
        }
        return instance;
    }

    public void create(Client client) {
        client.setId(nextClientId);
        clients[nextClientId] = client;
        nextClientId++;
    }

    public void update(Client client) {
        Client current = findById(client.getId());
        current.setFirstName(client.getFirstName());
        current.setLastName(client.getLastName());
        current.setEmail(client.getEmail());
        current.setPhone(client.getPhone());
    }

    public void delete(Integer id) {
        for (int i = id; i < nextClientId - 1; i++) {
            clients[i] = clients[i + 1];
            clients[i].setId(clients[i].getId() - 1);
        }
        nextClientId--;
    }

    public Client findById(Integer id) {
        return clients[id];
    }

    public int sizeOf() {
        return nextClientId;
    }

    public Client[] findAll() {
        return clients;
    }
}
