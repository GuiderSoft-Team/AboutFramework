package readers.excel;

import readers.MyPojo;

public class Main {
    public static void main(String[] args) {

        ExcelReader er = new ExcelReader("src/main/java/readers/excel/Excel2.xlsx");
        System.out.println(er.getData());

    }

    public void cls(Class<? extends MyPojo> clazz){

    }

}

