package ua.com.alevel.lib;

public interface BaseSet<Type> {

    void add(Type value);
    void add(Type... value);
    void join(Set<Type> set);
    void join(Set<Type>... set);
    void intersection(Set<Type> set);
    void intersection(Set<Type>... set);
    void sortDesc();
    void sortDesc(int firstIndex, int lastIndex);
    void sortDesc(Type value);
    void sortAsc();
    void sortAsc(int firstIndex, int lastIndex);
    void sortAsc(Type value);
    Type get(int index);
    Type getMax();
    Type getMin();
    Type getAverage();
    Type getMedian();
    Type[] toArray();
    Type[] toArray(int firstIndex, int lastIndex);
    Set cut(int firstIndex, int lastIndex);
    void clear();
    void clear(Type[] values);

}
