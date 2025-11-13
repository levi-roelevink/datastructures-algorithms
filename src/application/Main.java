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
        int pos = 0;

        while (pos < arrayList.size()) {
            if (arrayList.get(pos) == true) {
                // Walk back and go linear
                for (int i = pos - jump; i <= pos; i++) {
                    if (arrayList.get(i) == true) {
                        return i;
                    }
                }
            } else {
                pos += jump;
            }
        }

        if (pos >= arrayList.size()) {
            for (int i = pos - jump; i < arrayList.size(); i++) {
                if (arrayList.get(i) == true) {
                    return i;
                }
            }

        }
        return -1;
    }
}