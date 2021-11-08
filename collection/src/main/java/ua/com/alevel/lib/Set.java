package ua.com.alevel.lib;

import java.util.Comparator;

public class Set<Type> implements BaseSet<Type>, Comparable<Type>, Comparator<Type> {

    private Type[] array;
    private int size = 10;
    private int capacity = 0;
    private int iterator = 0;

    public Set() {

    }

    public Set(Type[] values) {
        for (Type value : values) {
            add(value);
        }
    }

    public Set(int cap) {
        capacity = cap;
    }

    public Set(Type[]... values) {
        for (Type[] value : values) {
            for (int i = 0; i < value.length; i++) {
                add(value[i]);
            }
        }
    }

    public Set(Set<Type> set) {
        Type[] setArray = set.toArray();
        for (Type i : setArray) {
            add(i);
        }
    }

    public Set(Set<Type>... set) {
        Type[] setArray;
        for (Set sets : set) {
            setArray = (Type[]) sets.toArray();
            for (Type i : setArray) {
                add(i);
            }
        }
    }

    @Override
    public void add(Type value) {
        if (isUnique(value)) {
            if (capacity > 0) {
                if (iterator < capacity) {
                    if (iterator < size) {
                        array[iterator] = value;
                        iterator++;
                    }
                    else {
                        Type[] copyArray = new Type[size * 2];
                        for (int i = 0; i < iterator; i++) {
                            copyArray[i] = array[i];
                        }
                        array = copyArray;
                        array[iterator] = value;
                        iterator++;
                        size *= 2;
                    }
                }
                else {
                    System.out.println("End of array.");
                    return;
                }
            }
            else if (capacity == 0) {
                if (iterator < size) {
                    array[iterator] = value;
                    iterator++;
                }
                else {
                    Type[] copyArray = new Type[size * 2];
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

    @Override
    public void add(Type... value) {
        for(Type i : value) {
            add(i);
        }
    }

    @Override
    public void join(Set<Type> set) {
        Type[] setArray = set.toArray();
        for (Type i : setArray) {
            add(i);
        }
    }

    @Override
    public void join(Set<Type>... set) {
        Type[] setArray;
        for (Set sets : set) {
            setArray = sets.toArray();
            for (Type i : setArray) {
                add(i);
            }
        }
    }

    @Override
    public void intersection(Set set) {

    }

    @Override
    public void intersection(Set... set) {

    }

    @Override
    public void sortDesc() {
        Type temporary;
        while (!isSortedDesc()) {
            for (int i = 0; i < iterator - 1; i++) {
                for (int j = i; j < iterator - 1; j++) {
                    if (mathSetArr[j].intValue() < mathSetArr[j + 1].intValue()) {
                        temporary = mathSetArr[j];
                        mathSetArr[j] = mathSetArr[j + 1];
                        mathSetArr[j + 1] = temporary;
                    }
                }
            }
        }
    }

    @Override
    public void sortDesc(int firstIndex, int lastIndex) {

    }

    @Override
    public void sortDesc(Type value) {

    }

    @Override
    public void sortAsc() {

    }

    @Override
    public void sortAsc(int firstIndex, int lastIndex) {

    }

    @Override
    public void sortAsc(Type value) {

    }

    @Override
    public Type get(int index) {
        return null;
    }

    @Override
    public Type getMax() {
        return null;
    }

    @Override
    public Type getMin() {
        return null;
    }

    @Override
    public Type getAverage() {
        return null;
    }

    @Override
    public Type getMedian() {
        return null;
    }

    @Override
    public Type[] toArray() {
        return array;
    }

    @Override
    public Type[] toArray(int firstIndex, int lastIndex) {
        Type[] copyArray = new Type[lastIndex - firstIndex + 1];
        for (int i = firstIndex; i < lastIndex; i++) {
            copyArray[i] = array[i];
        }
        return copyArray;
    }

    @Override
    public Set cut(int firstIndex, int lastIndex) {
        return null;
    }

    @Override
    public void clear() {
        array = null;
        iterator = 0;
    }

    @Override
    public void clear(Type[] values) {

    }

    private boolean isSortedDesc() {
        Comparator<Type> comparator;
        for (int i = 0; i < iterator - 1; i++) {
            if (Comparator.compare(array[i], array[i + 1]) > 0) return false;
        }
        return true;
    }

    private boolean isUnique(Type value) {
        for (int i = 0; i < iterator; i++) {
            if (array[i] == value) return false;
        }
        return true;
    }

    @Override
    public int compareTo(Type o) {
        return 0;
    }

    @Override
    public int compare(Type o1, Type o2) {
        return o2 - o1;
    }
}
