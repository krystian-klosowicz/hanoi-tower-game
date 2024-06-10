package org.example;


import java.util.*;


public class Main {


    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(6);
        hanoi.printHanoi();
        System.out.println("-----HANOI-----");
        Scanner scanner = new Scanner(System.in);
        String choose;
        do {
            System.out.println("1.A to B");
            System.out.println("2.A to C");
            System.out.println("3.B to A");
            System.out.println("4.B to C");
            System.out.println("5.C to A");
            System.out.println("6.C to B");
            System.out.println("7. Exit");
            System.out.println("Choosen: ");
            choose= scanner.next();

            switch(choose) {
                case "1":
                    hanoi.moveDisk("A", "B");
                    hanoi.printHanoi();
                    break;
                case "2":
                    hanoi.moveDisk("A", "C");
                    hanoi.printHanoi();
                    break;
                case "3":
                    hanoi.moveDisk("B", "A");
                    hanoi.printHanoi();
                    break;
                case "4":
                    hanoi.moveDisk("B", "C");
                    hanoi.printHanoi();
                    break;
                case "5":
                    hanoi.moveDisk("C", "A");
                    hanoi.printHanoi();
                    break;
                case "6":
                    hanoi.moveDisk("C", "B");
                    hanoi.printHanoi();
                    break;
            }
        }while(!choose.equals("7"));




    }


}