package com.company;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
4. Реализовать структуру данных – очередь с приоритетами на языке программирования Java.
Реализовать эту структуру с функцией занесения в очередь элементов без приоритета.
*/
public class Program{
    public void main_of_class_Program(){
        Comparator<Integer> comparator = new StringLengthComparator();
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(10, comparator);
        Scanner in = new Scanner(System.in);

        int queue_input = 0;
        for (int i = 0; i < 3; i++) {
            queue_input = in.nextInt();
            queue.add(queue_input);
        }
        System.out.println(queue);

    }

    class StringLengthComparator implements Comparator<Integer>
    {
        @Override
        public int compare(Integer x, Integer y)
        {
            return 0;
        }
    }
}
