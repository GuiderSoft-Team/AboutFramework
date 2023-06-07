package data.property;

import java.util.Properties;

public class SessionPropertyFile {

    public static ThreadLocal<Properties> props = new ThreadLocal<>();

    public static void main(String[] args) {

        SessionPropertyFile main = new SessionPropertyFile();
        main.createPropertiesFile();
        main.putVals("key1", "val1");
        main.putVals("key2", "val2");
        main.putVals("key3", "val3");
        System.out.println(main.getValue("key2"));

    }

    public void createPropertiesFile(){
        props.set(new Properties());
    }

    public void putVals(String key, String value){
        props.get().put(key, value);
    }

    public String getValue(String key){
        return props.get().getProperty(key);
    }

}
