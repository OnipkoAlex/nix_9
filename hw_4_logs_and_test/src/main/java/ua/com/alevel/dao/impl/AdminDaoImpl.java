package ua.com.alevel.dao.impl;

import ua.com.alevel.dao.AdminDao;
import ua.com.alevel.db.impl.AdminDBImpl;
import ua.com.alevel.entity.Admin;

public class AdminDaoImpl implements AdminDao {

    @Override
    public void create(Admin admin) {
        AdminDBImpl.getInstance().create(admin);
    }

    @Override
    public void update(Admin admin) {
        AdminDBImpl.getInstance().update(admin);

    }

    @Override
    public Admin getAdmin() {
        return AdminDBImpl.getInstance().getAdmin();
    }
}
