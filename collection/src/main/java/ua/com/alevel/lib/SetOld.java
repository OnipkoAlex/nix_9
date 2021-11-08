package ua.com.alevel.lib;

public class SetOld<Type> {

    private Type[] mathSetArr;
    private int iterator = 0;
    private int capacity = 0;
    private int size = 10;

    /*public MathSet() {
        mathSetArr = (Number[]) new Number[size];
    }*/

    public SetOld(int capacity) {
        this.capacity = capacity;
        mathSetArr = (Type[]) new SetOld[size];
    }

    public SetOld(Type[] numbers) {
        mathSetArr = (Type[]) new SetOld[size];
        for (int i = 0; i < numbers.length; i++) {
            add(numbers[i]);
        }
    }

    public void add(Type number) {
        if (capacity == 0) {
            if (iterator == size) {
                Type[] copyMathSetArray = (Type[]) new SetOld[size*2];
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
                    Type[] copyMathSetArray = (Type[]) new SetOld[size*2];
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

    public void add(Type... number) {
        for (Type i : number) {
            add(i);
        }
    }

    public Type[] toArray() {
        return mathSetArr;
    }

    public void print() {
        System.out.println("iterator = " + iterator);
        for (int i = 0; i < iterator; i++) {
            System.out.print(mathSetArr[i] + " ");
        }
    }
}
