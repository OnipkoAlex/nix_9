package ua.com.alevel;

import java.util.UUID;

public class IoNioMain {

    public static void main(String[] args) {
        ClientDB clientDB = new ClientDB();
        Client client = new Client();
/*        for (int i = 0; i < 10; i++) {
            client.setId(UUID.randomUUID().toString());
            client.setName("Name");
            client.setPhone(123);
            clientDB.create(client);
        }*/
/*        client.setId("cd98d9d3-bcb1-475e-9120-02fca309c504");
        client.setName("Sam");
        client.setPhone(2222);
        clientDB.update(client);*/
        clientDB.delete("f25e26c1-05f5-462b-b5a6-9fb141cdd9ca");
        clientDB.findAll();
    }
}
