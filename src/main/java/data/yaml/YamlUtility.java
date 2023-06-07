package data.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import data.yaml.pojo.YamlFile;

import java.io.File;
import java.io.IOException;

public class YamlUtility {

    public static YamlFile readYaml(String path){
        YamlFile yamlFile;
        File file = new File(path);
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            yamlFile = objectMapper.readValue(file, YamlFile.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return yamlFile;
    }


    public static void writeYaml(String path, YamlFile yamlFile){

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        try {
            objectMapper.writeValue(new File(path), yamlFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
