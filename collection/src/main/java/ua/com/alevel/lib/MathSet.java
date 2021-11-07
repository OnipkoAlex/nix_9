package ua.com.alevel.lib;

public class MathSet<Number> {

    private Number[] mathSetArr;
    private int iterator = 0;
    private int capacity = 0;
    private int size = 10;

    /*public MathSet() {
        mathSetArr = (Number[]) new Number[size];
    }*/

    public MathSet(int capacity) {
        this.capacity = capacity;
        mathSetArr = (Number[]) new MathSet[size];
    }

    public MathSet(Number[] numbers) {
        mathSetArr = (Number[]) new MathSet[size];
        for (int i = 0; i < numbers.length; i++) {
            add(numbers[i]);
        }
    }

    public void add(Number number) {
        if (capacity == 0) {
            if (iterator == size) {
                Number[] copyMathSetArray = (Number[]) new MathSet[size*2];
                mathSetArr = copyMathSetArray;
                mathSetArr[iterator] = number;
                iterator++;
                size *= 2;
            }
            else {
                mathSetArr[iterator] = number;
                iterator++;
            }
        } else if (capacity > 0) {
            if (iterator < capacity) {
                if (iterator == size) {
                    Number[] copyMathSetArray = (Number[]) new MathSet[size*2];
                    mathSetArr = copyMathSetArray;
                    mathSetArr[iterator] = number;
                    iterator++;
                    size *= 2;
                }
                else {
                    mathSetArr[iterator] = number;
                    iterator++;
                }
            }
            else throw new ArrayIndexOutOfBoundsException("Index > capacity");
        } else throw new IllegalArgumentException("Capacity < 0");
    }

    public void add(Number... number) {
        for (Number i : number) {
            add(i);
        }
    }

    public Number[] toArray() {
        return mathSetArr;
    }

    public void print() {
        System.out.println("iterator = " + iterator);
        for (int i = 0; i < iterator; i++) {
            System.out.print(mathSetArr[i] + " ");
        }
    }
}
