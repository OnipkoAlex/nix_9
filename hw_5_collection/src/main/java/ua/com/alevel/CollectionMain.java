package ua.com.alevel;

import ua.com.alevel.lib.SetOld;

public class CollectionMain {

    public static void main(String[] args) {
        Double[] numbers = {1.0, 2.0, 3.0, 4.0, 5.0};
        Number[] numbers2 = {1, 2, 3, 4, 5};
        SetOld<Number> arr = new SetOld<>(numbers2);
        //MathSet arr2 = new MathSet(numbers2);
        arr.add(2);
        arr.print();
    }
}
