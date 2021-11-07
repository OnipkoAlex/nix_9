package ua.com.alevel.service.impl;

import ua.com.alevel.db.impl.AdminDBImpl;
import ua.com.alevel.entity.Admin;
import ua.com.alevel.service.AdminService;

public class AdminServiceImpl implements AdminService {


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
