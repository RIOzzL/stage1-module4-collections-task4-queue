package com.epam.collections.queue;

import java.util.*;

public class ArrayDequeCreator extends PriorityQueue<String> {
    public ArrayDeque<Integer> createArrayDeque(Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        ArrayDeque<Integer> firstQueue1 = new ArrayDeque<>(firstQueue);
        ArrayDeque<Integer> secondQueue2 = new ArrayDeque<>(secondQueue);
        addTwoCardsOfPlayers(arrayDeque, firstQueue1, secondQueue2);
        boolean turnOfFirstPlayer = true;
        while (firstQueue1.size() != 0 || secondQueue2.size() != 0) {
            if (turnOfFirstPlayer) {
                takeFirstCardAndGiveTwoCardsOfYours(arrayDeque, firstQueue1);
                turnOfFirstPlayer = false;
            } else {
                takeFirstCardAndGiveTwoCardsOfYours(arrayDeque, secondQueue2);
                turnOfFirstPlayer = true;
            }
        }
        return arrayDeque;
    }

    private void takeFirstCardAndGiveTwoCardsOfYours(ArrayDeque<Integer> arrayDeque, ArrayDeque<Integer> cardsOfPlayer) {
        cardsOfPlayer.addLast(arrayDeque.pollLast());
        if (cardsOfPlayer.size() != 0) {
            arrayDeque.addLast(cardsOfPlayer.poll());
        }
        if (cardsOfPlayer.size() != 0) {
            arrayDeque.addLast(cardsOfPlayer.poll());
        }
    }

    private void addTwoCardsOfPlayers(ArrayDeque<Integer> arrayDeque, Queue<Integer> firstQueue, Queue<Integer> secondQueue) {
        if (firstQueue.size() != 0) {
            arrayDeque.add(firstQueue.poll());
        }
        if (firstQueue.size() != 0) {
            arrayDeque.add(firstQueue.poll());
        }
        if (secondQueue.size() != 0) {
            arrayDeque.add(secondQueue.poll());
        }
        if (secondQueue.size() != 0) {
            arrayDeque.add(secondQueue.poll());
        }
    }
}
