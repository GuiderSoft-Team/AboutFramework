package data.xml;

import com.fasterxml.jackson.xml.XmlMapper;
import org.testng.annotations.Test;

import java.io.File;

public class MainApplication {

    public static void main(String[] args) {
        Application pojo = null;
        File xmlFile;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            xmlFile = new File("src/main/java/data/xml/Application.xml");
            pojo = xmlMapper.readValue(xmlFile, Application.class);
            System.out.println(pojo);
        } catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println(pojo.getUsers().get(0).getPassword());
    }



}
