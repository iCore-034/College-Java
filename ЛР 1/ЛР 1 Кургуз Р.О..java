package com.company;
import java.lang.String;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void recursion(ArrayList arr1, byte el,byte counter_right) {
        try {
            byte replace_element;
            if (counter_right == 0) {                                                     // Пересановка (Начало,первый больше следующего)
                if ((byte) arr1.get(counter_right) > (byte) arr1.get(counter_right + 1)) {
                    replace_element = (byte) arr1.get(counter_right);
                    arr1.set(0, arr1.get(counter_right + 1));
                    arr1.set(1, replace_element);
                }
                counter_right++;
            }
            else {                                                                        // Перестановка (Элемент меньше предыдущего)
                if ((byte) arr1.get(counter_right) < (byte) arr1.get(counter_right - 1)) {
                    replace_element = (byte) arr1.get(counter_right);
                    arr1.set(counter_right, arr1.get(counter_right - 1));
                    arr1.set(counter_right - 1, replace_element);
                    counter_right--;
                }
                else{
                counter_right++;
                }
            }
            recursion(arr1, el, counter_right);
        }
        catch(Exception ex){
            return;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        byte count_el = in.nextByte();
        ArrayList arr = new ArrayList();                         // Создание основноего сортируемого массива
        for (byte i = 0; i < count_el; i ++){
            arr.add((byte)(Math.random()*10));
        }
        System.out.println( arr);
        recursion(arr,count_el,(byte)0);
        System.out.println(arr);
    }
}