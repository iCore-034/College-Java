package com.company;
import java.lang.String;
import java.lang.invoke.VarHandle;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
// ______________________________________________ Обработка эелементов массива на связь внутри при возникновении таковой
public class Main {
    public static void Connecting_Inside( ArrayList<Double_Array> All_Web_Arrs, int zero_plus){
        for (byte i = 0; i < All_Web_Arrs.size()-1; i ++){
            for (byte j = 0; j < All_Web_Arrs.get(i).Web.size(); j ++){
                if (All_Web_Arrs.get(i+1).Web.contains(All_Web_Arrs.get(i).Web.get(j))){
                    All_Web_Arrs.get(i).Web.remove(j);
                    All_Web_Arrs.get(i).Web.addAll(All_Web_Arrs.get(i+1).Web);
                    All_Web_Arrs.remove(i+1);
                    return;
                }
            }
        }
    }
    //______________________________________________ Обработка новой пары: добавление, связывание или игнорирование

    public static void Basic_Distribution( ArrayList<Double_Array> All_Web_Arrs, Double_Array To_Web){

        //_______________________________ Переменная, определяющая отсутствие или наличие связи новой пары с элементами массива
        byte exist = 0;

            for (int i = 0; i < All_Web_Arrs.size(); i++) {

                if (!All_Web_Arrs.get(i).Web.contains(To_Web.Web.get(0)) &&
                        !All_Web_Arrs.get(i).Web.contains(To_Web.Web.get(1))) {
                    exist++;
                } else if (All_Web_Arrs.get(i).Web.contains(To_Web.Web.get(0)) ^
                        All_Web_Arrs.get(i).Web.contains(To_Web.Web.get(1))) {

                    if (All_Web_Arrs.get(i).Web.contains(To_Web.Web.get(0))) {
                        All_Web_Arrs.get(i).Web.add(To_Web.Web.get(1));
                    } else {
                        All_Web_Arrs.get(i).Web.add(To_Web.Web.get(0));
                    }
                    System.out.print(" -------- Connected -------- \n");
                    Connecting_Inside(All_Web_Arrs, 0);
                }
            }
            if (exist == All_Web_Arrs.size()) {
                All_Web_Arrs.add(To_Web);
                System.out.print(" -------- Added -------- \n");
            }
        Output_Current_Connections(All_Web_Arrs);
    }
    //__________________________________________________________________________________________ Вывод результата связей

    public static void Output_Current_Connections(ArrayList<Double_Array>All_Web_Arrs){
        System.out.println("###########  Current connection  ###########");
        for (int k = 0; k < All_Web_Arrs.size(); k++) {
            System.out.print("[");
            for (int s = 0; s < All_Web_Arrs.get(k).Web.size(); s ++){
                System.out.print(All_Web_Arrs.get(k).Web.get((int)s));
                System.out.print(" ");
            }
            System.out.print("]\n");
        }
        System.out.println("############################################");
    }
    // _________________________________________________________ Ввод пар с обработкой ошибочного ввода (напр: символов)
    public  static void Inputting_Pair(Double_Array To_Web){
        Scanner in = new Scanner(System.in);
        try {
            int first_el = in.nextInt();
            int second_el = in.nextInt();
            To_Web.Web.add(first_el);
            To_Web.Web.add(second_el);
        }
        catch (Exception e) {

            System.out.println("Try again: ");
            Inputting_Pair(To_Web);
        }
    }
    public static void main(String[] args) {

        //_______________________________________________________________________________________ Тут хранятся все связи

        ArrayList<Double_Array> All_Web_Arrs = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        while (true){

            System.out.print("Input pair: ");
            // ______________________________  Реализация добавления новых связей с последующей обработкой на совпадения.
            Double_Array To_Web = new Double_Array();
            Inputting_Pair(To_Web);

            if(To_Web.Web.get(0) == To_Web.Web.get(1)){
                System.out.println( "The same numbers are not allowed.");
            }
            else  if (All_Web_Arrs.isEmpty()){
                All_Web_Arrs.add(To_Web);
                System.out.print( "-------- Added -------- \n");
            }
            else {
                //____________________________________ Основная часть кода, обработка связей пары и уже существующих пар
                Basic_Distribution(All_Web_Arrs, To_Web);
            }
        }
    }
    static class Double_Array{
        ArrayList<Integer> Web = new ArrayList();
    }
}
