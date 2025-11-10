package application;

import collection.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int num = 5;
        System.out.println(5 == num);
        System.out.println(4 == num);

        Integer number = 5;
        System.out.println(number.equals(5));
        System.out.println(number.equals(4));
    }
}