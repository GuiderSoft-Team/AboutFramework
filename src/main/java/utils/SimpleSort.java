package utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class SimpleSort {

    public static void main(String[] args) {
        int arraySize = 10;
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = new Random().nextInt(1, 20);
        }
        System.out.println(Arrays.toString(arr));
        boolean cont;
        LocalTime timeStart = LocalTime.now();
        do{
            cont = false;
            for (int i = 0; i < arr.length-1; i++) {
                if (arr[i]>arr[i+1]){
                    cont = true;
                    int a = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = a;
                }
            }
        }while (cont);
        LocalTime timeEnd = LocalTime.now();
        System.out.println(timeStart);
        System.out.println(timeEnd);
        System.out.println(Arrays.toString(arr));

        xx();
    }

    public static void xx(){
        for (int i = 0; i < 10; i++) {
            String name = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            System.out.println("T" + name);
        }
    }

}
