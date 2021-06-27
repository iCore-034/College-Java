package codewith;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        //------------------------------- Заполнение массива с несортированными элементами------------------------------
        ArrayList<Integer> unsorted = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int randomInt = rand.nextInt(10);
            unsorted.add(randomInt);
        }
        //------------------------------- Создание структуры для сортировки --------------------------------------------
        HashMap<Integer,Integer> realize = new HashMap<Integer,Integer>();
        for (int i = 0; i < unsorted.size(); i++) {
            realize.put(i,0);
        }
        //------------------------------- Заполнение HashMap -----------------------------------------------------------
        for (int i = 0; i < unsorted.size(); i++) {
            int val = realize.get(i);
            realize.put(unsorted.get(i),val+1);
        }
        //------------------------------- Консольный вывод -------------------------------------------------------------
        System.out.println(realize);
        for (int i = 0; i < realize.size(); i++) {
            for (int j = 0; j < realize.get(i); j++) {
                if (realize.get(i) != 0) {
                    System.out.print(i);
                }
            }
        }
    }
}