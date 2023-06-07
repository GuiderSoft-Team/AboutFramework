package data.database;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> list =
                DBUtility.connect("jdbc:mysql://localhost:3306/sakila","root","")
                        .getRowAsMap("SELECT * FROM actor WHERE actor_id=1");
        System.out.println(list);

    }
}
