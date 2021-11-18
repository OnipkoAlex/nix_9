package ua.com.alevel.db.impl;

import ua.com.alevel.db.AccessDB;
import ua.com.alevel.entity.Access;
import ua.com.alevel.entity.Client;
import ua.com.alevel.lib.FileToObject;
import ua.com.alevel.util.GenerateAccessIdUtil;
import ua.com.alevel.lib.ObjectToFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AccessDBImpl implements AccessDB {

    private static AccessDBImpl instance;
    private final Path path = Paths.get("Access.csv");

    private AccessDBImpl() {
    }

    public static AccessDBImpl getInstance() {
        if (instance == null) {
            instance = new AccessDBImpl();
        }
        return instance;
    }

    public void create(Access access) {
        Client client = new Client();

        if (findAll() == null) access.setId(GenerateAccessIdUtil.generate());
        else access.setId(GenerateAccessIdUtil.generate(findAll(), findAll().size()));
        ObjectToFile.runObjectToFile(access, path);
        client.setId(access.getId());
        client.setFirstName(null);
        client.setLastName(null);
        client.setEmail(null);
        client.setPhone(null);
        ClientDBImpl.getInstance().create(client);
    }

    public void update(Access access) {
        List<Access> accesses = findAll();

        for (Access i : accesses) {
            if (i.getId().equals(access.getId())) {
                i.setLogin(access.getLogin());
                i.setPassword(access.getPassword());
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        accesses.stream().forEach(x -> ObjectToFile.runObjectToFile(x, path));
    }

    public void delete(String id) {
        List<Access> accessList = findAll();

        for (Access i : accessList) {
            if (i.getId().equals(id)) {
                accessList.remove(i);
                break;
            }
        }

        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        accessList.stream().forEach(x -> ObjectToFile.runObjectToFile(x, path));

        ClientDBImpl.getInstance().delete(id);
    }

    public Access findById(String id) {
        List<Access> accesses = findAll();
        for (Access i : accesses) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }

    public List<Access> findAll() {
        List<Access> accessList = new ArrayList<>();
        List<String[]> stringList = FileToObject.runFileToObject(path);

        if (stringList.size() == 0) return null;

        for (String[] line : stringList) {
            Access access = new Access();
            access.setId(line[2]);
            access.setLogin(line[0]);
            access.setPassword(line[1]);
            accessList.add(access);
        }

        return accessList;
    }

    @Override
    public int sizeOf() {
        return FileToObject.runFileToObject(path).size();
    }
}
