package data.excel;

public class Main {
    public static void main(String[] args) {
        ExcelFile.create("testOutput/excelAA.xlsx")
                .setHeader("A", "B", "Steps")
                .writeData("1", "2", "Given user on homepage")
                .writeData("1", "2", "When  user search for \"mac\"")
                .writeData("1", "2", "Then  listed product count should be 4")
                .close();

        /*
        List<String> list = ExcelFile.read("testOutput/excel.xlsx").getColumn("Steps", 1);

        TextFile.create("testOutput/feature1.feature", true)
                .write("Feature: Future name")
                .write("Scenario: Scenario name")
                .write(list)
                .close();

         */

    }
}
