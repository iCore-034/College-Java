package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class Main {
    private static int counterAll = 0;
    // ------------------------------------- ADD OR DENY WORD ----------------------------------------------------------
    private static ArrayList<String> permutation = new ArrayList<>();

    public static void Check(String checkWord){
        if (permutation.size() == 0){
            permutation.add(checkWord);
            counterAll++;
            System.out.println(counterAll +". "+ checkWord);

            return;
        }
        else {
            for (int i = 0; i < permutation.size(); i++) {
                if (checkWord.equals(permutation.get(i))) {
                    return;
                }
            }
            permutation.add(checkWord);
            counterAll++;
            System.out.println(counterAll +". "+ checkWord);
        }
    }
    // -------------------------------------- OUTPUT -------------------------------------------------------------------
    public static void Output(HashMap Hmap){
        char[] word = new char[Hmap.size()];
        for (int i = 0; i < Hmap.size(); i++) {
            word[i] = (char) Hmap.get(keys.get(i));
        }
        String checkWord = Arrays.toString(word);
        Check(checkWord);
    }
    // -------------------------------------- PERMUTATION --------------------------------------------------------------

    private static int pos = 0;
    private static ArrayList<Integer> keys  = new ArrayList<>();
    public static ArrayList<Integer> AllKeys = new ArrayList<>();
    public static void permMain(HashMap Hmap){
        for (int i = 0; i < Hmap.size(); i++) {
            if (!keys.contains(i)){
                keys.set(pos,i);
                if (pos < Hmap.size()){
                    pos++;
                }
                permMain(Hmap);
            }
        }
        if (keys.containsAll(AllKeys)){
            Output(Hmap);
        }try {
            keys.set(pos-1,null);
            pos--;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Yeah!");
        }
    }
    // -------------------------------------- MAIN ---------------------------------------------------------------------
    public static void main(String[] args){

        ArrayList<Character> cherry = new ArrayList<Character>();
        String someWord = "13511";
        for (int i = 0; i < someWord.length(); i++) {
            cherry.add(someWord.charAt(i));
        }
        HashMap posHash = new HashMap<Integer,Character>();
        for (int i = 0; i < cherry.size(); i++) {
            AllKeys.add(i);
            posHash.put(i,cherry.get(i));
        }
        for (int i = 0; i < AllKeys.size(); i++) {
            keys.add(0);
            keys.set(keys.size()-1,null);
        }
        permMain(posHash);
    }
}