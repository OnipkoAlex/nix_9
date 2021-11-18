package ua.com.alevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClientDB {

    private static final Path path = Paths.get("Client.csv");

    public void create(Client client) {
        ObjectToFileUtil.runObjectToFile(client, path);
    }

    public void update(Client client) {
        List<Client> clients = findAll();
        Client exampleClient = new Client();

        for (Client i : clients) {
            if (i.getId().equals(client.getId())) {
                i.setPhone(client.getPhone());
                i.setName(client.getName());
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Client i : clients) {
            create(i);
        }
    }

    public void delete(String id) {
        List<Client> clients = findAll();

        for (Client i : clients) {
            if (i.getId().equals(id)) {
                clients.remove(i);
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        clients.stream().forEach(x -> create(x));
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
        List<String[]> stringList = FileToObjectUtil.runFileToObject(path);
        for (String[] line : stringList) {
            Client client = new Client();
            for (String str : line) {
                client.setId(line[0]);
                client.setName(line[1]);
                client.setPhone(Integer.parseInt(line[2]));
            }
            clientList.add(client);
        }
        clientList.stream().forEach(System.out::println);
        return clientList;
    }
}
