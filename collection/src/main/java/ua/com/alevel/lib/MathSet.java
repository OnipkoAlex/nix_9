package ua.com.alevel.lib;

import java.text.NumberFormat;

public class MathSet<Type> {

    private Type[] array;
    private int size = 5;
    private int capacity = 0;
    private int iterator = 0;
    private NumberFormat nf = NumberFormat.getInstance();

    public MathSet() {
        array = (Type[]) new Object[size];
    }

    public MathSet(Type[] values) {
        array = (Type[]) new Object[size];
        for (Type value : values) {
            add(value);
        }
    }

    public MathSet(int cap) {
        capacity = cap;
        array = (Type[]) new Object[size];
    }

    public MathSet(Type[]... values) {
        array = (Type[]) new Object[size];
        for (Type[] value : values) {
            for (int i = 0; i < value.length; i++) {
                add(value[i]);
            }
        }
    }

    public MathSet(MathSet<Type> set) {
        array = (Type[]) new Object[size];
        Type[] setArray = set.toArray();
        for (int i = 0; i < set.sizeOf(); i++) {
            add(setArray[i]);
        }
    }

    public MathSet(MathSet<Type>... set) {
        array = (Type[]) new Object[size];
        Type[] setArray;
        for (MathSet sets : set) {
            setArray = (Type[]) sets.toArray();
            for (int i = 0; i < sets.sizeOf(); i++) {
                add(setArray[i]);
            }
        }
    }

    public void add(Type value) {
        if (isUnique(value)) {
            if (capacity > 0) {
                if (iterator < capacity) {
                    if (iterator < size) {
                        array[iterator] = value;
                        iterator++;
                    } else {
                        Type[] copyArray = (Type[]) new Object[size * 2];
                        for (int i = 0; i < iterator; i++) {
                            copyArray[i] = array[i];
                        }
                        array = copyArray;
                        array[iterator] = value;
                        iterator++;
                        size *= 2;
                    }
                } else {
                    System.out.println("End of array.");
                    return;
                }
            } else if (capacity == 0) {
                if (iterator < size) {
                    array[iterator] = value;
                    iterator++;
                } else {
                    Type[] copyArray = (Type[]) new Object[size * 2];
                    for (int i = 0; i < iterator; i++) {
                        copyArray[i] = array[i];
                    }
                    array = copyArray;
                    array[iterator] = value;
                    iterator++;
                    size *= 2;
                }
            }
        }
    }

    public void add(Type... value) {
        for (Type i : value) {
            add(i);
        }
    }

    public void join(MathSet<Type> set) {
        Type[] setArray = set.toArray();
        for (int i = 0; i < set.sizeOf(); i++) {
            add(setArray[i]);
        }
    }

    public void join(MathSet<Type>... set) {
        for (MathSet<Type> setArray : set) {
            join(setArray);
        }
    }

    public void intersection(MathSet<Type> set) {
        Type[] setArray = set.toArray();
        MathSet<Type> copySet = new MathSet<>();
        for (int i = 0; i < set.sizeOf(); i++) {
            for (int j = 0; j < iterator; j++) {
                if (Double.parseDouble(array[j].toString()) == Double.parseDouble(setArray[i].toString())) {
                    if (array[j].toString().length() > setArray[i].toString().length()) {
                        copySet.add(array[j]);
                    } else copySet.add(setArray[i]);
                }
            }
        }
        iterator = copySet.sizeOf();
        array = copySet.toArray();
    }

    public void intersection(MathSet<Type>... set) {
        for (MathSet<Type> sets : set) {
            intersection(sets);
        }
    }

    public void sortDesc() {
        Type temporary;
        while (!isSortedDesc(array)) {
            for (int i = 0; i < iterator - 1; i++) {
                for (int j = i; j < iterator - 1; j++) {
                    if (isSmaller(array[j], array[j + 1])) {
                        temporary = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temporary;
                    }
                }
            }
        }
    }

    public void sortDesc(int firstIndex, int lastIndex) {
        Type temporary;
        Type[] tempArray = (Type[]) new Object[lastIndex - firstIndex + 1];
        int n = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            tempArray[n] = array[i];
            n++;
        }

