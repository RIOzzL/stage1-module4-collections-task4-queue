package com.epam.collections.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= numberOfDishes; i++) {
            queue.add(i);
        }
        LinkedList<Integer> list = new LinkedList<>(queue);
        LinkedList<Integer> tempList = new LinkedList<>();
        LinkedList<Integer> resultList = new LinkedList<>();
        int count = 1;
        while (resultList.size() != numberOfDishes) {
            if (list.size() != 0) {
                if (count % everyDishNumberToEat == 0) {
                    resultList.add(list.poll());
                    count++;
                } else {
                    tempList.add(list.poll());
                    count++;
                }
            } else {
                list.addAll(tempList);
                tempList.clear();
            }
        }
        System.out.println(resultList);
        return resultList;
    }
}
