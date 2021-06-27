package codewith;
import java.util.Random;
import java.util.ArrayList;

public class juice {
    public static void goo() {
        ArrayList<Integer> semimain_arr = new ArrayList<>();// --------------------------------- Не сортированный массив
        exist_elements(semimain_arr);//--------------------------------------------- Заполнение несортированного массива
        System.out.println("Doesn't sorted:");
        output(semimain_arr);//--------------------------------------------------------------------------- Вывод массива
        System.out.println("Sorted:");
        output(MergeSort(semimain_arr));//---------------------------------------------------------- Вывод с сортировкой
    }

    //----------------------------------------------- ЗАПОЛЕНЕНИЕ------------------------------------------------------
    public static void  exist_elements(ArrayList<Integer> semimain_arr){
        Random rand = new Random();
        for (int i = 0; i < 15; i++) {
            int ran = rand.nextInt(100);
            semimain_arr.add(ran);
        }
    }
    //----------------------------------------------- ВЫВОД ------------------------------------------------------------
    public  static void output(ArrayList<Integer> semimain_arr){
        for (Integer integer : semimain_arr) {
            System.out.print((int) integer + " ");
        }
        System.out.print("\n");
    }
    //################################################ СОРТИРОВКА ######################################################
    //----------------------------------------------- ДРОБЛЕНИЕ МАССИВА-------------------------------------------------
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> semimain_arr){

        ArrayList<Integer> buffer_1 = new ArrayList<>();//------------------------------ Первая половина несорт. массива
        ArrayList<Integer> buffer_2 = new ArrayList<>();//------------------------------------ Очевидно, вторая половина
        if (semimain_arr.size() > 2) {

            int begin_pos = 0;
            int end_pos = semimain_arr.size() / 2;
            buffer_1.addAll(MergeSort(Half_Arr(semimain_arr, begin_pos,end_pos)));

            begin_pos = end_pos;
            end_pos = semimain_arr.size();
            buffer_2.addAll(MergeSort(Half_Arr(semimain_arr, begin_pos, end_pos)));
        }
        else{

            return sort_two_one_element(semimain_arr);//-------------------------------- сортировка массива 1-2 элемента
        }
        return Combine(buffer_1, buffer_2);
    }
    //----------------------------------------------- СЛИЯНИЕ ----------------------------------------------------------
    public static ArrayList<Integer> Combine(ArrayList<Integer> one, ArrayList<Integer> two){
        ArrayList<Integer> buffer = new ArrayList<Integer>();
        int po = 0;
        int pt = 0;
        while (po < one.size() && pt < two.size()) {
            if (one.get(po) <= two.get(pt)){
                buffer.add(one.get(po));
                po++;
            }
            else{
                buffer.add(two.get(pt));
                pt++;
            }
        }
        while (po < one.size()){
            buffer.add(one.get(po));
            po++;
        }
        while (pt < two.size()){
            buffer.add(two.get(pt));
            pt++;
        }
        return buffer;
    }
    //---------------------------------------- ОСНОВНОЙ ЭЛЕМЕНТ ДРОБЛЕНИЯ МАССИВА --------------------------------------
    public static ArrayList<Integer> Half_Arr(ArrayList<Integer> Full, int begin, int end){
        ArrayList<Integer> Half = new ArrayList<>();
        for (;begin  < end; begin++) {
            Half.add(Full.get(begin));
        }
        return Half;
    }
    //--------------------------------------- СОРТИРОВКА МАССИВА ИЗ 1 ИЛИ 2 ЭЛЕМЕНТОВ ----------------------------------
    public static ArrayList<Integer> sort_two_one_element(ArrayList<Integer> arr_sorting){
        if (arr_sorting.size() == 2) {
            if (arr_sorting.get(0) > arr_sorting.get(1)) {
                int release = 0;
                release = arr_sorting.get(0);
                arr_sorting.set(0, arr_sorting.get(1));
                arr_sorting.set(1, release);
            }
        }
        return arr_sorting;
    }
}