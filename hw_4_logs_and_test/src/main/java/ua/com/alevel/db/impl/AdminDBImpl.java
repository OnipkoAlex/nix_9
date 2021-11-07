package ua.com.alevel.db.impl;

import ua.com.alevel.db.AdminDB;
import ua.com.alevel.entity.Admin;

public class AdminDBImpl implements AdminDB {

    private final Admin admin = new Admin();
    private static AdminDBImpl instance;

    public static AdminDBImpl getInstance() {
        if (instance == null) {
            instance = new AdminDBImpl();
        }
        return instance;
    }

    @Override
    public void create(Admin admin) {
        this.admin.setAdminLogin(admin.getAdminLogin());
        this.admin.setAdminPassword(admin.getAdminPassword());
    }

    @Override
    public void update(Admin admin) {
        this.admin.setAdminLogin(admin.getAdminLogin());
        this.admin.setAdminPassword(admin.getAdminPassword());
    }

    @Override
    public Admin getAdmin() {
        return admin;
    }
}
