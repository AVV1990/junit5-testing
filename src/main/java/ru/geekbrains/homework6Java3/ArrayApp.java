package ru.geekbrains.homework6Java3;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayApp {


    public static boolean ifArrayContains4and1 (int [] arr) {
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                test1 = true;
            }
            if (arr[i] == 1) {
                test2 = true;
            }
            if (arr [i] != 1 && arr [i] != 4) {
                test3 = false;
            }
        }

        return test1 && test2 && test3 ;

    }


    public static int [] changeArrIfArrContains4 (int [] arr) {
        int[] myArray = null;

        for (int i = arr.length - 1; i >= 0; i--) {
            int j = i;
            if (arr[i] == 4) {
                myArray = Arrays.copyOfRange(arr, j + 1, arr.length);
                System.out.println(Arrays.toString(myArray));
                break;
            }
        }


        if (myArray == null) {
            throw new RuntimeException();
        }

        return myArray;

    }

}
