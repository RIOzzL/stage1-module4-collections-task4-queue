package com.epam.collections.queue;

import java.util.*;

public class PriorityQueueCreator {
    public PriorityQueue<String> createPriorityQueue(List<String> firstList, List<String> secondList) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(0, o1.compareTo(o2));
            }
        });
        ArrayList<String> firstList1 = new ArrayList<>(firstList);
        firstList1.addAll(new ArrayList<>(secondList));
        priorityQueue.addAll(firstList1);
        return priorityQueue;
    }
}
