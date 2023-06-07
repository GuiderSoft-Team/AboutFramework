package data.textfile;

import utils.Utils;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class TextFile {

    private String filePath;
    private boolean isFileExist = false;
    private boolean overwrite = false;

    private FileWriter fileWriter;
    private FileReader fileReader;

    public static TextFile create(String fileName){
        return new TextFile(fileName);
    }

    public static TextFile create(String fileName, boolean overwrite){
        return new TextFile(fileName, overwrite);
    }


    private TextFile(String filePath, boolean overwrite) {
        this.filePath = filePath;
        this.overwrite = overwrite;
        create();
    }

    private TextFile(String filePath) {
        this(filePath, false);
    }

    private void create() {
        Utils.createDirectory(filePath);
        File file = new File(filePath);
        if (file.exists() && !overwrite) {
            try {
                fileReader = new FileReader(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
            isFileExist = true;
        } else {
            try {
                fileWriter = new FileWriter(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public TextFile write(String... args) {
        try {
            for (String arg : args) {
                fileWriter.write(arg + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public TextFile write(List<String> list) {
        try {
            for (String val : list) {
                fileWriter.write(val + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }




    public void close(){
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
