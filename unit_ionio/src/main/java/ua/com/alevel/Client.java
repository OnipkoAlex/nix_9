package ua.com.alevel;

import java.util.concurrent.Callable;

public class Client implements Callable {

    private String id;
    private String name;
    private int phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return  "id ='" + id + '\'' +
                ", name ='" + name + '\'' +
                ", phone =" + phone;
    }

    @Override
    public Object call() throws Exception {
        return new Client();
    }
}
