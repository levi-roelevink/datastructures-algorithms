package application;

import collection.ArrayList;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
//        ArrayList<Integer> arrayList = new ArrayList<>();
//
//        arrayList.addLast(5);
//        arrayList.addLast(10);
//        arrayList.addLast(2);
//        arrayList.addLast(-12);
//        arrayList.addLast(0);
//        arrayList.addLast(5);
//        arrayList.addLast(420);
//        arrayList.addLast(6);
//        arrayList.addLast(69);

        ArrayList<Boolean> arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            if (i > 18) {
                arrayList.addLast(true);
            } else {
                arrayList.addLast(false);
            }
        }

        System.out.println(arrayList);
        System.out.println();
        System.out.println(twoCrystalBalls(arrayList));
    }

    public static int twoCrystalBalls(ArrayList<Boolean> arrayList) {
        assert (arrayList.isSorted(Boolean::compareTo)) : "List is not sorted, this is a requirement for the two crystal balls algorithm.";

        int jump = (int) Math.sqrt(arrayList.size());

        int i = jump;
        for (; i < arrayList.size(); i += jump) {
            if (arrayList.get(i)) {
                break;
            }
        }

        i-= jump; // Go back one jump

        for (int j = 0; j <= jump && i < arrayList.size(); j++, i++) {
            if (arrayList.get(i)) {
                return i;
            }
        }

        return -1;
    }
}