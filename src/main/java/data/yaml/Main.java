package data.yaml;

import data.yaml.pojo.Database;
import data.yaml.pojo.YamlFile;

public class Main {
    public static void main(String[] args) throws Exception {
        writeYml();
        readYml();
    }

    public static void readYml(){
        YamlFile config = YamlUtility.readYaml("src/main/resources/application.yaml");
        System.out.println(config.getDatabase().getDbname());
    }

    public static void writeYml(){
        YamlFile yamlFile = new YamlFile();
        Database database = new Database();
        yamlFile.setAuthor("Ahmet");
        yamlFile.setUrl("https://google.com");
        database.setDbname("deneme");
        database.setPort(3306);
        database.setDriver("mysql");
        database.setUsername("user");
        database.setPassword("pass");
        yamlFile.setDatabase(database);
        YamlUtility.writeYaml("src/main/resources/application.yaml", yamlFile);

    }
}
