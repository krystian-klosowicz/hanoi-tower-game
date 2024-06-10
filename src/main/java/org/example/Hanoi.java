package org.example;

import java.util.*;

public class Hanoi {
    private final Queue<Integer> towerA;
    private final Queue<Integer> towerB;
    private final Queue<Integer> towerC;
    private final int size;


    public Hanoi(int size) {
        this.size = size;
        towerA = new LinkedList<>();
        towerB = new LinkedList<>();
        towerC = new LinkedList<>();
        for (int i = 1; i <= size; i++) {
            towerA.add(i);
        }
    }

    public void printHanoi() {
        System.out.println("|A|\t|B|\t|C|");
        Iterator<Integer> itrA = this.towerA.iterator();
        Iterator<Integer> itrB = this.towerB.iterator();
        Iterator<Integer> itrC = this.towerC.iterator();
        int counter = 0;
        while (counter < this.size) {
            counter++;
            if (itrA.hasNext()) {
                System.out.print("|" + itrA.next() + "|\t");
            } else {
                System.out.print("| |\t");
            }
            if (itrB.hasNext()) {
                System.out.print("|" + itrB.next() + "|\t");
            } else {
                System.out.print("| |\t");
            }
            if (itrC.hasNext()) {
                System.out.print("|" + itrC.next() + "|\t");
            } else {
                System.out.print("| |\t");
            }
            System.out.println();
        }
    }

    public int getMaxTowerSize() {
        int size = 0;
        if (towerA.size() > size) size = towerA.size();
        if (towerB.size() > size) size = towerB.size();
        if (towerC.size() > size) size = towerC.size();
        return size;
    }

//    private int[][] hanoiTable(){
//        int[][] table = new int[size][3];
//
//
//
//        return table;
//    }

    public String getHanoiText() {

        Iterator<Integer> itrA = this.towerA.iterator();
        Iterator<Integer> itrB = this.towerB.iterator();
        Iterator<Integer> itrC = this.towerC.iterator();
        StringBuilder sb = new StringBuilder();
        sb.append("|A|\t|B|\t|C|\n");
        int counter = 0;
        while (counter < size) {
            if (itrA.hasNext()) {
                sb.append("|").append(itrA.next()).append("|\t");
            } else {
                sb.append("|  |\t");
            }
            if (itrB.hasNext()) {
                sb.append("|").append(itrB.next()).append("|\t");
            } else {
                sb.append("|  |\t");
            }
            if (itrC.hasNext()) {
                sb.append("|").append(itrC.next()).append("|\t");
            } else {
                sb.append("|  |\t");
            }


            sb.append("\n");
            counter++;
        }
        return sb.toString();
    }

    public void moveDisk(String from, String to) {
        List<String> towersList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        if (towersList.contains(from) && towersList.contains(to)) {
            Queue<Integer> towerWeTakeFrom = assignTower(from);
            Queue<Integer> towerWeGiveTo = assignTower(to);
            int takenDisc;
            int receiverDisc;
            //sprawdzamy czy wieza z ktorej bierzemy nie jest pusta
            if (!towerWeTakeFrom.isEmpty()) {
                //pobieramy dysk który bedziemy chcieli zabrac z tej wiezy
                takenDisc = towerWeTakeFrom.peek();
                //System.out.println("Zabrany dysk:" + takenDisc);
                if (!towerWeGiveTo.isEmpty()) {
                    receiverDisc = towerWeGiveTo.peek();
                    //System.out.println("Zrzucamy górny dysk:" + to
                }else {
                    receiverDisc = 64;
                }
                //System.out.println("Dysk na drugiej wieży:" + receiverDisc);
                if (takenDisc < receiverDisc) {
                    towerWeTakeFrom.poll();
                    addElementAtBeginning(towerWeGiveTo, takenDisc);
                }

            } else {
                System.out.println("Tower is empty!");
            }


        }
    }

    private Queue<Integer> assignTower(String tower) {
        Queue<Integer> assignedtower = new LinkedList<>();
        switch (tower) {
            case "A" -> assignedtower = this.towerA;
            case "B" -> assignedtower = this.towerB;
            case "C" -> assignedtower = this.towerC;
            default -> {
            }
        }
        return assignedtower;
    }

    private static void addElementAtBeginning(Queue<Integer> queue, int value) {
        LinkedList<Integer> tempList = new LinkedList<>();
        tempList.add(value);

        while (!queue.isEmpty()) {
            tempList.add(queue.poll());
        }

        queue.addAll(tempList);
    }


}