        while (!isSortedDesc(tempArray)) {
            for (int i = 0; i < tempArray.length - 1; i++) {
                for (int j = i; j < tempArray.length - 1; j++) {
                    if (isSmaller(tempArray[j], tempArray[j + 1])) {
                        temporary = tempArray[j];
                        tempArray[j] = tempArray[j + 1];
                        tempArray[j + 1] = temporary;
                    }
                }
            }
        }
        n = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            array[i] = tempArray[n];
            n++;
        }
    }

    public void sortDesc(Type value) {
        for (int i = 0; i < iterator; i++) {
            if (array[i].toString().equals(value.toString())) {
                sortDesc(i, iterator - 1);
                break;
            }
        }
    }

    public void sortAsc() {
        Type temporary;
        while (!isSortedAsc(array)) {
            for (int i = 0; i < iterator - 1; i++) {
                for (int j = i; j < iterator - 1; j++) {
                    if (isBigger(array[j], array[j + 1])) {
                        temporary = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temporary;
                    }
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        Type temporary;
        Type[] tempArray = (Type[]) new Object[lastIndex - firstIndex + 1];
        int n = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            tempArray[n] = array[i];
            n++;
        }

        while (!isSortedAsc(tempArray)) {
            for (int i = 0; i < tempArray.length - 1; i++) {
                for (int j = i; j < tempArray.length - 1; j++) {
                    if (isBigger(tempArray[j], tempArray[j + 1])) {
                        temporary = tempArray[j];
                        tempArray[j] = tempArray[j + 1];
                        tempArray[j + 1] = temporary;
                    }
                }
            }
        }
        n = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            array[i] = tempArray[n];
            n++;
        }
    }

    public void sortAsc(Type value) {
        for (int i = 0; i < iterator; i++) {
            if (array[i].toString().equals(value.toString())) {
                sortAsc(i, iterator - 1);
                break;
            }
        }
    }

    public Type get(int index) {
        return array[index];
    }

    public Type getMax() {
        Type max = array[0];

        for (int i = 0; i < iterator; i++) {
            if (isBigger(array[i], max)) {
                max = array[i];
            }
        }

        return max;
    }

    public Type getMin() {
        Type min = array[0];

        for (int i = 0; i < iterator; i++) {
            if (isSmaller(array[i], min)) {
                min = array[i];
            }
        }

        return min;
    }

    public Number getAverage() {
        Double summary = 0.0;
        Number result;

        for (int i = 0; i < iterator; i++) {
            summary += Double.parseDouble(array[i].toString());
        }

        result = summary / (iterator);

        return result;
    }

    public Number getMedian() {
        MathSet copySet = new MathSet(this);
        copySet.sortAsc();
        copySet.print();
        int position = iterator % 2;
        Double result;

        if (position == 1) {
            return Double.parseDouble(copySet.toArray()[iterator / 2].toString());
        } else {
            result = (Double.parseDouble(copySet.toArray()[iterator / 2].toString()) + Double.parseDouble(copySet.toArray()[iterator / 2 - 1].toString()));
            return result / 2;
        }
    }

    public Type[] toArray() {
        return array;
    }

    public Type[] toArray(int firstIndex, int lastIndex) {
        Type[] copyArray = (Type[]) new Number[lastIndex - firstIndex + 1];
        int n = 0;
        for (int i = firstIndex; i <= lastIndex; i++) {
            copyArray[n] = array[i];
            n++;
        }
        return copyArray;
    }

    public MathSet cut(int firstIndex, int lastIndex) {
        MathSet<Type> set;
        int n = 0;
        Type[] copyArray = (Type[]) new Number[lastIndex - firstIndex + 1];
        for (int i = firstIndex; i <= lastIndex; i++) {
            copyArray[n] = array[i];
            n++;
        }
        set = new MathSet<>(copyArray);
        return set;
    }

    public void clear() {
        array = null;
        iterator = 0;
    }

    public void clear(Type[] values) {
        for (int i = 0; i < values.length; i++) {
            for (int n = 0; n < iterator; n++) {
                if (Double.parseDouble(array[n].toString()) == Double.parseDouble(values[i].toString())) {
                    for (int j = n; j < iterator - 1; j++) {
                        array[j] = array[j + 1];
                    }
                    iterator--;
                }
            }
        }
    }

    private boolean isSortedDesc(Type[] arr) {
        if (arr == array) {
            for (int i = 0; i < iterator - 1; i++) {
                if (arr[i].toString().contains(".")) {
                    if (arr[i + 1].toString().contains(".")) {
                        if (Double.parseDouble(arr[i].toString()) < Double.parseDouble(arr[i + 1].toString()))
                            return false;
                    } else if (Double.parseDouble(arr[i].toString()) < Long.parseLong(arr[i + 1].toString()))
                        return false;
                } else if (arr[i + 1].toString().contains(".")) {
                    if (Long.parseLong(arr[i].toString()) < Double.parseDouble(arr[i + 1].toString()))
                        return false;
                } else if (Long.parseLong(arr[i].toString()) < Long.parseLong(arr[i + 1].toString()))
                    return false;
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].toString().contains(".")) {
                    if (arr[i + 1].toString().contains(".")) {
                        if (Double.parseDouble(arr[i].toString()) < Double.parseDouble(arr[i + 1].toString()))
                            return false;
                    } else if (Double.parseDouble(arr[i].toString()) < Long.parseLong(arr[i + 1].toString()))
                        return false;
                } else if (arr[i + 1].toString().contains(".")) {
                    if (Long.parseLong(arr[i].toString()) < Double.parseDouble(arr[i + 1].toString()))
                        return false;
                } else if (Long.parseLong(arr[i].toString()) < Long.parseLong(arr[i + 1].toString()))
                    return false;
            }
        }
        return true;
    }

    private boolean isSortedAsc(Type[] arr) {
        if (arr == array) {
            for (int i = 0; i < iterator - 1; i++) {
                if (arr[i].toString().contains(".")) {
                    if (arr[i + 1].toString().contains(".")) {
                        if (Double.parseDouble(arr[i].toString()) > Double.parseDouble(arr[i + 1].toString()))
                            return false;
                    } else if (Double.parseDouble(arr[i].toString()) > Long.parseLong(arr[i + 1].toString()))
                        return false;
                } else if (arr[i + 1].toString().contains(".")) {
                    if (Long.parseLong(arr[i].toString()) > Double.parseDouble(arr[i + 1].toString()))
                        return false;
                } else if (Long.parseLong(arr[i].toString()) > Long.parseLong(arr[i + 1].toString()))
                    return false;
            }
        } else {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i].toString().contains(".")) {
                    if (arr[i + 1].toString().contains(".")) {
                        if (Double.parseDouble(arr[i].toString()) > Double.parseDouble(arr[i + 1].toString()))
                            return false;
                    } else if (Double.parseDouble(arr[i].toString()) > Long.parseLong(arr[i + 1].toString()))
                        return false;
                } else if (arr[i + 1].toString().contains(".")) {
                    if (Long.parseLong(arr[i].toString()) > Double.parseDouble(arr[i + 1].toString()))
                        return false;
                } else if (Long.parseLong(arr[i].toString()) > Long.parseLong(arr[i + 1].toString()))
                    return false;
            }
        }
        return true;
    }

    private boolean isUnique(Type value) {
        Double valueD;
        Long valueI;
        if (iterator > 0) {
            for (int i = 0; i < iterator; i++) {

                if (value.toString().contains(".")) {
                    valueD = Double.parseDouble(value.toString());

                    if (Double.parseDouble(array[i].toString()) == valueD) {
                        if (valueD.toString().length() > array[i].toString().length()) {
                            array[i] = value;
                        }
                        return false;
                    }
                } else {
                    valueI = Long.parseLong(value.toString());
                    if (Double.parseDouble(array[i].toString()) == valueI) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void print() {
        for (int i = 0; i < iterator; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printArray(Type[] printArray) {
        for (int i = 0; i < printArray.length; i++) {
            System.out.print(printArray[i] + " ");
        }
        System.out.println();
    }

    public int sizeOf() {
        return iterator;
    }

    public int getCapacity() {
        return capacity;
    }

    public void increaseCapacity(int capacityIncrement) {
        capacity += capacityIncrement;
    }

    private Boolean isSmaller(Type valueOne, Type valueTwo) {
        if (valueOne.toString().contains(".")) {
            if (valueTwo.toString().contains(".")) {
                if (Double.parseDouble(valueOne.toString()) > Double.parseDouble(valueTwo.toString()))
                    return false;
            } else if (Double.parseDouble(valueOne.toString()) > Long.parseLong(valueTwo.toString()))
                return false;
        } else if (valueTwo.toString().contains(".")) {
            if (Long.parseLong(valueOne.toString()) > Double.parseDouble(valueTwo.toString()))
                return false;
        } else if (Long.parseLong(valueOne.toString()) > Long.parseLong(valueTwo.toString()))
            return false;

        return true;
    }

    private Boolean isBigger(Type valueOne, Type valueTwo) {
        if (valueOne.toString().contains(".")) {
            if (valueTwo.toString().contains(".")) {
                if (Double.parseDouble(valueOne.toString()) < Double.parseDouble(valueTwo.toString()))
                    return false;
            } else if (Double.parseDouble(valueOne.toString()) < Long.parseLong(valueTwo.toString()))
                return false;
        } else if (valueTwo.toString().contains(".")) {
            if (Long.parseLong(valueOne.toString()) < Double.parseDouble(valueTwo.toString()))
                return false;
        } else if (Long.parseLong(valueOne.toString()) < Long.parseLong(valueTwo.toString()))
            return false;

        return true;
    }
}
