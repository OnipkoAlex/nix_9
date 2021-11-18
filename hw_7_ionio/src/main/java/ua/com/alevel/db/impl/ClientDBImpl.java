package ua.com.alevel.db.impl;

import ua.com.alevel.db.ClientDB;
import ua.com.alevel.entity.Client;
import ua.com.alevel.lib.FileToObject;
import ua.com.alevel.lib.ObjectToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClientDBImpl implements ClientDB {

    private static ClientDBImpl instance;
    private final Path path = Paths.get("Client.csv");

    private ClientDBImpl() {
    }

    public static ClientDBImpl getInstance() {
        if (instance == null) {
            instance = new ClientDBImpl();
        }
        return instance;
    }

    public void create(Client client) {
        List<String> strList = new ArrayList<>();
        strList.add(client.getId());
        strList.add(client.getFirstName());
        strList.add(client.getLastName());
        strList.add(client.getEmail());
        strList.add(client.getPhone());
        ObjectToFile.runObjectToFile(client, path);
    }

    public void update(Client client) {
        List<Client> clients = findAll();

        for (Client i : clients) {
            if (i.getId().equals(client.getId())) {
                i.setFirstName(client.getFirstName());
                i.setLastName(client.getLastName());
                i.setEmail(client.getEmail());
                i.setPhone(client.getPhone());
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        clients.stream().forEach(x -> ObjectToFile.runObjectToFile(x, path));
    }

    public void delete(String id) {
        List<Client> clientList = findAll();

        for (Client i : clientList) {
            if (i.getId().equals(id)) {
                clientList.remove(i);
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        clientList.stream().forEach(x -> ObjectToFile.runObjectToFile(x, path));

    }

    public Client findById(String id) {
        List<Client> clients = findAll();
        for (Client i : clients) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public List<Client> findAll() {
        List<Client> clientList = new ArrayList<>();
        List<String[]> stringList = FileToObject.runFileToObject(path);

        if (stringList.size() == 0) return null;

        for (String[] string : stringList) {
            Client client = new Client();
            client.setId(string[4]);
            client.setFirstName(string[0]);
            client.setLastName(string[1]);
            client.setEmail(string[2]);
            client.setPhone(string[3]);
            clientList.add(client);
        }

        return clientList;
    }

    @Override
    public int sizeOf() {
        return FileToObject.runFileToObject(path).size();
    }
}
