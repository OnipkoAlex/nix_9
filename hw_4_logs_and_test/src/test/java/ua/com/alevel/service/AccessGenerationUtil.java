package ua.com.alevel.service;

import ua.com.alevel.entity.Access;

public class AccessGenerationUtil {

    public static Access generateAccess(String login, String password) {
        Access access = new Access();

        access.setLogin(login);
        access.setPassword(password);
        return access;
    }
}
