package ua.com.alevel.lib;

public class MathSetOld<Number> {

    private Number[] mathSetArr;
    private int iterator = 0;
    private int capacity = 0;
    private int size = 10;

    public MathSetOld() {
        mathSetArr = (Number[]) new MathSetOld[size];
    }

    public MathSetOld(int capacity) {
        this.capacity = capacity;
        mathSetArr = (Number[]) new MathSetOld[size];
    }

    public MathSetOld(Number[] numbers) {
        mathSetArr = (Number[]) new MathSetOld[size];
        add(numbers);
    }

    public MathSetOld(Number[]... numbers) {
    }

    public MathSetOld(MathSetOld numbers) {
    }

    public MathSetOld(MathSetOld... numbers) {

    }

    public void add(Number number) {
        System.out.println(iterator);
        if (capacity == 0) {
            if (iterator == size) {
                Number[] mathSetCopyArr = (Number[]) new MathSetOld[size * 2];
                for (int i = 0; i < iterator; i++) {
                    mathSetCopyArr[i] = mathSetArr[i];
                }
                mathSetArr = mathSetCopyArr;
                mathSetArr[iterator] = number;
                iterator++;
                size *= 2;
            } else {
                mathSetArr[iterator] = number;
                iterator++;
            }
            makeUnique();
        }
        else if (capacity > 0){
            if (iterator < capacity && iterator == size) {
                Number[] mathSetCopyArr = (Number[]) new MathSetOld[size * 2];
                for (int i = 0; i < iterator; i++) {
                    mathSetCopyArr[i] = mathSetArr[i];
                }
                mathSetArr = mathSetCopyArr;
                mathSetArr[iterator] = number;
                iterator++;
                size *= 2;
            } else if (iterator < capacity && iterator < size){
                mathSetArr[iterator] = number;
                iterator++;
            }
            makeUnique();
        }
        else throw new IllegalArgumentException();
    }

    public void add(Number... number) {
        for (Number i : number) {
            add(i);
        }
    }

/*    public void join(MathSet joinMathSet) {
        for (int i = 0; i < joinMathSet.iterator; i++) {
            add(joinMathSet.toArray()[i]);
        }
    }*/

/*    public void join(MathSet... joinMathSet) {
        for (MathSet i : joinMathSet) {
            join(i);
        }
    }*/

    public Number[] toArray() {
        return mathSetArr;
    }

    /*public void sortDesc() {
        Number temporary;
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

    public void sortDesc(int firstIndex, int lastIndex) {
        Number temporary;
        while (!isSortedDesc()) {
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                for (int j = i; j < lastIndex - 1; j++) {
                    if (mathSetArr[j].intValue() < mathSetArr[j + 1].intValue()) {
                        temporary = mathSetArr[j];
                        mathSetArr[j] = mathSetArr[j + 1];
                        mathSetArr[j + 1] = temporary;
                    }
                }
            }
        }
    }

    public void sortDesc(Number value) {
        for (int k = 0; k < iterator; k++) {
            if (mathSetArr[k].equals(value)) {
                sortDesc(k, iterator);
            }
        }
    }

    public void sortAsc() {
        Number temporary;
        while (!isSortedAsc()) {
            for (int i = 0; i < iterator - 1; i++) {
                for (int j = i; j < iterator - 1; j++) {
                    if (mathSetArr[j].intValue() > mathSetArr[j + 1].intValue()) {
                        temporary = mathSetArr[j];
                        mathSetArr[j] = mathSetArr[j + 1];
                        mathSetArr[j + 1] = temporary;
                    }
                }
            }
        }
    }

    public void sortAsc(int firstIndex, int lastIndex) {
        Number temporary;
        while (!isSortedAsc()) {
            for (int i = firstIndex; i < lastIndex - 1; i++) {
                for (int j = i; j < lastIndex - 1; j++) {
                    if (mathSetArr[j].intValue() > mathSetArr[j + 1].intValue()) {
                        temporary = mathSetArr[j];
                        mathSetArr[j] = mathSetArr[j + 1];
                        mathSetArr[j + 1] = temporary;
                    }
                }
            }
        }
    }

    public void sortAsc(Number value) {
        for (int k = 0; k < iterator; k++) {
            if (mathSetArr[k].equals(value)) {
                sortAsc(k, iterator);
            }
        }
    }

    private boolean isSortedDesc() {
        for (int i = 0; i < iterator - 1; i++) {
            if (mathSetArr[i].intValue() < mathSetArr[i + 1].intValue()) return false;
        }
        return true;
    }

    private boolean isSortedAsc() {
        for (int i = 0; i < iterator - 1; i++) {
            if (mathSetArr[i].intValue() > mathSetArr[i + 1].intValue()) return false;
        }
        return true;
    }*/

    public Number get(int index) {
        return mathSetArr[index];
    }

    /*public Number getMax() {
        Number max = mathSetArr[0].intValue();

        for (int i = 0; i < iterator; i++) {
            if (mathSetArr[i].intValue() > max.intValue()) max = mathSetArr[i];
        }

        return max;
    }

    public Number getMin() {
        Number min = mathSetArr[0].intValue();

        for (int i = 0; i < iterator; i++) {
            if (mathSetArr[i].intValue() < min.intValue()) min = mathSetArr[i];
        }

        return min;
    }

    public Number getMedian() {
        MathSet tempMathSet = new MathSet(mathSetArr);
        tempMathSet.sortAsc();
        Number[] tempArray = tempMathSet.toArray();

        if ((iterator - 1) % 2 == 0) {
            return (tempArray[(iterator - 1) / 2 - 1].longValue() + tempArray[(iterator - 1) / 2].longValue()) / 2;
        } else return tempArray[(iterator - 1) / 2 - 1];

    }*/

    /*public Number getAverage() {

    }*/

    public void print() {
        System.out.println("iterator = " + iterator);
        for (int i = 0; i < iterator; i++) {
            System.out.print(mathSetArr[i] + " ");
        }
    }

    private void makeUnique() {
        Number example = mathSetArr[0];
        for (int i = 1; i < iterator; i++) {
            if (mathSetArr[i].equals(example)) {
                for (int j = i; j < iterator - 1; j++) {
                    mathSetArr[j] = mathSetArr[j + 1];
                }
                iterator--;
            }
            example = mathSetArr[i];
        }
    }

    public int size() {
        return iterator;
    }
}
