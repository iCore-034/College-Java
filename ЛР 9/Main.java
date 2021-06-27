package com.company;
import org.w3c.dom.ls.LSOutput;

import java.util.*;

/*
 Дан двумерный массив ("сетка") символов и слово. Найдите все вхождения данного слова в сетке.
 Слово может быть найдено во всех 8 направлениях(вверх, вниз, вправо, влево и по диагоналям) в любой точке.
 Говорят, слово "лежит в направлении", если все символы совпадают в этом направлении (не в зигзагообразной форме).
*/

class Main{
    private static int wordLength;
    private static int rightLength = 0;// --------------- Переменная для проверки нахождения слова
                                       //                 если она = переменной wordLength, то слово считается найденым.
    private static int counterColumn = 0;
    //---------------------------------------- ФОРМИРОВАНИЕ СЕТКИ ------------------------------------------------------
    public static void setGrid(ArrayList<ArrayList<Character>> grid, int size){
        Random rand = new Random();
        ArrayList<Character> ihatejava = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ArrayList<Character> toGrid = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                char ch = (char) ((char) rand.nextInt(25)+97);
                toGrid.add(ch);
            }
            ihatejava = toGrid;
            counterColumn++;
            System.out.print(counterColumn);
            System.out.println(ihatejava);
            grid.add(ihatejava);
        }
    }
    private static int ThereIsNoSuchAWord = 0;
    // --------------------------------------- ПОИСК ПЕРВОГО ЭЛЕМЕНТА --------------------------------------------------
    public static void findFirst(ArrayList<ArrayList<Character>> grid, char[] theWord, int size){

        for (int j = 0; j < size; j++) {
            for (int k = 0; k < size; k++) {
                if (theWord[rightLength] == grid.get(j).get(k)){
                    rightLength++;
                    findWay(grid,theWord,j, k);
                    if (rightLength == wordLength) {
                        ThereIsNoSuchAWord++;
                        System.out.println("The word is found\nFirst letter is on " + (j+1) + " column and " + (k+1) + " row.");
                    }
                    rightLength = 0;
                }
            }
        }
    }
    // --------------------------------------- ПОИСК ПУТИ ПРОВЕРКИ И ПОИСК ПЕРВОЙ БУКВЫ --------------------------------
    private static boolean retake = false;
    public static void findWay(ArrayList<ArrayList<Character>> grid, char[] theWord, int posj, int posk){
        int [][]aroundPositions = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}} ;

            for (int i = 0; i < aroundPositions.length; i++) {
                if (rightLength != wordLength) {
                    try {
                        if (theWord[rightLength] == grid.get(posj + aroundPositions[i][0]).get(posk + aroundPositions[i][1])) {
                                rightLength++;
                                findNextLetter(grid,theWord,aroundPositions[i],posj+aroundPositions[i][0],posk +aroundPositions[i][1]);
                                if (retake){
                                    return;
                                }
                            }
                        } catch (IndexOutOfBoundsException ignored) {
                    }
                }else{
                    return;
                }
            }
    }
    //---------------------------------------- ПРОВЕРКА ОСТАВШИХСЯ БУКВ ------------------------------------------------
    public static void findNextLetter(ArrayList<ArrayList<Character>> grid, char[] theWord, int[]plusPos, int pos1, int pos2){
        try {
            if (rightLength != wordLength) {
                if (theWord[rightLength] == grid.get(pos1 + plusPos[0]).get(pos2 + plusPos[1])) {
                    rightLength++;
                    findNextLetter(grid, theWord, plusPos, pos1 + plusPos[0], pos2 + plusPos[1]);
                }else{
                    retake = true;
                }
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored){}
    }
    //---------------------------------------- MAIN - ЗАДАЕМ СЛОВО -----------------------------------------------------
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Input a word: ");
        String word; // <---------------------------- УСТАНАВЛИВАЕМОЕ СЛОВО
        word = in.next();
        wordLength = word.length();
        char[] toChWord = word.toCharArray();

        System.out.print("Set matrix size: ");
        int size = in.nextInt();

        ArrayList<ArrayList<Character>> grid = new ArrayList<>();
        setGrid(grid, size);
        //testGrid(grid, size);
        findFirst(grid,toChWord,size);
        if (ThereIsNoSuchAWord == 0){
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("The table has no suck a word");
            System.out.println("-------------------------------------------------------------------------------------");
        }
        System.out.print(" ");
    }
}