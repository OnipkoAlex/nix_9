package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.ClientDao;
import ua.com.alevel.db.impl.ClientDBImpl;
import ua.com.alevel.entity.Client;

import java.util.List;

public class ClientDaoImpl implements ClientDao {

    @Override
    public void create(Client client) {
        ClientDBImpl.getInstance().create(client);
    }

    @Override
    public void update(Client client) {
        ClientDBImpl.getInstance().update(client);
    }

    @Override
    public void delete(String id) {
        ClientDBImpl.getInstance().delete(id);
    }

    @Override
    public Client findById(String id) {
        return ClientDBImpl.getInstance().findById(id);
    }

    @Override
    public List<Client> findAll() {
        return ClientDBImpl.getInstance().findAll();
    }

    @Override
    public int sizeOf() {
        return ClientDBImpl.getInstance().sizeOf();
    }
}
