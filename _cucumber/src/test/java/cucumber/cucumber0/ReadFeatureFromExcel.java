package cucumber.cucumber0;


import data.excel.ExcelFile;
import data.textfile.TextFile;

import java.util.List;

import static io.cucumber.core.cli.Main.run;

public class ReadFeatureFromExcel {

    static String featureFile = "testOutput/featureFromExcel.feature";
    static String excelFile = "testOutput/excel.xlsx";

    public static void main(String[] args) {

        getFeatureFromExcel();

        String [] argv = new String[]{ "-g","", featureFile};
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        byte exitstatus = run(argv, contextClassLoader);
        System.out.println(exitstatus);

    }

    public static void getFeatureFromExcel(){
        ExcelFile.create("testOutput/excel.xlsx")
                .setHeader("Feature", "Scenario", "Steps")
                .writeData("F1", "S1", "Given user on homepage")
                .writeData("", "", "When  user search for \"mac\"")
                .writeData("", "", "Then  listed product count should be 4")
                .close();

        List<String> list = ExcelFile.read(excelFile).getColumn("Steps", 1);

        TextFile.create(featureFile, true)
                .write("Feature: Future name")
                .write("Scenario: Scenario name")
                .write(list)
                .close();

    }

}
