package data.json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class JSONGenelOrnek {


    public static void main(String[] args) throws Exception {

        JSONObject jsonObjRead;
        String jsonFileRead = "src/main/resources/application.json";

        //jsonObject = new JSONObject();
        jsonObjRead = (JSONObject) new JSONParser().parse(new FileReader(jsonFileRead));

        // tek deger okuma
        System.out.println(jsonObjRead.get("adi"));




        JSONObject jsonObjWrite = new JSONObject();
        String jsonFileWrite = "src/main/resources/application1.json";
        jsonObjWrite.put("a", "a");

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(jsonFileWrite);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        pw.write(jsonObjWrite.toJSONString());
        pw.flush();
        pw.close();

    }
}
