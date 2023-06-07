package data.xml;

import java.util.List;

public class Application {
    private String name;
    private String url;
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", users=" + users +
                '}';
    }
}

