package system;

public class Test1 {

    public static void main(String[] args) {
        //System.getProperties().forEach((k,v) -> System.out.println(k + " : " + v));
        System.out.println("usr.dir: " + System.getProperty("user.dir"));
        System.setProperty("my.name", "ahmet");
        System.out.println(System.getProperty("my.name"));
    }
}
